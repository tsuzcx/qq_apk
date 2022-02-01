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
    if (paramNetResp.mWrittenBlockLen > 0L)
    {
      if (!paramHttpNetReq.isWriteToStream()) {
        break label41;
      }
      if (!paramHttpNetReq.mSupportBreakResume) {
        break label39;
      }
      fixBreakReq(paramHttpNetReq, paramNetResp);
      this.mOut = paramHttpNetReq.mOutStream;
    }
    label39:
    label41:
    while (!paramHttpNetReq.isWriteToFile())
    {
      return true;
      return false;
    }
    if (paramHttpNetReq.mSupportBreakResume)
    {
      fixBreakReq(paramHttpNetReq, paramNetResp);
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
    String str;
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      str = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod != 1) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      TransFileUtil.log(str, bool, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "retrySync", "mIsCancelled:" + this.mIsCancelled);
      if (this.netResp != null) {
        this.netResp.mLastReqStartTime = System.currentTimeMillis();
      }
      if (NetworkCenter.getInstance().getNetType() == 0) {
        break;
      }
      this.httpEngineService.innerSendReq(this.httpReq, true);
      return;
    }
    this.httpMsg.setHttpErrorCode(9004, -1, "nonetwork");
    onOutEngine();
  }
  
  private void scheduleRetry(long paramLong, HttpNetReq paramHttpNetReq)
  {
    String str;
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      str = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod != 1) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      TransFileUtil.log(str, bool, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "scheduleRetry", "mIsCancelled:" + this.mIsCancelled);
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
      if ((this.httpEngineService.mWorking.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpCommunicatorListener.1(this, paramHttpNetReq), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
      {
        str = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
        if (paramHttpNetReq.mHttpMethod != 1) {
          break label247;
        }
      }
      label247:
      for (bool = true;; bool = false)
      {
        TransFileUtil.log(str, bool, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "scheduleRetry", "mIsCancelled:" + this.mIsCancelled);
        if (this.mIsCancelled.get()) {
          break;
        }
        this.httpEngineService.innerSendReq(this.httpReq, false);
        return;
      }
    }
    if (this.httpEngineService.mWorking.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpCommunicatorListener.2(this, paramHttpNetReq), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (paramHttpNetReq != null))
    {
      str = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod != 1) {
        break label346;
      }
    }
    label346:
    for (bool = true;; bool = false)
    {
      TransFileUtil.log(str, bool, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "scheduleRetry", "mWorking is false");
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
        long l = Utils.b();
        if (this.httpReq != null)
        {
          paramIOException = this.httpReq.mOutPath;
          paramNetResp = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.HttpEngineServiceImpl", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + paramNetResp.listFiles().length + ",url:" + this.httpReq.mReqUrl + ",availableSpace:" + l);
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
  
  public void fixBreakReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (!(paramNetReq instanceof HttpNetReq));
          paramNetReq = (HttpNetReq)paramNetReq;
          paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
          if (0L != paramNetReq.mEndDownOffset) {
            break;
          }
          paramNetResp.mWrittenBlockLen = 0L;
          paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-";
          paramNetReq.mReqProperties.put("Range", paramNetResp);
          paramNetResp = paramNetReq.mReqUrl;
        } while ((paramNetResp == null) || (!paramNetResp.contains("range=")));
        paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.mReqUrl = (paramNetResp + "range=" + paramNetReq.mStartDownOffset);
        return;
      } while ((paramNetReq.mStartDownOffset <= 0L) || (paramNetReq.mEndDownOffset <= 0L) || (paramNetReq.mStartDownOffset >= paramNetReq.mEndDownOffset));
      paramNetResp.mWrittenBlockLen = 0L;
      paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-" + paramNetReq.mEndDownOffset;
      paramNetReq.mReqProperties.put("Range", paramNetResp);
      paramNetResp = paramNetReq.mReqUrl;
    } while (!paramNetResp.contains("range="));
    paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
    paramNetReq.mReqUrl = (paramNetResp + "range=" + paramNetReq.mStartDownOffset + "-" + paramNetReq.mEndDownOffset);
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
    label69:
    long l;
    if (QLog.isColorLevel())
    {
      paramHttpMsg1 = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
      if (paramHttpNetReq.mHttpMethod == 1)
      {
        bool = true;
        int j = paramHttpNetReq.mFileType;
        String str = paramHttpNetReq.mMsgId;
        StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
        if (this.netResp == null) {
          break label230;
        }
        i = this.netResp.mTryTime;
        localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
        if (this.netResp == null) {
          break label236;
        }
        l = this.netResp.mConsumeTime;
        label100:
        TransFileUtil.log(paramHttpMsg1, bool, String.valueOf(j), str, "retry", l + " isLastGetData:" + paramBoolean1);
      }
    }
    else
    {
      paramBoolean1 = resetOutPut(paramNetResp, paramHttpNetReq);
      if (this.mConnReusedErrorCount >= paramHttpNetReq.mContinueConnReusedErrorLimit) {
        paramHttpNetReq.mReqProperties.put("Connection", "close");
      }
      if (paramBoolean1) {
        break label247;
      }
      if (QLog.isColorLevel())
      {
        paramNetResp = TransFileUtil.getUinDesc(paramHttpNetReq.mBusiProtoType);
        if (paramHttpNetReq.mHttpMethod != 1) {
          break label242;
        }
      }
    }
    label230:
    label236:
    label242:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      TransFileUtil.log(paramNetResp, paramBoolean1, String.valueOf(paramHttpNetReq.mFileType), paramHttpNetReq.mMsgId, "retry", "breakDownAllowRetry is false ");
      onOutEngine();
      return;
      bool = false;
      break;
      i = 0;
      break label69;
      l = 0L;
      break label100;
    }
    label247:
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
    Object localObject = this.httpReq;
    NetResp localNetResp = this.netResp;
    if ((localObject == null) || (localNetResp == null))
    {
      this.initError = true;
      return;
    }
    label362:
    String str;
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
            break label362;
          }
          l = localFile.length();
          if ((l <= 0L) || (!((HttpNetReq)localObject).mSupportBreakResume)) {
            continue;
          }
          localNetResp.mWrittenBlockLen = l;
          fixBreakReq((NetReq)localObject, localNetResp);
          if (!((HttpNetReq)localObject).mUseRaf) {
            continue;
          }
          this.mOutFile = new RandomAccessFile(localFile, "rw");
          this.mOutFile.seek(((HttpNetReq)localObject).mStartDownOffset);
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, "append.oring Len:" + l);
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
          QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, "oring Len:" + l + " trunk");
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
        str = TransFileUtil.getUinDesc(((HttpNetReq)localObject).mBusiProtoType);
        if (((HttpNetReq)localObject).mHttpMethod != 1) {
          break label486;
        }
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      TransFileUtil.log(str, bool, String.valueOf(((HttpNetReq)localObject).mFileType), ((HttpNetReq)localObject).mMsgId, "createtmp", this.mTempPath);
      FileUtils.a(this.mTempPath);
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
  
  public void onOutEngine()
  {
    boolean bool = true;
    if (this.mIsCancelled.get()) {
      return;
    }
    HttpNetReq localHttpNetReq = this.httpReq;
    NetResp localNetResp = this.netResp;
    OutputStream localOutputStream;
    Object localObject;
    if (localHttpNetReq != null)
    {
      localOutputStream = this.mOut;
      localObject = this.mOutFile;
      if ((localHttpNetReq.mOutPath == null) || (localOutputStream == null)) {}
    }
    try
    {
      localOutputStream.close();
      if (localObject == null) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        ((RandomAccessFile)localObject).close();
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
              localObject = TransFileUtil.getUinDesc(localHttpNetReq.mBusiProtoType);
              if (localHttpNetReq.mHttpMethod != 1) {
                break label262;
              }
              TransFileUtil.log((String)localObject, bool, String.valueOf(localHttpNetReq.mFileType), localHttpNetReq.mMsgId, "onOutEngine", "result:" + localNetResp.mResult + " errCode:" + localNetResp.mErrCode + " desc:" + localNetResp.mErrDesc);
            }
            if ((localNetResp.mErrCode == 9367) && (!QLog.isColorLevel())) {}
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
          label262:
          bool = false;
        }
      }
    }
  }
  
  public void release(NetReq paramNetReq)
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
      if ((this.httpReq.mIsRenameInEngine) && (i == 0) && (FileUtils.a(this.httpReq.mOutPath))) {
        FileUtils.e(this.httpReq.mOutPath);
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
          } while ((i != 0) || (FileUtils.c(this.mTempPath, this.httpReq.mOutPath)) || (this.mTempPath == null));
          if (!FileUtils.d(this.mTempPath, this.httpReq.mOutPath)) {
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
    this.mTempPath = HttpEngineServiceImpl.getTempPath(this.httpReq, paramString1, paramString2);
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
        paramHttpMsg2 = HttpEngineServiceImpl.getServerReason("Q", -9533L);
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
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpCommunicatorListener
 * JD-Core Version:    0.7.0.1
 */