package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.util.HashMap;

public class ScribblePicUploadProcessor
  extends BaseUploadProcessor
{
  public static final int SCRIBBLE_COMMAND_ID = 41;
  public static final String TAG = "ScribblePicUploadProcessor";
  private byte[] mLocalMd52;
  private String mPicUrl = "";
  private byte[] mSessionKey;
  MediaMessageObserver messageObserver = new ScribblePicUploadProcessor.2(this);
  private Transaction trans = null;
  
  public ScribblePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.file.processor = this;
    this.file.bdhExtendInfo = paramTransferRequest.mExtentionInfo;
  }
  
  private void getBDHsessionkey()
  {
    try
    {
      if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
        this.mSessionKey = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSessionKey, 0, i);
      }
      if (this.mSessionKey == null) {
        HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
      }
      return;
    }
    finally {}
  }
  
  private void updateMsg(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  public void cancelTask()
  {
    if (this.trans != null) {
      this.app.getHwEngine().cancelTransactionTask(this.trans);
    }
  }
  
  public int checkParam()
  {
    Object localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
    Object localObject2 = new File((String)localObject1);
    StringBuilder localStringBuilder;
    if (!((File)localObject2).exists())
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFile not exist ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return -1;
    }
    if (!((File)localObject2).canRead())
    {
      localObject1 = this.mProcessorReport;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendFile not readable ");
      ((StringBuilder)localObject2).append(this.file.filePath);
      ((ProcessorReport)localObject1).setError(9070, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
      onError();
      return -1;
    }
    long l = ((File)localObject2).length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file size 0 ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9071, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return -1;
    }
    return super.checkParam();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if (!this.mProcessorReport.mIsOldDbRec)
    {
      int i = 2;
      if ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0))
      {
        if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
          return;
        }
        Object localObject = this.mProcessorReport;
        int j = this.mProcessorReport.mReportedFlag;
        if (!paramBoolean) {
          i = 1;
        }
        ((ProcessorReport)localObject).mReportedFlag = (i | j);
        this.mProcessorReport.mEndTime = System.currentTimeMillis();
        long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
        HashMap localHashMap = this.mProcessorReport.mReportInfo;
        localObject = this.mSessionKey;
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = PkgTools.toHexStr((byte[])localObject);
        }
        localHashMap.put("param_sessionKey", localObject);
        if (paramBoolean)
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "scribble_upload", true, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        else
        {
          if (this.mProcessorReport.errCode != -9527) {
            this.mProcessorReport.mReportInfo.remove("param_rspHeader");
          }
          this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
          this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
          this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "scribble_upload", false, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
      }
    }
  }
  
  protected long getBlockSize(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.mSSCMSpanned) {
      paramLong = Math.min(paramLong, this.sscmObject.a(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
    } else {
      paramLong = Math.min(paramLong, 14600L);
    }
    return Math.min(paramLong, 131072L);
  }
  
  byte[] getStreamData(int paramInt1, int paramInt2)
  {
    return super.getStreamData(paramInt1, paramInt2);
  }
  
  protected void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, paramString);
    }
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    Object localObject = (MessageForScribble)this.mUiRequest.mRec;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 2;
    }
    updateMsg((MessageForScribble)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onError()---- errCode: ");
    ((StringBuilder)localObject).append(this.mProcessorReport.errCode);
    ((StringBuilder)localObject).append(", errDesc:");
    ((StringBuilder)localObject).append(this.mProcessorReport.errDesc);
    QLog.e("ScribblePicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_Int = -1;
      ((UpCallBack.SendResult)localObject).b = this.mProcessorReport.errCode;
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_JavaLangString = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    sendMessageToUpdate(1003);
    Object localObject = (MessageForScribble)this.mUiRequest.mRec;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 1;
    }
    updateMsg((MessageForScribble)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "onSuccess().");
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_Int = 0;
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject);
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor.resume()");
    }
    cancelTask();
    sendFile();
    return 0;
  }
  
  public void sendFile()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject = new ScribblePicUploadProcessor.1(this, SystemClock.uptimeMillis());
    this.file.commandId = 41;
    this.trans = new Transaction(this.app.getCurrentAccountUin(), this.file.commandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mSessionKey, this.mLocalMd5, (ITransactionCallback)localObject, this.file.bdhExtendInfo);
    int i = this.app.getHwEngine().submitTransactionTask(this.trans);
    localObject = HexUtil.bytes2HexStr(this.mLocalMd5);
    String str = HexUtil.bytes2HexStr(this.mLocalMd52);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<BDH_LOG> Transaction submit RetCode:");
      localStringBuilder.append(i);
      localStringBuilder.append(" T_ID:");
      localStringBuilder.append(this.trans.getTransationId());
      localStringBuilder.append(" UniSeq:");
      localStringBuilder.append(this.mUiRequest.mUniseq);
      localStringBuilder.append(" MD51:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" MD52:");
      localStringBuilder.append(str);
      localStringBuilder.append(" uuid:");
      localStringBuilder.append(this.mUuid);
      localStringBuilder.append(" Path:");
      localStringBuilder.append(this.trans.filePath);
      localStringBuilder.append(" Cmd:");
      localStringBuilder.append(this.file.commandId);
      QLog.i("ScribblePicUploadProcessor", 2, localStringBuilder.toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  protected void sendMsg()
  {
    if (!canDoNextStep())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = ");
      ((StringBuilder)localObject).append(this.mChannelStatus);
      log(((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (MessageForScribble)this.mUiRequest.mRec;
    if (localObject != null)
    {
      ((MessageForScribble)localObject).combineFileUrl = this.mPicUrl;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPicUrl: ");
        localStringBuilder.append(this.mPicUrl);
        QLog.d("ScribblePicUploadProcessor", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TestPicSend finish upload,currentTime = ");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append(",processor = ");
        localStringBuilder.append(this);
        QLog.d("ScribblePicUploadProcessor", 2, localStringBuilder.toString());
      }
      this.mProcessorReport.mStepMsg.logStartTime();
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).sendMessage((MessageRecord)localObject, this.messageObserver);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!sendMessage uniseq:");
      localStringBuilder.append(((MessageForScribble)localObject).uniseq);
      QLog.i("SCRIBBLEMSG", 2, localStringBuilder.toString());
      return;
    }
    this.mProcessorReport.setError(-1, "MessageForScribble IS NULL", "", this.mProcessorReport.mStepTrans);
    onError();
  }
  
  public void start()
  {
    this.mPicUrl = "";
    super.start();
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScriblePicUploadProcessor.start()");
    }
    getBDHsessionkey();
    MessageForScribble localMessageForScribble = (MessageForScribble)this.mUiRequest.mRec;
    if (this.mLocalMd5 == null)
    {
      this.mLocalMd52 = HexUtil.hexStr2Bytes(localMessageForScribble.combineFileMd5);
      if (!getMd5())
      {
        onError();
        return;
      }
      localMessageForScribble.combineFileMd5 = HexUtil.bytes2HexStr(this.mLocalMd5);
    }
    if (this.mSessionKey != null)
    {
      sendFile();
      return;
    }
    QLog.e("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor get null BDHsession key.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */