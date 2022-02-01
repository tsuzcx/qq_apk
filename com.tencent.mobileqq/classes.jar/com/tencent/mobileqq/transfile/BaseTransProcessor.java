package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class BaseTransProcessor
  implements AppConstants.RichMediaErrorCode, INetEngineListener, ITransProcessor, ProtoReqManagerImpl.IProtoRespBack, RichProtoProc.RichProtoCallback, IHttpCommunicatorListener
{
  public static final String FILE_AST_DIR = "ast";
  public static final String FILE_PTT_DIR = "ptt";
  public static final String TAG = "BaseTransProcessor";
  private static ArrayList<TransProcessorHandler> handlerList = new ArrayList();
  private static Object lock = new Object();
  public AppInterface app;
  StringBuilder costReport = new StringBuilder();
  private int currentProgress;
  public FileMsg file;
  protected long inQueueCost = 0L;
  protected boolean isDomainTest = false;
  boolean isReportValid = true;
  private String key;
  public BaseTransFileController mController;
  boolean mIsCancel = false;
  public boolean mIsPause = false;
  public boolean mIsRawPic = false;
  public boolean mIsShortVideoReceive = false;
  public boolean mIsShortVideoSend = false;
  public IHttpEngineService mNetEngine;
  NetReq mNetReq;
  int mNetworkChgRetryCount = 0;
  public ProcessorReport mProcessorReport = new ProcessorReport();
  protected int mProgress;
  protected RMServMonitorReport mRSMReporter = new RMServMonitorReport();
  RichProto.RichProtoReq mRichProtoReq;
  private int mState;
  private boolean mSupportFakeProgress = false;
  public TransferRequest mUiRequest;
  long reportTimeHt = 0L;
  long reportTimePicCache = 0L;
  long reportTimeTrans = 0L;
  protected int segmentNum = 0;
  
  public BaseTransProcessor() {}
  
  public BaseTransProcessor(BaseTransFileController paramBaseTransFileController)
  {
    this.mController = paramBaseTransFileController;
    this.app = paramBaseTransFileController.app;
    this.file = new FileMsg();
    this.mProcessorReport.mStartTime = System.nanoTime();
  }
  
  public BaseTransProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    this.app = paramBaseTransFileController.app;
    this.mProcessorReport.mStartTime = System.nanoTime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Processor Start Time = ");
    localStringBuilder.append(this.mProcessorReport.mStartTime);
    localStringBuilder.append("ns,Processor = ");
    localStringBuilder.append(this);
    TransFileUtil.printRichMediaDebug("BaseTransProcessor", "TimeCompare", localStringBuilder.toString());
    this.file = new FileMsg();
    this.mController = paramBaseTransFileController;
    this.mUiRequest = paramTransferRequest;
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.uinType = this.mUiRequest.mUinType;
    this.file.friendUin = this.mUiRequest.mPeerUin;
    this.file.actionType = (this.mUiRequest.mIsUp ^ true);
    this.mNetEngine = ((IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all"));
    fetchReportFlag();
  }
  
  public BaseTransProcessor(String paramString1, String paramString2, boolean paramBoolean, BaseTransFileController paramBaseTransFileController)
  {
    this.mController = paramBaseTransFileController;
    this.app = paramBaseTransFileController.app;
    this.mProcessorReport.mStartTime = System.nanoTime();
    this.file = new FileMsg(paramString1, paramString2, paramBoolean ^ true);
    this.file.processor = this;
  }
  
  public BaseTransProcessor(String paramString, boolean paramBoolean, BaseTransFileController paramBaseTransFileController)
  {
    this.mController = paramBaseTransFileController;
    this.app = paramBaseTransFileController.app;
    this.mProcessorReport.mStartTime = System.nanoTime();
    this.file = new FileMsg(paramString, null, paramBoolean ^ true);
    this.file.processor = this;
  }
  
  public static void addHandler(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (lock)
    {
      if (!handlerList.contains(paramTransProcessorHandler)) {
        handlerList.add(paramTransProcessorHandler);
      }
      return;
    }
  }
  
  private void collectTransStatistics(NetResp paramNetResp)
  {
    this.inQueueCost = paramNetResp.inQueueCost;
  }
  
  private void doSendProgressMessage()
  {
    FileMsg localFileMsg = this.file;
    if (localFileMsg != null)
    {
      if (localFileMsg.actionType == 0)
      {
        sendMessageToUpdate(1002);
        return;
      }
      sendMessageToUpdate(2002);
    }
  }
  
  public static String getExpStackString(Exception paramException)
  {
    return ProcessorReport.getExceptionMessage(paramException);
  }
  
  public static void removeHandler(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (lock)
    {
      handlerList.remove(paramTransProcessorHandler);
      return;
    }
  }
  
  public static void sendCustomMessageToUpdateDelay(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (lock)
    {
      if ((handlerList != null) && (!handlerList.isEmpty()))
      {
        Iterator localIterator = handlerList.iterator();
        while (localIterator.hasNext())
        {
          TransProcessorHandler localTransProcessorHandler = (TransProcessorHandler)localIterator.next();
          Object localObject2 = localTransProcessorHandler.getFilter();
          if (!((ArrayList)localObject2).isEmpty())
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()))
              {
                Message localMessage = localTransProcessorHandler.obtainMessage();
                localMessage.what = paramMessage.what;
                localMessage.obj = paramMessage.obj;
                localMessage.arg1 = paramMessage.arg1;
                localTransProcessorHandler.sendMessageDelayed(localMessage, paramLong);
              }
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramMessage;
    }
  }
  
  private void updateProgress()
  {
    if (this.mSupportFakeProgress)
    {
      int i = getRealProgress();
      if (i > this.mProgress) {
        this.mProgress = i;
      }
    }
  }
  
  public void accountChanged() {}
  
  void analysisIOProblem(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES"))
    {
      this.mProcessorReport.setError(9039, paramIOException, null, null);
      return;
    }
    if (paramIOException.contains("ENOSPC"))
    {
      this.mProcessorReport.setError(9040, paramIOException, null, null);
      return;
    }
    if (paramIOException.contains("Read-only"))
    {
      this.mProcessorReport.setError(9039, paramIOException, null, null);
      return;
    }
    if (!"mounted".equals(str)) {
      this.mProcessorReport.setError(9039, paramIOException, null, null);
    }
  }
  
  protected boolean canDoNextStep()
  {
    return (!this.mIsCancel) && (!this.mIsPause);
  }
  
  public int cancel()
  {
    Object localObject1 = this.mUiRequest;
    if (localObject1 != null)
    {
      int i;
      if (((TransferRequest)localObject1).mIsUp) {
        i = 1004;
      } else {
        i = 2004;
      }
      sendMessageToUpdate(i);
    }
    this.mIsCancel = true;
    if ((QLog.isColorLevel()) && (this.mUiRequest != null)) {
      logRichMediaEvent("cancel", "");
    }
    localObject1 = this.mRichProtoReq;
    if (localObject1 != null)
    {
      RichProtoProc.cancelRichProtoReq((RichProto.RichProtoReq)localObject1);
      this.mRichProtoReq = null;
    }
    localObject1 = this.mNetReq;
    if (localObject1 != null)
    {
      this.mNetEngine.cancelReq((NetReq)localObject1);
      this.mNetReq = null;
    }
    this.mController.removeProcessor(getKey());
    try
    {
      if (this.mUiRequest != null)
      {
        localObject1 = this.mUiRequest.mResult;
        if (localObject1 != null)
        {
          ((TransferResult)localObject1).mResult = -1;
          ((TransferResult)localObject1).mErrCode = 9037L;
          ((TransferResult)localObject1).mOrigReq = this.mUiRequest;
        }
      }
      if (this.mUiRequest != null) {
        logRichMediaEvent("cancel", "");
      }
      notifyAll();
      if (this.mUiRequest != null) {
        logRichMediaEvent("cancel", "");
      }
      return 0;
    }
    finally {}
  }
  
  public void cancelTransTimer() {}
  
  public int checkParam()
  {
    return 0;
  }
  
  void clearReprotInfo()
  {
    ProcessorReport localProcessorReport = this.mProcessorReport;
    localProcessorReport.errCode = 0;
    localProcessorReport.errDesc = "";
    localProcessorReport.mReportInfo.clear();
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  protected void doReport(boolean paramBoolean) {}
  
  public boolean errerOccered()
  {
    return this.mProcessorReport.errCode != 9001;
  }
  
  public void fetchReportFlag()
  {
    Object localObject = this.mProcessorReport;
    localObject = (Integer)ProcessorReport.sReportMap.get(this.mUiRequest.getKey());
    ProcessorReport localProcessorReport = this.mProcessorReport;
    boolean bool = false;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).intValue();
    }
    localProcessorReport.mReportedFlag = i;
    localObject = this.mProcessorReport;
    if (this.mUiRequest.mDbRecVersion < 3) {
      bool = true;
    }
    ((ProcessorReport)localObject).mIsOldDbRec = bool;
  }
  
  public int getCurrentProgress()
  {
    return this.currentProgress;
  }
  
  public FileMsg getFileMsg()
  {
    return this.file;
  }
  
  public long getFileSize()
  {
    return this.file.fileSize;
  }
  
  public long getFileStatus()
  {
    return this.file.status;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public long getLastFileStatus()
  {
    return this.file.lastStatus;
  }
  
  public int getProgress()
  {
    if (this.mSupportFakeProgress) {
      return this.mProgress;
    }
    FileMsg localFileMsg = this.file;
    if ((localFileMsg != null) && (localFileMsg.fileSize > 0L)) {
      return (int)(this.file.transferedSize * 100L / this.file.fileSize);
    }
    return 0;
  }
  
  protected IProtoReqManager getProtoReqManager()
  {
    return (IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, "");
  }
  
  public int getRealProgress()
  {
    FileMsg localFileMsg = this.file;
    int i;
    if ((localFileMsg != null) && (localFileMsg.fileSize > 0L))
    {
      int j = (int)(this.file.transferedSize * 100L / this.file.fileSize);
      i = j;
      if (this.file.actionType == 0) {
        if (this.file.fileType != 1)
        {
          i = j;
          if (this.file.fileType != 131075) {}
        }
        else
        {
          i = j;
          if (j == 100)
          {
            i = j;
            if (this.file.status != 1003) {
              return 99;
            }
          }
        }
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  protected String getReportTAG()
  {
    return null;
  }
  
  protected int getState()
  {
    return this.mState;
  }
  
  public TransferRequest getTransferRequest()
  {
    return this.mUiRequest;
  }
  
  public long getTransferedSize()
  {
    return this.file.transferedSize;
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void handleRedirect(String paramString) {}
  
  boolean isAppValid()
  {
    return (this.app.isRunning()) && (this.app.isLogin());
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  public boolean isRawPic()
  {
    return this.mIsRawPic;
  }
  
  protected boolean isRetry(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg2 == null) {
      return false;
    }
    paramHttpMsg1 = paramHttpMsg2.getErrorString();
    return (paramHttpMsg1 == null) || (!paramHttpMsg1.contains("HttpCommunicator closed or msg caceled!"));
  }
  
  public void logRichMediaEvent(String paramString1, String paramString2)
  {
    if (this.file == null)
    {
      TransFileUtil.printRichMediaError("BaseTransProcessor", "logRichMediaEvent", "file is null !");
      return;
    }
    int i = -1;
    TransferRequest localTransferRequest = this.mUiRequest;
    if (localTransferRequest != null) {
      i = localTransferRequest.mUinType;
    }
    localTransferRequest = this.mUiRequest;
    boolean bool;
    if (localTransferRequest != null) {
      bool = localTransferRequest.mIsUp;
    }
    for (;;)
    {
      break;
      if (this.file.actionType == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
    TransFileUtil.log(TransFileUtil.getUinDesc(i), bool, RichMediaUtil.getFileTypeDesc(this.file.fileType), String.valueOf(this.file.uniseq), paramString1, paramString2);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp) {}
  
  void onError()
  {
    long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
    Object localObject = this.app;
    if ((localObject != null) && ((!((AppInterface)localObject).isLogin()) || (!this.app.isRunning()))) {
      this.mProcessorReport.setError(9366, "account switch", null, null);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("elapsed:");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(this.mProcessorReport.errCode);
    ((StringBuilder)localObject).append(" errDesc:");
    ((StringBuilder)localObject).append(this.mProcessorReport.errDesc);
    ((StringBuilder)localObject).append(" reason:");
    ((StringBuilder)localObject).append((String)this.mProcessorReport.mReportInfo.get("param_reason"));
    logRichMediaEvent("onError", ((StringBuilder)localObject).toString());
    doReport(false);
    this.mController.removeProcessor(getKey());
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq) {}
  
  public void onResp(NetResp paramNetResp)
  {
    collectTransStatistics(paramNetResp);
  }
  
  void onSuccess()
  {
    long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("elapsed:");
    localStringBuilder.append(l);
    localStringBuilder.append(",key:");
    localStringBuilder.append(getKey());
    logRichMediaEvent("onSuccess", localStringBuilder.toString());
    doReport(true);
    this.mController.removeProcessor(getKey());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void pause() {}
  
  public void resetTransTimer() {}
  
  public int resume()
  {
    return 0;
  }
  
  public void retry() {}
  
  protected void sendMessageToUpdate(int paramInt)
  {
    sendMessageToUpdateDelay(paramInt, 0L);
  }
  
  protected void sendMessageToUpdateDelay(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ret:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" currentProgress:");
    ((StringBuilder)localObject).append(this.currentProgress);
    ((StringBuilder)localObject).append(" mProgress:");
    ((StringBuilder)localObject).append(this.mProgress);
    logRichMediaEvent("updateUiState", ((StringBuilder)localObject).toString());
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.mProcessorReport.errCode == 9001))
    {
      localObject = this.mProcessorReport;
      localObject = ProcessorReport.getExceptionMessage(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", localObject);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
    }
    this.mProcessorReport.mEndTime = System.currentTimeMillis();
    long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
    boolean bool;
    if ((l <= 60000L) && (paramInt1 != 1005)) {
      bool = false;
    } else {
      bool = true;
    }
    if (l > 60000L)
    {
      RichMediaUtil.stopImageSendReport(true, "image_sending_too_long");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("image_sending_");
      ((StringBuilder)localObject).append(this.mProcessorReport.errCode);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mProcessorReport.errDesc);
      RichMediaUtil.stopImageSendReport(bool, ((StringBuilder)localObject).toString());
    }
    sendMsgToUpdateUIDelay(paramInt1, paramInt2, paramLong);
  }
  
  protected void sendMessageToUpdateDelay(int paramInt, long paramLong)
  {
    sendMessageToUpdateDelay(paramInt, 0, paramLong);
  }
  
  protected void sendMsgToUpdateUIDelay(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mIsCancel) {
      return;
    }
    synchronized (lock)
    {
      this.mState = paramInt1;
      if ((handlerList != null) && (!handlerList.isEmpty()))
      {
        Iterator localIterator = handlerList.iterator();
        while (localIterator.hasNext())
        {
          TransProcessorHandler localTransProcessorHandler = (TransProcessorHandler)localIterator.next();
          Object localObject3 = localTransProcessorHandler.getFilter();
          if (!((ArrayList)localObject3).isEmpty())
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (Class)((Iterator)localObject3).next();
              if (getClass().equals(localObject4))
              {
                localObject4 = localTransProcessorHandler.obtainMessage();
                this.file.lastStatus = this.file.status;
                this.file.status = paramInt1;
                ((Message)localObject4).what = paramInt1;
                ((Message)localObject4).obj = this.file;
                ((Message)localObject4).arg1 = paramInt2;
                localTransProcessorHandler.sendMessageDelayed((Message)localObject4, paramLong);
              }
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void sendProgressMessage()
  {
    if (this.file != null)
    {
      updateProgress();
      doSendProgressMessage();
    }
  }
  
  public void setCurrentProgress(int paramInt)
  {
    this.currentProgress = paramInt;
  }
  
  public void setFakeProgressCapable(boolean paramBoolean)
  {
    this.mSupportFakeProgress = paramBoolean;
  }
  
  public void setFileSize(long paramLong)
  {
    this.file.fileSize = paramLong;
  }
  
  public void setId(long paramLong)
  {
    this.file.setFileId(paramLong);
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  protected void setMtype() {}
  
  public void setPicTrumbSize(long paramLong)
  {
    this.file.picThumbSize = paramLong;
  }
  
  public void setReportFlag()
  {
    ProcessorReport localProcessorReport = this.mProcessorReport;
    ProcessorReport.sReportMap.put(this.mUiRequest.getKey(), Integer.valueOf(this.mProcessorReport.mReportedFlag));
    localProcessorReport = this.mProcessorReport;
    if (ProcessorReport.sReportMap.size() > 2000)
    {
      localProcessorReport = this.mProcessorReport;
      ProcessorReport.sReportMap.clear();
    }
  }
  
  public void setTransType(int paramInt)
  {
    this.file.setFileType(paramInt);
  }
  
  public void start() {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void stop() {}
  
  protected void timeout() {}
  
  public void updateMessageDataBaseContent(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor
 * JD-Core Version:    0.7.0.1
 */