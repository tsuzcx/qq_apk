package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import bdlg;
import bhbx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.report.HttpEngineReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class OldHttpEngine$OldHttpCommunicatorListner
  implements IHttpCommunicatorListener
{
  boolean appError = false;
  public HttpMsg httpMsg;
  public HttpNetReq httpReq;
  boolean initError = false;
  int mConnReusedErrorCount = 0;
  int mContinueError = 0;
  int mEofErrorExtraCount = 5;
  public AtomicBoolean mIsCancelled = new AtomicBoolean(false);
  int mLastReqReturnBytes = 0;
  public OutputStream mOut;
  public RandomAccessFile mOutFile;
  int mStartNetTypeOfLocal = 0;
  String mTempPath = null;
  public NetResp netResp;
  
  public OldHttpEngine$OldHttpCommunicatorListner(OldHttpEngine paramOldHttpEngine) {}
  
  private long getDelayTime(NetResp paramNetResp, long paramLong)
  {
    if ((paramNetResp.mErrCode == 9056) && (paramLong != 0L)) {
      return 0L;
    }
    if (paramLong != 0L) {
      return 3000L;
    }
    return 6000L;
  }
  
  private void onOutEngine()
  {
    boolean bool = true;
    if (this.mIsCancelled.get()) {
      return;
    }
    HttpNetReq localHttpNetReq = this.httpReq;
    NetResp localNetResp = this.netResp;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localHttpNetReq != null)
    {
      localOutputStream = this.mOut;
      localRandomAccessFile = this.mOutFile;
      if ((localHttpNetReq.mOutPath == null) || (localOutputStream == null)) {}
    }
    try
    {
      localOutputStream.close();
      if (localRandomAccessFile == null) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localRandomAccessFile.close();
        if (localNetResp != null)
        {
          if ((localHttpNetReq.mKey != null) && (localNetResp.mResult != 3)) {
            OldHttpEngine.access$200(this.this$0).remove(localHttpNetReq.mKey);
          }
          new HttpEngineReport(localHttpNetReq, localNetResp).doReport();
          if (localHttpNetReq.mCallback != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localHttpNetReq.mBusiProtoType;
              if (localHttpNetReq.mHttpMethod != 1) {
                break label259;
              }
              RichMediaUtil.log(i, bool, localHttpNetReq.mFileType, localHttpNetReq.mMsgId, "onOutEngine", "result:" + localNetResp.mResult + " errCode:" + localNetResp.mErrCode + " desc:" + localNetResp.mErrDesc);
            }
            if ((localNetResp.mErrCode == 9367) && (QLog.isColorLevel())) {
              break label264;
            }
            localHttpNetReq.mCallback.onResp(localNetResp);
          }
        }
        clearForGC();
        return;
        localIOException2 = localIOException2;
        localIOException2.printStackTrace();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localIOException1.printStackTrace();
          continue;
          label259:
          bool = false;
          continue;
          label264:
          bdlg.a("Http_Download_Queen_Full", this.this$0.mHttpExcuter.getFullQueue());
        }
      }
    }
  }
  
  private boolean resetOutPut(NetResp paramNetResp, HttpNetReq paramHttpNetReq)
  {
    if (paramNetResp.mWrittenBlockLen > 0L)
    {
      if (!paramHttpNetReq.isWriteToStream()) {
        break label46;
      }
      if (paramHttpNetReq.mBreakDownFix == null) {
        break label44;
      }
      paramHttpNetReq.mBreakDownFix.fixReq(paramHttpNetReq, paramNetResp);
      this.mOut = paramHttpNetReq.mOutStream;
    }
    label44:
    label46:
    while (!paramHttpNetReq.isWriteToFile())
    {
      return true;
      return false;
    }
    if (paramHttpNetReq.mBreakDownFix != null)
    {
      paramHttpNetReq.mBreakDownFix.fixReq(paramHttpNetReq, paramNetResp);
      return true;
    }
    if (this.mOut != null) {
      try
      {
        this.mOut.close();
        this.mOut = new FileOutputStream(this.mTempPath);
        paramNetResp.mWrittenBlockLen = 0L;
        return true;
      }
      catch (IOException paramHttpNetReq)
      {
        analysisIOProblem(paramHttpNetReq, paramNetResp);
      }
    }
    return false;
  }
  
  private void retrySync(HttpNetReq paramHttpNetReq)
  {
    int i;
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      i = paramHttpNetReq.mBusiProtoType;
      if (paramHttpNetReq.mHttpMethod != 1) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      RichMediaUtil.log(i, bool, paramHttpNetReq.mFileType, paramHttpNetReq.mMsgId, "retrySync", "mIsCancelled:" + this.mIsCancelled);
      if (this.netResp != null) {
        this.netResp.mLastReqStartTime = System.currentTimeMillis();
      }
      if (NetworkCenter.getInstance().getNetType() == 0) {
        break;
      }
      this.this$0.innerSendReq(this.httpReq, true);
      return;
    }
    this.httpMsg.setHttpErrorCode(9004, -1, "nonetwork");
    onOutEngine();
  }
  
  private void scheduleRetry(long paramLong, HttpNetReq paramHttpNetReq)
  {
    int i;
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      i = paramHttpNetReq.mBusiProtoType;
      if (paramHttpNetReq.mHttpMethod != 1) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      RichMediaUtil.log(i, bool, paramHttpNetReq.mFileType, paramHttpNetReq.mMsgId, "scheduleRetry", "mIsCancelled:" + this.mIsCancelled);
      if (!this.mIsCancelled.get()) {
        break;
      }
      return;
    }
    if (this.netResp != null) {
      this.netResp.mLastReqStartTime = System.currentTimeMillis();
    }
    if (NetworkCenter.getInstance().getNetType() != 0)
    {
      if ((this.this$0.mWorking.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, paramHttpNetReq), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
      {
        i = paramHttpNetReq.mBusiProtoType;
        if (paramHttpNetReq.mHttpMethod != 1) {
          break label237;
        }
      }
      label237:
      for (bool = true;; bool = false)
      {
        RichMediaUtil.log(i, bool, paramHttpNetReq.mFileType, paramHttpNetReq.mMsgId, "scheduleRetry", "mIsCancelled:" + this.mIsCancelled);
        if (this.mIsCancelled.get()) {
          break;
        }
        this.this$0.innerSendReq(this.httpReq, false);
        return;
      }
    }
    if (this.this$0.mWorking.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, paramHttpNetReq), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      i = paramHttpNetReq.mBusiProtoType;
      if (paramHttpNetReq.mHttpMethod != 1) {
        break label332;
      }
    }
    label332:
    for (bool = true;; bool = false)
    {
      RichMediaUtil.log(i, bool, paramHttpNetReq.mFileType, paramHttpNetReq.mMsgId, "scheduleRetry", "mWorking is false");
      if (!this.mIsCancelled.get()) {
        break;
      }
      return;
    }
  }
  
  private boolean shouldRetry(HttpMsg paramHttpMsg, HttpNetReq paramHttpNetReq, NetResp paramNetResp)
  {
    return (!this.appError) && (paramHttpMsg.permitRetry()) && (paramNetResp.mConsumeTime < paramHttpNetReq.mExcuteTimeLimit - 5000L) && (this.mContinueError <= paramHttpNetReq.mContinuErrorLimit);
  }
  
  void analysisIOProblem(IOException paramIOException, NetResp paramNetResp)
  {
    if (this.mIsCancelled.get()) {}
    do
    {
      return;
      paramNetResp = paramIOException.getMessage();
      this.netResp.setResult(1, 9301, paramNetResp + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (paramNetResp.contains("EACCES"))
        {
          this.netResp.mErrCode = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((paramNetResp.contains("ENOSPC")) || (paramNetResp.contains("space")))
      {
        long l = bhbx.b();
        if (this.httpReq != null)
        {
          paramIOException = this.httpReq.mOutPath;
          paramNetResp = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + paramNetResp.listFiles().length + ",url:" + this.httpReq.mReqUrl + ",availableSpace:" + l);
        }
        this.netResp.mErrCode = 9040;
        return;
      }
      if (paramNetResp.contains("Read-only"))
      {
        this.netResp.mErrCode = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.netResp.mErrCode = 9039;
  }
  
  public void calErrCount(NetResp paramNetResp, long paramLong, boolean paramBoolean)
  {
    if ((paramNetResp.mErrCode == 9056) && (paramLong < 2000L))
    {
      int i = this.mEofErrorExtraCount;
      this.mEofErrorExtraCount = (i - 1);
      if (i <= 0) {}
    }
    for (;;)
    {
      if ((paramNetResp.mErrCode == 9056) || (paramNetResp.mErrCode == 9051)) {
        this.mConnReusedErrorCount += 1;
      }
      return;
      if (paramBoolean) {
        this.mContinueError += 1;
      }
    }
  }
  
  void clearForGC()
  {
    this.mIsCancelled.set(true);
    HttpNetReq localHttpNetReq = this.httpReq;
    if (localHttpNetReq != null) {
      localHttpNetReq.mPrivate = null;
    }
    this.httpReq = null;
    this.netResp = null;
    this.mOut = null;
  }
  
  void copyProperties(HttpMsg paramHttpMsg)
  {
    NetResp localNetResp = this.netResp;
    if ((this.mIsCancelled.get()) || (localNetResp == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localNetResp.mRespProperties;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (paramHttpMsg.responsePropertys.containsKey(HttpMsg.Param_Reason)) {
      localHashMap1.put("netresp_param_reason", paramHttpMsg.responsePropertys.get(HttpMsg.Param_Reason));
    }
    localNetResp.mRespProperties.clear();
    localNetResp.mRespProperties.putAll(localHashMap1);
    localNetResp.mRespProperties.putAll(paramHttpMsg.responsePropertys);
    localNetResp.mRespProperties.put("param_rspHeader", paramHttpMsg.rawRespHeader);
    localNetResp.mRespProperties.put("param_reqHeader", paramHttpMsg.rawReqHeader);
    localNetResp.mHttpCode = paramHttpMsg.getResponseCode();
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.mIsCancelled.get()) {}
    label310:
    do
    {
      for (;;)
      {
        return;
        this.mContinueError = 0;
        if (this.httpReq != null) {
          try
          {
            if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200))
            {
              arrayOfByte = paramHttpMsg2.getRecvData();
              HttpNetReq.IFlowDecoder localIFlowDecoder = this.httpReq.decoder;
              paramHttpMsg1 = arrayOfByte;
              if (localIFlowDecoder == null) {}
            }
          }
          catch (IOException paramHttpMsg1)
          {
            try
            {
              byte[] arrayOfByte;
              paramHttpMsg1 = this.httpReq.decoder.decode(arrayOfByte);
              if (paramHttpMsg1 == null) {
                continue;
              }
              int i = paramHttpMsg1.length;
              if (i <= 0) {
                continue;
              }
              this.mLastReqReturnBytes += paramHttpMsg1.length;
              if (this.mOut == null) {
                break label310;
              }
              this.mOut.write(paramHttpMsg1);
              this.mOut.flush();
              this.netResp.mTotalFileLen = paramHttpMsg2.getTotalLen();
              this.netResp.mTotalBlockLen = paramHttpMsg2.totalBlockLen;
              paramHttpMsg2 = this.netResp;
              paramHttpMsg2.mWrittenBlockLen += paramHttpMsg1.length;
              if (this.httpReq.mCallback == null) {
                continue;
              }
              this.httpReq.mCallback.onUpdateProgeress(this.httpReq, this.netResp.mWrittenBlockLen + this.httpReq.mStartDownOffset, this.netResp.mTotalFileLen);
              return;
            }
            catch (Throwable paramHttpMsg1)
            {
              paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
              throw new RuntimeException("FlowDecoderExp:" + paramHttpMsg1.substring(0, Math.min(100, paramHttpMsg1.length())));
            }
            paramHttpMsg1 = paramHttpMsg1;
            paramHttpMsg1.printStackTrace();
            this.appError = true;
            analysisIOProblem(paramHttpMsg1, this.netResp);
            throw new RuntimeException("io exceptionmsg:" + paramHttpMsg1.getMessage());
          }
        }
      }
      if (this.mOutFile == null) {
        break;
      }
      if (this.mOutFile.length() == 0L) {
        this.mOutFile.setLength(paramHttpMsg2.totalBlockLen);
      }
      this.mOutFile.write(paramHttpMsg1);
      this.netResp.mTotalFileLen = paramHttpMsg2.getTotalLen();
      this.netResp.mTotalBlockLen = paramHttpMsg2.totalBlockLen;
      paramHttpMsg2 = this.netResp;
      paramHttpMsg2.mWrittenBlockLen += paramHttpMsg1.length;
    } while (this.httpReq.mCallback == null);
    this.httpReq.mCallback.onUpdateProgeress(this.httpReq, this.netResp.mWrittenBlockLen + this.httpReq.mStartDownOffset, this.netResp.mTotalFileLen);
    return;
    this.netResp.mTotalFileLen = paramHttpMsg2.getTotalLen();
    this.netResp.mTotalBlockLen = paramHttpMsg2.totalBlockLen;
    this.netResp.mRespData = paramHttpMsg2.getRecvData();
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    boolean bool2 = false;
    if (this.mIsCancelled.get()) {}
    HttpNetReq localHttpNetReq;
    NetResp localNetResp;
    do
    {
      return;
      localHttpNetReq = this.httpReq;
      localNetResp = this.netResp;
    } while ((localHttpNetReq == null) || (localNetResp == null));
    copyProperties(paramHttpMsg2);
    long l1 = System.currentTimeMillis() - localNetResp.mLastReqStartTime;
    localNetResp.mConsumeTime += l1;
    if ((localHttpNetReq.mServerList != null) && (localHttpNetReq.mServerList.size() >= 1)) {
      ((ServerAddr)localHttpNetReq.mServerList.get(0)).onFail();
    }
    long l2 = NetworkCenter.getInstance().getNetType();
    boolean bool1;
    if (l2 != 0L)
    {
      bool1 = true;
      calErrCount(localNetResp, l1, bool1);
      if (!this.appError)
      {
        localNetResp.mErrCode = paramHttpMsg2.errCode;
        localNetResp.mErrDesc = paramHttpMsg2.errString;
        localNetResp.mResult = 1;
        if (bool1) {
          break label231;
        }
        localNetResp.mErrCode = 9004;
        localNetResp.mErrDesc = "no network";
        localNetResp.mResult = 1;
      }
    }
    for (;;)
    {
      if (this.mLastReqReturnBytes > 0) {
        bool2 = true;
      }
      if (!shouldRetry(paramHttpMsg2, localHttpNetReq, localNetResp)) {
        break label254;
      }
      handleRetry(localHttpNetReq, bool2, localNetResp, paramHttpMsg2, paramHttpMsg1, bool1, l2);
      return;
      bool1 = false;
      break;
      label231:
      if (localHttpNetReq.mFailedListener != null) {
        localHttpNetReq.mFailedListener.onFailed(localNetResp);
      }
    }
    label254:
    onOutEngine();
  }
  
  public void handleRedirect(String paramString)
  {
    if ((this.netResp != null) && (this.httpMsg != null))
    {
      this.netResp.mRedirectTime = (SystemClock.uptimeMillis() - this.httpMsg.startTime);
      paramString = this.netResp;
      paramString.mRedirectCount += 1;
    }
  }
  
  void handleRetry(HttpNetReq paramHttpNetReq, boolean paramBoolean1, NetResp paramNetResp, HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, boolean paramBoolean2, long paramLong)
  {
    boolean bool;
    int i;
    label66:
    long l;
    if (QLog.isColorLevel())
    {
      int j = paramHttpNetReq.mBusiProtoType;
      if (paramHttpNetReq.mHttpMethod == 1)
      {
        bool = true;
        int k = paramHttpNetReq.mFileType;
        paramHttpMsg1 = paramHttpNetReq.mMsgId;
        StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
        if (this.netResp == null) {
          break label220;
        }
        i = this.netResp.mTryTime;
        localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
        if (this.netResp == null) {
          break label226;
        }
        l = this.netResp.mConsumeTime;
        label97:
        RichMediaUtil.log(j, bool, k, paramHttpMsg1, "retry", l + " isLastGetData:" + paramBoolean1);
      }
    }
    else
    {
      paramBoolean1 = resetOutPut(paramNetResp, paramHttpNetReq);
      if (this.mConnReusedErrorCount >= paramHttpNetReq.mContinueConnReusedErrorLimit) {
        paramHttpNetReq.mReqProperties.put("Connection", "close");
      }
      if (paramBoolean1) {
        break label237;
      }
      if (QLog.isColorLevel())
      {
        i = paramHttpNetReq.mBusiProtoType;
        if (paramHttpNetReq.mHttpMethod != 1) {
          break label232;
        }
      }
    }
    label220:
    label226:
    label232:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      RichMediaUtil.log(i, paramBoolean1, paramHttpNetReq.mFileType, paramHttpNetReq.mMsgId, "retry", "breakDownAllowRetry is false ");
      onOutEngine();
      return;
      bool = false;
      break;
      i = 0;
      break label66;
      l = 0L;
      break label97;
    }
    label237:
    if (paramHttpNetReq.decoder != null) {
      paramHttpNetReq.decoder.reset();
    }
    if ((paramHttpNetReq.mNeedIpConnect) && (paramHttpNetReq.mHaveIpConnect)) {
      InnerDns.getInstance().reportBadIp(InnerDns.getHostFromUrl(paramHttpNetReq.mReqUrl), InnerDns.getHostFromUrl(paramHttpMsg2.getUrl()), 1002);
    }
    if ((paramHttpNetReq.mServerList != null) && (paramHttpNetReq.mServerList.size() >= 1) && (paramBoolean2))
    {
      paramHttpMsg1 = (ServerAddr)paramHttpNetReq.mServerList.remove(0);
      paramHttpNetReq.mServerList.add(paramHttpMsg1);
      paramHttpMsg1 = (ServerAddr)paramHttpNetReq.mServerList.get(0);
      if (paramHttpNetReq.mReqUrl != null)
      {
        paramHttpMsg1 = paramHttpMsg1.getServerUrl(paramHttpNetReq.mReqUrl);
        paramHttpNetReq.mReqUrl = RichMediaUtil.replaceIp(paramHttpNetReq.mReqUrl, paramHttpMsg1);
      }
    }
    if ((paramNetResp.mErrCode == 9050) && (paramHttpNetReq.mTimeoutParam != null)) {
      paramHttpNetReq.mTimeoutParam.adjustConnectTimeout(this.mContinueError);
    }
    paramLong = getDelayTime(paramNetResp, paramLong);
    if (this.httpMsg.mIsSync)
    {
      retrySync(paramHttpNetReq);
      return;
    }
    scheduleRetry(paramLong, paramHttpNetReq);
  }
  
  public void init()
  {
    this.mStartNetTypeOfLocal = NetworkCenter.getInstance().getNetType();
    Object localObject = this.httpReq;
    NetResp localNetResp = this.netResp;
    if ((localObject == null) || (localNetResp == null))
    {
      this.initError = true;
      return;
    }
    label368:
    int i;
    if (((HttpNetReq)localObject).mOutPath != null)
    {
      for (;;)
      {
        try
        {
          this.mTempPath = setTempPath(((HttpNetReq)localObject).mOutPath, ((HttpNetReq)localObject).mReqUrl);
          localNetResp.mReq.mTempPath = this.mTempPath;
          localFile = new File(this.mTempPath);
          if (!localFile.exists()) {
            break label368;
          }
          l = localFile.length();
          if ((l <= 0L) || (((HttpNetReq)localObject).mBreakDownFix == null)) {
            continue;
          }
          localNetResp.mWrittenBlockLen = l;
          ((HttpNetReq)localObject).mBreakDownFix.fixReq((NetReq)localObject, localNetResp);
          if (!((HttpNetReq)localObject).mUseRaf) {
            continue;
          }
          this.mOutFile = new RandomAccessFile(localFile, "rw");
          this.mOutFile.seek(((HttpNetReq)localObject).mStartDownOffset);
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.OldHttpEngine", 2, "append.oring Len:" + l);
          }
        }
        catch (IOException localIOException)
        {
          File localFile;
          long l;
          localIOException.printStackTrace();
          this.initError = true;
          analysisIOProblem(localIOException, localException);
          continue;
          if (!((HttpNetReq)localObject).mUseRaf) {
            continue;
          }
          this.mOutFile = new RandomAccessFile(localIOException, "rw");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.richmedia.OldHttpEngine", 2, "oring Len:" + l + " trunk");
          continue;
          this.mOut = new FileOutputStream(localIOException);
          continue;
        }
        try
        {
          localObject = new URL(((HttpNetReq)localObject).mReqUrl).getHost();
          localNetResp.mRespProperties.put("firstserverip", localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.mOut = new FileOutputStream(localFile, true);
      }
      if (QLog.isColorLevel())
      {
        i = ((HttpNetReq)localObject).mBusiProtoType;
        if (((HttpNetReq)localObject).mHttpMethod != 1) {
          break label486;
        }
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      RichMediaUtil.log(i, bool, ((HttpNetReq)localObject).mFileType, ((HttpNetReq)localObject).mMsgId, "createtmp", this.mTempPath);
      FileUtils.createFile(this.mTempPath);
      if (((HttpNetReq)localObject).mUseRaf)
      {
        this.mOutFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.mOut = new FileOutputStream(localIOException);
      break;
      if (((HttpNetReq)localObject).mOutStream == null) {
        break;
      }
      this.mOut = ((HttpNetReq)localObject).mOutStream;
      break;
    }
  }
  
  public void onFlowEvent(HttpMsg paramHttpMsg) {}
  
  void release(NetReq paramNetReq)
  {
    try
    {
      if ((paramNetReq.mOutPath != null) && (this.mOut != null)) {
        this.mOut.close();
      }
      if (this.mOutFile == null) {}
    }
    catch (IOException paramNetReq)
    {
      for (;;)
      {
        try
        {
          this.mOutFile.close();
          return;
        }
        catch (IOException paramNetReq)
        {
          paramNetReq.printStackTrace();
        }
        paramNetReq = paramNetReq;
        paramNetReq.printStackTrace();
      }
    }
  }
  
  public void saveData()
  {
    int j = 0;
    this.netResp.mResult = 0;
    this.netResp.mErrCode = 0;
    this.netResp.mErrDesc = "";
    int i = j;
    if (this.mTempPath != null)
    {
      i = j;
      if (this.mTempPath.equalsIgnoreCase(this.httpReq.mOutPath)) {
        i = 1;
      }
    }
    if (this.httpReq.mOutPath != null) {}
    try
    {
      if ((this.httpReq.mIsRenameInEngine) && (i == 0) && (FileUtils.fileExists(this.httpReq.mOutPath))) {
        FileUtils.deleteFile(this.httpReq.mOutPath);
      }
    }
    catch (Exception localIOException1)
    {
      try
      {
        if (this.mOut == null) {
          break label130;
        }
        this.mOut.close();
        label130:
        if (!this.httpReq.mUseRaf) {
          break label154;
        }
      }
      catch (IOException localIOException1)
      {
        try
        {
          for (;;)
          {
            if (this.mOutFile != null) {
              this.mOutFile.close();
            }
            label154:
            if (this.httpReq.mIsRenameInEngine) {
              break;
            }
            return;
            localException = localException;
            localException.printStackTrace();
          }
          localIOException1 = localIOException1;
          localIOException1.printStackTrace();
        }
        catch (IOException localIOException2)
        {
          do
          {
            for (;;)
            {
              localIOException2.printStackTrace();
            }
          } while ((i != 0) || (FileUtils.rename(this.mTempPath, this.httpReq.mOutPath)) || (this.mTempPath == null));
          if (!FileUtils.copyFile(this.mTempPath, this.httpReq.mOutPath)) {
            break label250;
          }
          new File(this.mTempPath).delete();
          return;
          label250:
          this.netResp.setResult(1, 9301, "rename file failed", null);
          new File(this.mTempPath).delete();
        }
      }
    }
    if (this.httpReq.mOutPath != null) {}
  }
  
  public String setTempPath(String paramString1, String paramString2)
  {
    this.mTempPath = OldHttpEngine.access$100(this.httpReq, paramString1, paramString2);
    return this.mTempPath;
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    int i = 0;
    if (this.mIsCancelled.get()) {}
    while (paramInt != 5) {
      return true;
    }
    copyProperties(paramHttpMsg2);
    if (this.httpReq.saveRecvDataInTransLayer()) {
      saveData();
    }
    for (;;)
    {
      if (paramHttpMsg1.cost != 0L) {
        this.netResp.reqCost = paramHttpMsg1.cost;
      }
      this.netResp.inQueueCost = paramHttpMsg1.inQueueCost;
      onOutEngine();
      return true;
      this.netResp.mResult = 0;
      this.netResp.mErrCode = 0;
      this.netResp.mErrDesc = "";
      if (((this.netResp.mRespData != null) && (this.netResp.mRespData.length != this.netResp.mTotalBlockLen)) || ((this.netResp.mRespData == null) && (this.netResp.mTotalBlockLen != 0L)))
      {
        this.netResp.setResult(1, -9527, null, null);
        paramHttpMsg2 = BaseTransProcessor.getServerReason("Q", -9533L);
        this.netResp.mRespProperties.put("netresp_param_reason", paramHttpMsg2);
        paramHttpMsg2 = this.netResp;
        StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
        paramInt = i;
        if (this.netResp.mRespData != null) {
          paramInt = this.netResp.mRespData.length;
        }
        paramHttpMsg2.mErrDesc = (paramInt + " totalBlockLen:" + this.netResp.mTotalBlockLen);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner
 * JD-Core Version:    0.7.0.1
 */