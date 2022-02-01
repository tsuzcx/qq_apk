package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.IHttpCommunicator;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.OldHttpCommunicatorListener;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class HttpEngineServiceImpl
  implements IHttpEngineService
{
  public static final String TAG = "Q.richmedia.HttpEngineServiceImpl";
  public static String privateDir;
  public volatile int mCmwapConTypeFromDpc = 4;
  public ConcurrentHashMap<String, String> mDownloadingFiles = new ConcurrentHashMap();
  HttpCommunicator mHttpExcuter;
  boolean mOwnCommunicator;
  public AtomicBoolean mWorking = new AtomicBoolean(true);
  
  public HttpEngineServiceImpl()
  {
    this.mHttpExcuter = new HttpCommunicator(128);
    this.mHttpExcuter.start();
  }
  
  public HttpEngineServiceImpl(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("construct ");
      localStringBuilder.append(this);
      QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, localStringBuilder.toString());
    }
    this.mHttpExcuter = paramHttpCommunicator;
    this.mOwnCommunicator = paramBoolean;
  }
  
  @Deprecated
  public HttpEngineServiceImpl(String paramString) {}
  
  private void doInnerDns(HttpNetReq paramHttpNetReq)
  {
    if ((paramHttpNetReq.mNeedIpConnect) && (paramHttpNetReq.mServerList == null) && (paramHttpNetReq.mReqUrl != null) && (!paramHttpNetReq.mReqUrl.startsWith("https")))
    {
      String str = BaseInnerDns.getHostFromUrl(paramHttpNetReq.mReqUrl);
      int i = BaseInnerDns.getPortFromUrl(paramHttpNetReq.mReqUrl);
      if (str != null)
      {
        ArrayList localArrayList = BaseInnerDns.getInstance().reqSerAddrList(str, 1002);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Object localObject = ((ServerAddr)localArrayList.get(0)).getServerUrl(paramHttpNetReq.mReqUrl);
          paramHttpNetReq.mReqUrl = TransFileUtil.replaceIp(paramHttpNetReq.mReqUrl, (String)localObject);
          localObject = new ServerAddr();
          ((ServerAddr)localObject).mIp = str;
          if (i != -1) {
            ((ServerAddr)localObject).port = i;
          }
          ((ServerAddr)localObject).isDomain = true;
          localArrayList.add(localObject);
          paramHttpNetReq.mServerList = localArrayList;
          paramHttpNetReq.mHaveIpConnect = false;
          paramHttpNetReq.mIsHostIP = true;
          paramHttpNetReq.mHostForHttpsVerify = str;
          paramHttpNetReq.mReqProperties.put("host", str);
        }
      }
    }
  }
  
  public static IHttpEngineService getEngineService()
  {
    return new HttpEngineServiceImpl(new HttpCommunicator(), true);
  }
  
  public static String getPrivateDir()
  {
    if (privateDir == null) {
      privateDir = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH);
    }
    return privateDir;
  }
  
  public static String getServerReason(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String getTempPath(NetReq paramNetReq, String paramString)
  {
    if ((paramNetReq != null) && (paramNetReq.mTempPath != null) && (paramNetReq.mTempPath.length() > 0)) {
      return paramNetReq.mTempPath;
    }
    paramNetReq = new StringBuilder(getPrivateDir());
    paramNetReq.append("httpengine");
    paramNetReq.append(File.separator);
    paramNetReq.append(MD5.toMD5(TransFileUtil.getUrlResoursePath(paramString, false)));
    paramNetReq.append(".tmp");
    return paramNetReq.toString();
  }
  
  private HttpMsg makeNewHttpMsgFromNetReq(NetReq paramNetReq)
  {
    Object localObject = null;
    if (paramNetReq == null) {
      return null;
    }
    if ((paramNetReq instanceof HttpNetReq))
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      OldHttpCommunicatorListener localOldHttpCommunicatorListener = (OldHttpCommunicatorListener)localHttpNetReq.mPrivate;
      if (localOldHttpCommunicatorListener != null)
      {
        if (localOldHttpCommunicatorListener.mIsCancelled.get()) {
          return null;
        }
        HttpMsg localHttpMsg = new HttpMsg(localHttpNetReq.mReqUrl, localHttpNetReq.mSendData, localOldHttpCommunicatorListener);
        if (localHttpNetReq.mHttpMethod == 0) {
          localObject = "GET";
        } else {
          localObject = "POST";
        }
        localHttpMsg.setRequestMethod((String)localObject);
        localObject = localHttpNetReq.mReqProperties.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localHttpMsg.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        localHttpMsg.mIsHttps = localHttpNetReq.mIsHttps;
        localHttpMsg.mReqHost = localHttpNetReq.mHostForHttpsVerify;
        localHttpMsg.mIsHostIP = localHttpNetReq.mIsHostIP;
        localHttpMsg.mIsPreStructPic = localHttpNetReq.mIsPreStructPic;
        localHttpMsg.mHaveIpConnect = localHttpNetReq.mHaveIpConnect;
        localHttpMsg.bReportRedirects = localHttpNetReq.mNeedRedirectCallback;
        localHttpMsg.msgId = paramNetReq.mMsgId;
        localHttpMsg.busiType = paramNetReq.mBusiProtoType;
        localHttpMsg.fileType = paramNetReq.mFileType;
        localHttpMsg.timeoutParam = localHttpNetReq.mTimeoutParam;
        localHttpMsg.whiteList_type = localHttpNetReq.mWhiteListContentType;
        localHttpMsg.mUseByteArrayPool = localHttpNetReq.mUseByteArrayPool;
        localHttpMsg.mCanPrintUrl = paramNetReq.mCanPrintUrl;
        localHttpMsg.mNeedNotReferer = localHttpNetReq.mNeedNotReferer;
        int i = this.mCmwapConTypeFromDpc;
        if ((i != 1) && (i != 2))
        {
          if ((i == 4) || (i == 8)) {
            localHttpMsg.mCmwapConnectionType = (this.mCmwapConTypeFromDpc / 4);
          }
        }
        else if (localHttpNetReq.mUseCmwapConnectionTypeFromDpc) {
          localHttpMsg.mCmwapConnectionType = this.mCmwapConTypeFromDpc;
        }
        if (paramNetReq.mPrioty == 1) {
          localHttpMsg.threadPriority = 201;
        } else if (paramNetReq.mPrioty == 2) {
          localHttpMsg.threadPriority = 202;
        } else if (paramNetReq.mPrioty == 0) {
          localHttpMsg.threadPriority = 200;
        }
        if ((localHttpNetReq.mOutStream != null) || (localHttpNetReq.mOutPath != null)) {
          localHttpMsg.setDataSlice(true);
        }
        localOldHttpCommunicatorListener.httpMsg = localHttpMsg;
        try
        {
          paramNetReq = new URL(localHttpMsg.getUrl());
          localObject = localHttpNetReq.mResp;
          ((NetResp)localObject).mRespProperties.put("serverip", paramNetReq.getHost());
          ((NetResp)localObject).mRespProperties.put("param_url", localHttpMsg.getUrl());
          return localHttpMsg;
        }
        catch (Exception paramNetReq)
        {
          paramNetReq.printStackTrace();
          localObject = localHttpMsg;
        }
      }
      return localObject;
    }
    if (paramNetReq.mCallback != null)
    {
      paramNetReq.mResp.setResult(1, 9302, "not support by HttpOldEngine", null);
      paramNetReq.mCallback.onResp(paramNetReq.mResp);
    }
    return null;
  }
  
  public static NetResp transSync(NetReq paramNetReq)
  {
    return getEngineService().sendReqSync(paramNetReq);
  }
  
  public void cancelReq(NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return;
    }
    if (paramNetReq.mKey != null) {
      this.mDownloadingFiles.remove(paramNetReq.mKey);
    }
    if (!OldHttpCommunicatorListener.class.isInstance(paramNetReq.mPrivate)) {
      return;
    }
    Object localObject1 = (HttpNetReq)paramNetReq;
    Object localObject2 = TransFileUtil.getUinDesc(paramNetReq.mBusiProtoType);
    boolean bool;
    if (((HttpNetReq)localObject1).mHttpMethod == 1) {
      bool = true;
    } else {
      bool = false;
    }
    TransFileUtil.log((String)localObject2, bool, String.valueOf(paramNetReq.mFileType), paramNetReq.mMsgId, "cancelReq", "");
    localObject1 = (OldHttpCommunicatorListener)paramNetReq.mPrivate;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cancelReq ====== listener = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("HttpEngineServiceImpl", 2, ((StringBuilder)localObject2).toString());
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cancelReq ====== listener.mIsCancelled = ");
        ((StringBuilder)localObject2).append(((OldHttpCommunicatorListener)localObject1).mIsCancelled);
        QLog.d("HttpEngineServiceImpl", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (localObject1 == null) {
      return;
    }
    ((OldHttpCommunicatorListener)localObject1).mIsCancelled.set(true);
    localObject2 = ((OldHttpCommunicatorListener)localObject1).httpMsg;
    if (this.mWorking.get())
    {
      HttpCommunicator localHttpCommunicator = this.mHttpExcuter;
      if (localHttpCommunicator != null) {
        localHttpCommunicator.cancelMsg((HttpMsg)localObject2);
      }
    }
    ((OldHttpCommunicatorListener)localObject1).release(paramNetReq);
    ((OldHttpCommunicatorListener)localObject1).clearForGC();
  }
  
  public void destroy()
  {
    if (this.mWorking.get())
    {
      this.mWorking.set(false);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("destroy ");
        ((StringBuilder)localObject).append(this);
        QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (this.mOwnCommunicator)
      {
        localObject = this.mHttpExcuter;
        if (localObject != null) {
          ((HttpCommunicator)localObject).close();
        }
      }
      this.mHttpExcuter = null;
    }
  }
  
  public IHttpCommunicator getCommunicator()
  {
    return this.mHttpExcuter;
  }
  
  public void innerSendReq(NetReq paramNetReq, boolean paramBoolean)
  {
    try
    {
      localHttpMsg1 = makeNewHttpMsgFromNetReq(paramNetReq);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      HttpMsg localHttpMsg1;
      label9:
      HttpMsg localHttpMsg2;
      OldHttpCommunicatorListener localOldHttpCommunicatorListener;
      NetResp localNetResp;
      break label9;
    }
    System.gc();
    try
    {
      localHttpMsg1 = makeNewHttpMsgFromNetReq(paramNetReq);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpEngineServiceImpl", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError1);
      }
      localHttpMsg2 = null;
    }
    localOldHttpCommunicatorListener = (OldHttpCommunicatorListener)paramNetReq.mPrivate;
    if ((localHttpMsg2 != null) && (localOldHttpCommunicatorListener != null))
    {
      localHttpMsg2.mIsSync = paramBoolean;
      localNetResp = paramNetReq.mResp;
      localNetResp.mTryTime += 1;
      localOldHttpCommunicatorListener.mLastReqReturnBytes = 0;
      if (paramBoolean)
      {
        sendOldHttpMsgSync(localHttpMsg2);
        return;
      }
      if (this.mWorking.get())
      {
        sendOldHttpMsg(localHttpMsg2);
        return;
      }
      paramNetReq = paramNetReq.mResp;
      paramNetReq.mErrCode = 9366;
      paramNetReq.mErrDesc = "oldengine close";
      paramNetReq.mResult = 1;
      localOldHttpCommunicatorListener.onOutEngine();
      return;
    }
    if (localOldHttpCommunicatorListener != null)
    {
      if (localOldHttpCommunicatorListener.mIsCancelled.get()) {
        return;
      }
      paramNetReq = paramNetReq.mResp;
      paramNetReq.mErrCode = 9369;
      paramNetReq.mErrDesc = "Out of memory";
      paramNetReq.mResult = 1;
      localOldHttpCommunicatorListener.onOutEngine();
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    destroy();
  }
  
  public void sendOldHttpMsg(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg != null) && (this.mWorking.get()))
    {
      HttpCommunicator localHttpCommunicator = this.mHttpExcuter;
      if (localHttpCommunicator != null) {
        localHttpCommunicator.sendMsg(paramHttpMsg);
      }
    }
  }
  
  public void sendOldHttpMsgSync(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg != null)
    {
      HttpCommunicator localHttpCommunicator = this.mHttpExcuter;
      if (localHttpCommunicator != null) {
        localHttpCommunicator.sendMsgRealSync(paramHttpMsg);
      }
    }
  }
  
  public void sendReq(NetReq paramNetReq)
  {
    if ((paramNetReq != null) && (paramNetReq.mCallback != null) && ((paramNetReq instanceof HttpNetReq)))
    {
      Object localObject2 = null;
      Object localObject3 = (HttpNetReq)paramNetReq;
      Object localObject1 = localObject2;
      if (((HttpNetReq)localObject3).mHttpMethod == 0)
      {
        localObject1 = localObject2;
        if (paramNetReq.mOutPath != null)
        {
          localObject2 = getTempPath(paramNetReq, ((HttpNetReq)localObject3).mReqUrl);
          paramNetReq.mKey = ((String)localObject2);
          localObject1 = localObject2;
          if (this.mDownloadingFiles.putIfAbsent(localObject2, localObject2) != null)
          {
            i = 1;
            localObject1 = localObject2;
            break label92;
          }
        }
      }
      int i = 0;
      label92:
      doInnerDns((HttpNetReq)localObject3);
      ((HttpNetReq)localObject3).mResp = new NetResp((NetReq)localObject3);
      OldHttpCommunicatorListener localOldHttpCommunicatorListener = new OldHttpCommunicatorListener(this);
      ((HttpNetReq)localObject3).mPrivate = localOldHttpCommunicatorListener;
      localOldHttpCommunicatorListener.httpReq = ((HttpNetReq)localObject3);
      localOldHttpCommunicatorListener.netResp = ((HttpNetReq)localObject3).mResp;
      if (i == 0) {
        localOldHttpCommunicatorListener.init();
      }
      if ((paramNetReq.mResp.mResult == 2) && (!localOldHttpCommunicatorListener.initError))
      {
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("sendReq:");
            ((StringBuilder)localObject3).append(paramNetReq);
            ((StringBuilder)localObject3).append(" _id:");
            ((StringBuilder)localObject3).append(paramNetReq.mMsgId);
            ((StringBuilder)localObject3).append(" isDownloading key:");
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.e("Q.richmedia.HttpEngineServiceImpl", 2, ((StringBuilder)localObject3).toString());
          }
          paramNetReq.mResp.mResult = 3;
          localOldHttpCommunicatorListener.onOutEngine();
          return;
        }
        innerSendReq(paramNetReq, false);
        return;
      }
      localOldHttpCommunicatorListener.onOutEngine();
    }
  }
  
  public NetResp sendReqSync(NetReq paramNetReq)
  {
    if ((paramNetReq != null) && ((paramNetReq instanceof HttpNetReq)))
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      localHttpNetReq.mIsSync = true;
      doInnerDns(localHttpNetReq);
      localHttpNetReq.mResp = new NetResp(localHttpNetReq);
      OldHttpCommunicatorListener localOldHttpCommunicatorListener = new OldHttpCommunicatorListener(this);
      localHttpNetReq.mPrivate = localOldHttpCommunicatorListener;
      localOldHttpCommunicatorListener.httpReq = localHttpNetReq;
      localOldHttpCommunicatorListener.netResp = localHttpNetReq.mResp;
      localOldHttpCommunicatorListener.init();
      innerSendReq(paramNetReq, true);
      return paramNetReq.mResp;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl
 * JD-Core Version:    0.7.0.1
 */