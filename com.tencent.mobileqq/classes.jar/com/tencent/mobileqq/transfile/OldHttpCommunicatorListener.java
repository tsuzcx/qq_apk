package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.report.HttpEngineReport;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
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

public class OldHttpCommunicatorListener
  implements IHttpCommunicatorListener
{
  boolean appError = false;
  private final HttpEngineServiceImpl httpEngineService;
  public HttpMsg httpMsg;
  public HttpNetReq httpReq;
  public boolean initError = false;
  int mConnReusedErrorCount = 0;
  int mContinueError = 0;
  int mEofErrorExtraCount = 5;
  public AtomicBoolean mIsCancelled = new AtomicBoolean(false);
  public int mLastReqReturnBytes = 0;
  public OutputStream mOut;
  public RandomAccessFile mOutFile;
  int mStartNetTypeOfLocal = 0;
  String mTempPath = null;
  public NetResp netResp;
  
  public OldHttpCommunicatorListener(HttpEngineServiceImpl paramHttpEngineServiceImpl)
  {
    this.httpEngineService = paramHttpEngineServiceImpl;
  }
  
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
  
  private boolean resetOutPut(NetResp paramNetResp, HttpNetReq paramHttpNetReq)
  {
    long l = paramNetResp.mWrittenBlockLen;
    boolean bool = false;
    if (l > 0L) {
      if (paramHttpNetReq.isWriteToStream())
      {
        if (!paramHttpNetReq.mSupportBreakResume) {
          break label116;
        }
        fixBreakReq(paramHttpNetReq, paramNetResp);
        this.mOut = paramHttpNetReq.mOutStream;
      }
      else if (paramHttpNetReq.isWriteToFile())
      {
        if (paramHttpNetReq.mSupportBreakResume)
        {
          fixBreakReq(paramHttpNetReq, paramNetResp);
        }
        else
        {
          paramHttpNetReq = this.mOut;
          if (paramHttpNetReq == null) {
            break label116;
          }
          try
          {
            paramHttpNetReq.close();
            this.mOut = new FileOutputStream(this.mTempPath);
            paramNetResp.mWrittenBlockLen = 0L;
          }
          catch (IOException paramHttpNetReq)
          {
            analysisIOProblem(paramHttpNetReq, paramNetResp);
            return false;
          }
        }
      }
    }
    bool = true;
    label116:
    return bool;
  }
  
  private void retrySync(HttpNetReq paramHttpNetReq)
  {
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      String str = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      boolean bool;
      if (paramHttpNetReq.mHttpMethod == 1) {
        bool = true;
      } else {
        bool = false;
      }
      int i = paramHttpNetReq.mFileType;
      paramHttpNetReq = paramHttpNetReq.mMsgId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mIsCancelled:");
      localStringBuilder.append(this.mIsCancelled);
      TransFileUtil.log(str, bool, String.valueOf(i), paramHttpNetReq, "retrySync", localStringBuilder.toString());
    }
    paramHttpNetReq = this.netResp;
    if (paramHttpNetReq != null) {
      paramHttpNetReq.mLastReqStartTime = System.currentTimeMillis();
    }
    if (NetworkCenter.getInstance().getNetType() != 0)
    {
      this.httpEngineService.innerSendReq(this.httpReq, true);
      return;
    }
    this.httpMsg.setHttpErrorCode(9004, -1, "nonetwork");
    onOutEngine();
  }
  
  private void scheduleRetry(long paramLong, HttpNetReq paramHttpNetReq)
  {
    boolean bool;
    int i;
    Object localObject2;
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      localObject1 = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod == 1) {
        bool = true;
      } else {
        bool = false;
      }
      i = paramHttpNetReq.mFileType;
      localObject2 = paramHttpNetReq.mMsgId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mIsCancelled:");
      localStringBuilder.append(this.mIsCancelled);
      TransFileUtil.log((String)localObject1, bool, String.valueOf(i), (String)localObject2, "scheduleRetry", localStringBuilder.toString());
    }
    if (this.mIsCancelled.get()) {
      return;
    }
    Object localObject1 = this.netResp;
    if (localObject1 != null) {
      ((NetResp)localObject1).mLastReqStartTime = System.currentTimeMillis();
    }
    if (NetworkCenter.getInstance().getNetType() != 0)
    {
      if ((this.httpEngineService.mWorking.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpCommunicatorListener.1(this, paramHttpNetReq), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
      {
        localObject1 = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
        if (paramHttpNetReq.mHttpMethod == 1) {
          bool = true;
        } else {
          bool = false;
        }
        i = paramHttpNetReq.mFileType;
        paramHttpNetReq = paramHttpNetReq.mMsgId;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mIsCancelled:");
        ((StringBuilder)localObject2).append(this.mIsCancelled);
        TransFileUtil.log((String)localObject1, bool, String.valueOf(i), paramHttpNetReq, "scheduleRetry", ((StringBuilder)localObject2).toString());
      }
      if (this.mIsCancelled.get()) {
        return;
      }
      this.httpEngineService.innerSendReq(this.httpReq, false);
      return;
    }
    if (this.httpEngineService.mWorking.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpCommunicatorListener.2(this, paramHttpNetReq), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      localObject1 = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod == 1) {
        bool = true;
      } else {
        bool = false;
      }
      TransFileUtil.log((String)localObject1, bool, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "scheduleRetry", "mWorking is false");
    }
    if (this.mIsCancelled.get()) {}
  }
  
  private boolean shouldRetry(HttpMsg paramHttpMsg, HttpNetReq paramHttpNetReq, NetResp paramNetResp)
  {
    return (!this.appError) && (paramHttpMsg.permitRetry()) && (paramNetResp.mConsumeTime < paramHttpNetReq.mExcuteTimeLimit - 5000L) && (this.mContinueError <= paramHttpNetReq.mContinuErrorLimit);
  }
  
  void analysisIOProblem(IOException paramIOException, NetResp paramNetResp)
  {
    if (this.mIsCancelled.get()) {
      return;
    }
    paramNetResp = paramIOException.getMessage();
    Object localObject = this.netResp;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramNetResp);
    localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramIOException));
    ((NetResp)localObject).setResult(1, 9301, localStringBuilder.toString(), null);
    try
    {
      paramIOException = Environment.getExternalStorageState();
      if (paramNetResp.contains("EACCES"))
      {
        this.netResp.mErrCode = 9039;
        return;
      }
      if ((!paramNetResp.contains("ENOSPC")) && (!paramNetResp.contains("space")))
      {
        if (paramNetResp.contains("Read-only"))
        {
          this.netResp.mErrCode = 9039;
          return;
        }
        if (!"mounted".equals(paramIOException)) {
          this.netResp.mErrCode = 9039;
        }
      }
      else
      {
        long l = Utils.c();
        if (this.httpReq != null)
        {
          paramIOException = this.httpReq.mOutPath;
          paramNetResp = new File(paramIOException).getParentFile();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("no space error, outPath:");
          ((StringBuilder)localObject).append(paramIOException);
          ((StringBuilder)localObject).append(",fileCount:");
          ((StringBuilder)localObject).append(paramNetResp.listFiles().length);
          ((StringBuilder)localObject).append(",url:");
          ((StringBuilder)localObject).append(this.httpReq.mReqUrl);
          ((StringBuilder)localObject).append(",availableSpace:");
          ((StringBuilder)localObject).append(l);
          QLog.e("Q.richmedia.HttpEngineServiceImpl", 1, ((StringBuilder)localObject).toString());
        }
        this.netResp.mErrCode = 9040;
        return;
      }
    }
    catch (Exception paramIOException)
    {
      paramIOException.printStackTrace();
    }
  }
  
  public void calErrCount(NetResp paramNetResp, long paramLong, boolean paramBoolean)
  {
    if ((paramNetResp.mErrCode == 9056) && (paramLong < 2000L))
    {
      int i = this.mEofErrorExtraCount;
      this.mEofErrorExtraCount = (i - 1);
      if (i > 0) {}
    }
    else if (paramBoolean)
    {
      this.mContinueError += 1;
    }
    if ((paramNetResp.mErrCode == 9056) || (paramNetResp.mErrCode == 9051)) {
      this.mConnReusedErrorCount += 1;
    }
  }
  
  public void clearForGC()
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
    if (!this.mIsCancelled.get())
    {
      if (localNetResp == null) {
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
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.mIsCancelled.get()) {
      return;
    }
    this.mContinueError = 0;
    if (this.httpReq != null) {
      try
      {
        if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200))
        {
          byte[] arrayOfByte = paramHttpMsg2.getRecvData();
          HttpNetReq.IFlowDecoder localIFlowDecoder = this.httpReq.decoder;
          paramHttpMsg1 = arrayOfByte;
          if (localIFlowDecoder != null) {
            try
            {
              paramHttpMsg1 = this.httpReq.decoder.decode(arrayOfByte);
              if (paramHttpMsg1 != null)
              {
                int i = paramHttpMsg1.length;
                if (i > 0) {}
              }
              else
              {
                return;
              }
            }
            catch (Throwable paramHttpMsg1)
            {
              paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
              paramHttpMsg2 = new StringBuilder();
              paramHttpMsg2.append("FlowDecoderExp:");
              paramHttpMsg2.append(paramHttpMsg1.substring(0, Math.min(100, paramHttpMsg1.length())));
              throw new RuntimeException(paramHttpMsg2.toString());
            }
          }
          this.mLastReqReturnBytes += paramHttpMsg1.length;
          long l;
          if (this.mOut != null)
          {
            this.mOut.write(paramHttpMsg1);
            this.mOut.flush();
            this.netResp.mTotalFileLen = paramHttpMsg2.getTotalLen();
            this.netResp.mTotalBlockLen = paramHttpMsg2.totalBlockLen;
            paramHttpMsg2 = this.netResp;
            paramHttpMsg2.mWrittenBlockLen += paramHttpMsg1.length;
            if (this.httpReq.mCallback != null)
            {
              paramHttpMsg1 = this.httpReq.mCallback;
              paramHttpMsg2 = this.httpReq;
              l = this.netResp.mWrittenBlockLen;
              paramHttpMsg1.onUpdateProgeress(paramHttpMsg2, this.httpReq.mStartDownOffset + l, this.netResp.mTotalFileLen);
            }
          }
          else if (this.mOutFile != null)
          {
            if (this.mOutFile.length() == 0L) {
              this.mOutFile.setLength(paramHttpMsg2.totalBlockLen);
            }
            this.mOutFile.write(paramHttpMsg1);
            this.netResp.mTotalFileLen = paramHttpMsg2.getTotalLen();
            this.netResp.mTotalBlockLen = paramHttpMsg2.totalBlockLen;
            paramHttpMsg2 = this.netResp;
            paramHttpMsg2.mWrittenBlockLen += paramHttpMsg1.length;
            if (this.httpReq.mCallback != null)
            {
              paramHttpMsg1 = this.httpReq.mCallback;
              paramHttpMsg2 = this.httpReq;
              l = this.netResp.mWrittenBlockLen;
              paramHttpMsg1.onUpdateProgeress(paramHttpMsg2, this.httpReq.mStartDownOffset + l, this.netResp.mTotalFileLen);
            }
          }
          else
          {
            this.netResp.mTotalFileLen = paramHttpMsg2.getTotalLen();
            this.netResp.mTotalBlockLen = paramHttpMsg2.totalBlockLen;
            this.netResp.mRespData = paramHttpMsg2.getRecvData();
            return;
          }
        }
      }
      catch (IOException paramHttpMsg1)
      {
        paramHttpMsg1.printStackTrace();
        this.appError = true;
        analysisIOProblem(paramHttpMsg1, this.netResp);
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("io exceptionmsg:");
        paramHttpMsg2.append(paramHttpMsg1.getMessage());
        throw new RuntimeException(paramHttpMsg2.toString());
      }
    }
  }
  
  public void fixBreakReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if (paramNetReq != null)
    {
      if (paramNetResp == null) {
        return;
      }
      if ((paramNetReq instanceof HttpNetReq))
      {
        paramNetReq = (HttpNetReq)paramNetReq;
        paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
        StringBuilder localStringBuilder;
        if (0L == paramNetReq.mEndDownOffset)
        {
          paramNetResp.mWrittenBlockLen = 0L;
          paramNetResp = new StringBuilder();
          paramNetResp.append("bytes=");
          paramNetResp.append(paramNetReq.mStartDownOffset);
          paramNetResp.append("-");
          paramNetResp = paramNetResp.toString();
          paramNetReq.mReqProperties.put("Range", paramNetResp);
          paramNetResp = paramNetReq.mReqUrl;
          if ((paramNetResp != null) && (paramNetResp.contains("range=")))
          {
            paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramNetResp);
            localStringBuilder.append("range=");
            localStringBuilder.append(paramNetReq.mStartDownOffset);
            paramNetReq.mReqUrl = localStringBuilder.toString();
          }
        }
        else if ((paramNetReq.mStartDownOffset > 0L) && (paramNetReq.mEndDownOffset > 0L) && (paramNetReq.mStartDownOffset < paramNetReq.mEndDownOffset))
        {
          paramNetResp.mWrittenBlockLen = 0L;
          paramNetResp = new StringBuilder();
          paramNetResp.append("bytes=");
          paramNetResp.append(paramNetReq.mStartDownOffset);
          paramNetResp.append("-");
          paramNetResp.append(paramNetReq.mEndDownOffset);
          paramNetResp = paramNetResp.toString();
          paramNetReq.mReqProperties.put("Range", paramNetResp);
          paramNetResp = paramNetReq.mReqUrl;
          if (paramNetResp.contains("range="))
          {
            paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramNetResp);
            localStringBuilder.append("range=");
            localStringBuilder.append(paramNetReq.mStartDownOffset);
            localStringBuilder.append("-");
            localStringBuilder.append(paramNetReq.mEndDownOffset);
            paramNetReq.mReqUrl = localStringBuilder.toString();
          }
        }
      }
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.mIsCancelled.get()) {
      return;
    }
    HttpNetReq localHttpNetReq = this.httpReq;
    NetResp localNetResp = this.netResp;
    if (localHttpNetReq != null)
    {
      if (localNetResp == null) {
        return;
      }
      copyProperties(paramHttpMsg2);
      long l1 = System.currentTimeMillis() - localNetResp.mLastReqStartTime;
      localNetResp.mConsumeTime += l1;
      if ((localHttpNetReq.mServerList != null) && (localHttpNetReq.mServerList.size() >= 1)) {
        ((ServerAddr)localHttpNetReq.mServerList.get(0)).onFail();
      }
      long l2 = NetworkCenter.getInstance().getNetType();
      boolean bool1;
      if (l2 != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      calErrCount(localNetResp, l1, bool1);
      if (!this.appError)
      {
        localNetResp.mErrCode = paramHttpMsg2.errCode;
        localNetResp.mErrDesc = paramHttpMsg2.errString;
        localNetResp.mResult = 1;
        if (!bool1)
        {
          localNetResp.mErrCode = 9004;
          localNetResp.mErrDesc = "no network";
          localNetResp.mResult = 1;
        }
        else if (localHttpNetReq.mFailedListener != null)
        {
          localHttpNetReq.mFailedListener.onFailed(localNetResp);
        }
      }
      boolean bool2;
      if (this.mLastReqReturnBytes > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (shouldRetry(paramHttpMsg2, localHttpNetReq, localNetResp))
      {
        handleRetry(localHttpNetReq, bool2, localNetResp, paramHttpMsg2, paramHttpMsg1, bool1, l2);
        return;
      }
      onOutEngine();
    }
  }
  
  public void handleRedirect(String paramString)
  {
    paramString = this.netResp;
    if ((paramString != null) && (this.httpMsg != null))
    {
      paramString.mRedirectTime = (SystemClock.uptimeMillis() - this.httpMsg.startTime);
      paramString = this.netResp;
      paramString.mRedirectCount += 1;
    }
  }
  
  void handleRetry(HttpNetReq paramHttpNetReq, boolean paramBoolean1, NetResp paramNetResp, HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, boolean paramBoolean2, long paramLong)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      paramHttpMsg1 = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int j = paramHttpNetReq.mFileType;
      String str = paramHttpNetReq.mMsgId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryTime:");
      NetResp localNetResp = this.netResp;
      int i;
      if (localNetResp != null) {
        i = localNetResp.mTryTime;
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(" consumeTime:");
      localNetResp = this.netResp;
      long l;
      if (localNetResp != null) {
        l = localNetResp.mConsumeTime;
      } else {
        l = 0L;
      }
      localStringBuilder.append(l);
      localStringBuilder.append(" isLastGetData:");
      localStringBuilder.append(paramBoolean1);
      TransFileUtil.log(paramHttpMsg1, bool1, String.valueOf(j), str, "retry", localStringBuilder.toString());
    }
    paramBoolean1 = resetOutPut(paramNetResp, paramHttpNetReq);
    if (this.mConnReusedErrorCount >= paramHttpNetReq.mContinueConnReusedErrorLimit) {
      paramHttpNetReq.mReqProperties.put("Connection", "close");
    }
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel())
      {
        paramNetResp = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
        paramBoolean1 = bool2;
        if (paramHttpNetReq.mHttpMethod == 1) {
          paramBoolean1 = true;
        }
        TransFileUtil.log(paramNetResp, paramBoolean1, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "retry", "breakDownAllowRetry is false ");
      }
      onOutEngine();
      return;
    }
    if (paramHttpNetReq.decoder != null) {
      paramHttpNetReq.decoder.reset();
    }
    if ((paramHttpNetReq.mNeedIpConnect) && (paramHttpNetReq.mHaveIpConnect)) {
      BaseInnerDns.getInstance().reportBadIp(BaseInnerDns.getHostFromUrl(paramHttpNetReq.mReqUrl), BaseInnerDns.getHostFromUrl(paramHttpMsg2.getUrl()), 1002);
    }
    if ((paramHttpNetReq.mServerList != null) && (paramHttpNetReq.mServerList.size() >= 1) && (paramBoolean2))
    {
      paramHttpMsg1 = (ServerAddr)paramHttpNetReq.mServerList.remove(0);
      paramHttpNetReq.mServerList.add(paramHttpMsg1);
      paramHttpMsg1 = (ServerAddr)paramHttpNetReq.mServerList.get(0);
      if (paramHttpNetReq.mReqUrl != null)
      {
        paramHttpMsg1 = paramHttpMsg1.getServerUrl(paramHttpNetReq.mReqUrl);
        paramHttpNetReq.mReqUrl = TransFileUtil.replaceIp(paramHttpNetReq.mReqUrl, paramHttpMsg1);
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
    Object localObject1 = this.httpReq;
    NetResp localNetResp = this.netResp;
    if ((localObject1 != null) && (localNetResp != null)) {
      if (((HttpNetReq)localObject1).mOutPath == null) {}
    }
    for (;;)
    {
      try
      {
        this.mTempPath = HttpEngineServiceImpl.getTempPath(this.httpReq, ((HttpNetReq)localObject1).mReqUrl);
        localNetResp.mReq.mTempPath = this.mTempPath;
        Object localObject2 = new File(this.mTempPath);
        bool = ((File)localObject2).exists();
        if (bool)
        {
          long l = ((File)localObject2).length();
          if ((l > 0L) && (((HttpNetReq)localObject1).mSupportBreakResume))
          {
            localNetResp.mWrittenBlockLen = l;
            fixBreakReq((NetReq)localObject1, localNetResp);
            if (((HttpNetReq)localObject1).mUseRaf)
            {
              this.mOutFile = new RandomAccessFile((File)localObject2, "rw");
              this.mOutFile.seek(((HttpNetReq)localObject1).mStartDownOffset);
            }
            else
            {
              this.mOut = new FileOutputStream((File)localObject2, true);
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("append.oring Len:");
              ((StringBuilder)localObject2).append(l);
              QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            if (((HttpNetReq)localObject1).mUseRaf) {
              this.mOutFile = new RandomAccessFile((File)localObject2, "rw");
            } else {
              this.mOut = new FileOutputStream((File)localObject2);
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("oring Len:");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(" trunk");
              QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            String str = TransFileUtil.getUinDesc(((HttpNetReq)localObject1).mBusiProtoType);
            if (((HttpNetReq)localObject1).mHttpMethod != 1) {
              break label515;
            }
            bool = true;
            TransFileUtil.log(str, bool, String.valueOf(((HttpNetReq)localObject1).mFileType), ((HttpNetReq)localObject1).mMsgId, "createtmp", this.mTempPath);
          }
          FileUtils.createFile(this.mTempPath);
          if (((HttpNetReq)localObject1).mUseRaf) {
            this.mOutFile = new RandomAccessFile((File)localObject2, "rw");
          } else {
            this.mOut = new FileOutputStream((File)localObject2);
          }
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        this.initError = true;
        analysisIOProblem(localIOException, localNetResp);
      }
      if (((HttpNetReq)localObject1).mOutStream != null) {
        this.mOut = ((HttpNetReq)localObject1).mOutStream;
      }
      try
      {
        localObject1 = new URL(((HttpNetReq)localObject1).mReqUrl).getHost();
        localNetResp.mRespProperties.put("firstserverip", localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      this.initError = true;
      return;
      label515:
      boolean bool = false;
    }
  }
  
  public void onOutEngine()
  {
    if (this.mIsCancelled.get()) {
      return;
    }
    HttpNetReq localHttpNetReq = this.httpReq;
    NetResp localNetResp = this.netResp;
    if (localHttpNetReq != null)
    {
      OutputStream localOutputStream = this.mOut;
      RandomAccessFile localRandomAccessFile = this.mOutFile;
      if ((localHttpNetReq.mOutPath != null) && (localOutputStream != null)) {
        try
        {
          localOutputStream.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
      }
      if (localRandomAccessFile != null) {
        try
        {
          localRandomAccessFile.close();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
      if (localNetResp != null)
      {
        if ((localHttpNetReq.mKey != null) && (localNetResp.mResult != 3)) {
          this.httpEngineService.mDownloadingFiles.remove(localHttpNetReq.mKey);
        }
        new HttpEngineReport(localHttpNetReq, localNetResp).doReport();
        if (localHttpNetReq.mCallback != null)
        {
          if (QLog.isColorLevel())
          {
            String str1 = TransFileUtil.getUinDesc(localHttpNetReq.mBusiProtoType);
            int i = localHttpNetReq.mHttpMethod;
            boolean bool = true;
            if (i != 1) {
              bool = false;
            }
            i = localHttpNetReq.mFileType;
            String str2 = localHttpNetReq.mMsgId;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("result:");
            localStringBuilder.append(localNetResp.mResult);
            localStringBuilder.append(" errCode:");
            localStringBuilder.append(localNetResp.mErrCode);
            localStringBuilder.append(" desc:");
            localStringBuilder.append(localNetResp.mErrDesc);
            TransFileUtil.log(str1, bool, String.valueOf(i), str2, "onOutEngine", localStringBuilder.toString());
          }
          if (localNetResp.mErrCode == 9367) {
            QLog.isColorLevel();
          }
          localHttpNetReq.mCallback.onResp(localNetResp);
        }
      }
    }
    clearForGC();
  }
  
  public void release(NetReq paramNetReq)
  {
    try
    {
      if ((paramNetReq.mOutPath != null) && (this.mOut != null)) {
        this.mOut.close();
      }
    }
    catch (IOException paramNetReq)
    {
      paramNetReq.printStackTrace();
    }
    paramNetReq = this.mOutFile;
    if (paramNetReq != null) {
      try
      {
        paramNetReq.close();
        return;
      }
      catch (IOException paramNetReq)
      {
        paramNetReq.printStackTrace();
      }
    }
  }
  
  public void saveData()
  {
    Object localObject1 = this.netResp;
    int j = 0;
    ((NetResp)localObject1).mResult = 0;
    ((NetResp)localObject1).mErrCode = 0;
    ((NetResp)localObject1).mErrDesc = "";
    localObject1 = this.mTempPath;
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((String)localObject1).equalsIgnoreCase(this.httpReq.mOutPath)) {
        i = 1;
      }
    }
    if (this.httpReq.mOutPath != null)
    {
      try
      {
        if ((this.httpReq.mIsRenameInEngine) && (i == 0) && (FileUtils.fileExists(this.httpReq.mOutPath))) {
          FileUtils.deleteFile(this.httpReq.mOutPath);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (this.httpReq.mOutPath != null) {
        try
        {
          if (this.mOut != null) {
            this.mOut.close();
          }
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
      if (this.httpReq.mUseRaf) {
        try
        {
          if (this.mOutFile != null) {
            this.mOutFile.close();
          }
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveData, mTempPath:");
        ((StringBuilder)localObject2).append(this.mTempPath);
        QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, ((StringBuilder)localObject2).toString());
      }
      if (!this.httpReq.mIsRenameInEngine) {
        return;
      }
      if (i != 0) {
        return;
      }
      if (!FileUtils.rename(this.mTempPath, this.httpReq.mOutPath))
      {
        localObject2 = this.mTempPath;
        if (localObject2 != null)
        {
          if (FileUtils.copyFile((String)localObject2, this.httpReq.mOutPath))
          {
            new File(this.mTempPath).delete();
            return;
          }
          this.netResp.setResult(1, 9301, "rename file failed", null);
          new File(this.mTempPath).delete();
        }
      }
    }
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (this.mIsCancelled.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      copyProperties(paramHttpMsg2);
      if (this.httpReq.saveRecvDataInTransLayer())
      {
        saveData();
      }
      else
      {
        paramHttpMsg2 = this.netResp;
        paramInt = 0;
        paramHttpMsg2.mResult = 0;
        paramHttpMsg2.mErrCode = 0;
        paramHttpMsg2.mErrDesc = "";
        if (((paramHttpMsg2.mRespData != null) && (this.netResp.mRespData.length != this.netResp.mTotalBlockLen)) || ((this.netResp.mRespData == null) && (this.netResp.mTotalBlockLen != 0L)))
        {
          this.netResp.setResult(1, -9527, null, null);
          paramHttpMsg2 = HttpEngineServiceImpl.getServerReason("Q", -9533L);
          this.netResp.mRespProperties.put("netresp_param_reason", paramHttpMsg2);
          paramHttpMsg2 = this.netResp;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("recvSize:");
          if (this.netResp.mRespData != null) {
            paramInt = this.netResp.mRespData.length;
          }
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" totalBlockLen:");
          localStringBuilder.append(this.netResp.mTotalBlockLen);
          paramHttpMsg2.mErrDesc = localStringBuilder.toString();
        }
      }
      if (paramHttpMsg1.cost != 0L) {
        this.netResp.reqCost = paramHttpMsg1.cost;
      }
      this.netResp.inQueueCost = paramHttpMsg1.inQueueCost;
      onOutEngine();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpCommunicatorListener
 * JD-Core Version:    0.7.0.1
 */