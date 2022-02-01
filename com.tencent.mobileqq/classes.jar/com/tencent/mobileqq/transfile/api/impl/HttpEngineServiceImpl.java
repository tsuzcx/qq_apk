package com.tencent.mobileqq.transfile.api.impl;

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
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, "construct " + this);
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
  
  public static String getServerReason(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  public static String getTempPath(NetReq paramNetReq, String paramString1, String paramString2)
  {
    if ((paramNetReq != null) && (paramNetReq.mTempPath != null) && (paramNetReq.mTempPath.length() > 0)) {
      return paramNetReq.mTempPath;
    }
    return paramString1 + "." + MD5.toMD5(TransFileUtil.getUrlResoursePath(paramString2, false)) + ".tmp";
  }
  
  private HttpMsg makeNewHttpMsgFromNetReq(NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return null;
    }
    if ((paramNetReq instanceof HttpNetReq))
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      OldHttpCommunicatorListener localOldHttpCommunicatorListener = (OldHttpCommunicatorListener)localHttpNetReq.mPrivate;
      if ((localOldHttpCommunicatorListener == null) || (localOldHttpCommunicatorListener.mIsCancelled.get())) {
        return null;
      }
      HttpMsg localHttpMsg = new HttpMsg(localHttpNetReq.mReqUrl, localHttpNetReq.mSendData, localOldHttpCommunicatorListener);
      if (localHttpNetReq.mHttpMethod == 0) {}
      for (Object localObject = "GET";; localObject = "POST")
      {
        localHttpMsg.setRequestMethod((String)localObject);
        localObject = localHttpNetReq.mReqProperties.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localHttpMsg.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
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
      switch (this.mCmwapConTypeFromDpc)
      {
      }
      for (;;)
      {
        if (paramNetReq.mPrioty == 1)
        {
          localHttpMsg.threadPriority = 201;
          label339:
          if ((localHttpNetReq.mOutStream != null) || (localHttpNetReq.mOutPath != null)) {
            localHttpMsg.setDataSlice(true);
          }
          localOldHttpCommunicatorListener.httpMsg = localHttpMsg;
        }
        try
        {
          paramNetReq = new URL(localHttpMsg.getUrl());
          localObject = localHttpNetReq.mResp;
          ((NetResp)localObject).mRespProperties.put("serverip", paramNetReq.getHost());
          ((NetResp)localObject).mRespProperties.put("param_url", localHttpMsg.getUrl());
          return localHttpMsg;
          if (localHttpNetReq.mUseCmwapConnectionTypeFromDpc)
          {
            localHttpMsg.mCmwapConnectionType = this.mCmwapConTypeFromDpc;
            continue;
            localHttpMsg.mCmwapConnectionType = (this.mCmwapConTypeFromDpc / 4);
            continue;
            if (paramNetReq.mPrioty == 2)
            {
              localHttpMsg.threadPriority = 202;
              break label339;
            }
            if (paramNetReq.mPrioty != 0) {
              break label339;
            }
            localHttpMsg.threadPriority = 200;
          }
        }
        catch (Exception paramNetReq)
        {
          for (;;)
          {
            paramNetReq.printStackTrace();
          }
        }
      }
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
    return new HttpEngineServiceImpl(new HttpCommunicator(), true).sendReqSync(paramNetReq);
  }
  
  public void cancelReq(NetReq paramNetReq)
  {
    if (paramNetReq == null) {}
    do
    {
      return;
      if (paramNetReq.mKey != null) {
        this.mDownloadingFiles.remove(paramNetReq.mKey);
      }
    } while (!OldHttpCommunicatorListener.class.isInstance(paramNetReq.mPrivate));
    Object localObject1 = (HttpNetReq)paramNetReq;
    Object localObject2 = TransFileUtil.getUinDesc(paramNetReq.mBusiProtoType);
    if (((HttpNetReq)localObject1).mHttpMethod == 1) {}
    for (boolean bool = true;; bool = false)
    {
      TransFileUtil.log((String)localObject2, bool, String.valueOf(paramNetReq.mFileType), paramNetReq.mMsgId, "cancelReq", "");
      localObject1 = (OldHttpCommunicatorListener)paramNetReq.mPrivate;
      if (QLog.isColorLevel())
      {
        QLog.d("HttpEngineServiceImpl", 2, "cancelReq ====== listener = " + localObject1);
        if (localObject1 != null) {
          QLog.d("HttpEngineServiceImpl", 2, "cancelReq ====== listener.mIsCancelled = " + ((OldHttpCommunicatorListener)localObject1).mIsCancelled);
        }
      }
      if (localObject1 == null) {
        break;
      }
      ((OldHttpCommunicatorListener)localObject1).mIsCancelled.set(true);
      localObject2 = ((OldHttpCommunicatorListener)localObject1).httpMsg;
      if ((this.mWorking.get()) && (this.mHttpExcuter != null)) {
        this.mHttpExcuter.cancelMsg((HttpMsg)localObject2);
      }
      ((OldHttpCommunicatorListener)localObject1).release(paramNetReq);
      ((OldHttpCommunicatorListener)localObject1).clearForGC();
      return;
    }
  }
  
  public void destroy()
  {
    if (this.mWorking.get())
    {
      this.mWorking.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpEngineServiceImpl", 2, "destroy " + this);
      }
      if ((this.mOwnCommunicator) && (this.mHttpExcuter != null)) {
        this.mHttpExcuter.close();
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
    OldHttpCommunicatorListener localOldHttpCommunicatorListener;
    do
    {
      try
      {
        HttpMsg localHttpMsg1 = makeNewHttpMsgFromNetReq(paramNetReq);
        localOldHttpCommunicatorListener = (OldHttpCommunicatorListener)paramNetReq.mPrivate;
        if ((localHttpMsg1 != null) && (localOldHttpCommunicatorListener != null))
        {
          localHttpMsg1.mIsSync = paramBoolean;
          NetResp localNetResp = paramNetReq.mResp;
          localNetResp.mTryTime += 1;
          localOldHttpCommunicatorListener.mLastReqReturnBytes = 0;
          if (paramBoolean)
          {
            sendOldHttpMsgSync(localHttpMsg1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        HttpMsg localHttpMsg3;
        for (;;)
        {
          System.gc();
          try
          {
            HttpMsg localHttpMsg2 = makeNewHttpMsgFromNetReq(paramNetReq);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.HttpEngineServiceImpl", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            localHttpMsg3 = null;
          }
        }
        if (this.mWorking.get())
        {
          sendOldHttpMsg(localHttpMsg3);
          return;
        }
        paramNetReq = paramNetReq.mResp;
        paramNetReq.mErrCode = 9366;
        paramNetReq.mErrDesc = "oldengine close";
        paramNetReq.mResult = 1;
        localOldHttpCommunicatorListener.onOutEngine();
        return;
      }
    } while ((localOldHttpCommunicatorListener == null) || (localOldHttpCommunicatorListener.mIsCancelled.get()));
    paramNetReq = paramNetReq.mResp;
    paramNetReq.mErrCode = 9369;
    paramNetReq.mErrDesc = "Out of memory";
    paramNetReq.mResult = 1;
    localOldHttpCommunicatorListener.onOutEngine();
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    destroy();
  }
  
  public void sendOldHttpMsg(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg != null) && (this.mWorking.get()) && (this.mHttpExcuter != null)) {
      this.mHttpExcuter.sendMsg(paramHttpMsg);
    }
  }
  
  public void sendOldHttpMsgSync(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg != null) && (this.mHttpExcuter != null)) {
      this.mHttpExcuter.sendMsgRealSync(paramHttpMsg);
    }
  }
  
  public void sendReq(NetReq paramNetReq)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    if ((paramNetReq != null) && (paramNetReq.mCallback != null) && ((paramNetReq instanceof HttpNetReq)))
    {
      localObject2 = null;
      localObject3 = (HttpNetReq)paramNetReq;
      localObject1 = localObject2;
      if (((HttpNetReq)localObject3).mHttpMethod != 0) {
        break label276;
      }
      localObject1 = localObject2;
      if (paramNetReq.mOutPath == null) {
        break label276;
      }
      localObject2 = getTempPath(paramNetReq, paramNetReq.mOutPath, ((HttpNetReq)localObject3).mReqUrl);
      paramNetReq.mKey = ((String)localObject2);
      localObject1 = localObject2;
      if (this.mDownloadingFiles.putIfAbsent(localObject2, localObject2) == null) {
        break label276;
      }
      i = 1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      doInnerDns((HttpNetReq)localObject3);
      ((HttpNetReq)localObject3).mResp = new NetResp((NetReq)localObject3);
      OldHttpCommunicatorListener localOldHttpCommunicatorListener = new OldHttpCommunicatorListener(this);
      ((HttpNetReq)localObject3).mPrivate = localOldHttpCommunicatorListener;
      localOldHttpCommunicatorListener.httpReq = ((HttpNetReq)localObject3);
      localOldHttpCommunicatorListener.netResp = ((HttpNetReq)localObject3).mResp;
      if (i == 0) {
        localOldHttpCommunicatorListener.init();
      }
      if ((paramNetReq.mResp.mResult != 2) || (localOldHttpCommunicatorListener.initError))
      {
        localOldHttpCommunicatorListener.onOutEngine();
        return;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("sendReq:").append(paramNetReq).append(" _id:").append(paramNetReq.mMsgId).append(" isDownloading key:");
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          QLog.e("Q.richmedia.HttpEngineServiceImpl", 2, (String)localObject2);
        }
        paramNetReq.mResp.mResult = 3;
        localOldHttpCommunicatorListener.onOutEngine();
        return;
      }
      innerSendReq(paramNetReq, false);
      return;
      label276:
      i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl
 * JD-Core Version:    0.7.0.1
 */