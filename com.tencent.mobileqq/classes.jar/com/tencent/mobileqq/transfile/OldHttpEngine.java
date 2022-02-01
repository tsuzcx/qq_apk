package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
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

public class OldHttpEngine
  implements INetEngine
{
  public static final String TAG = "Q.richmedia.OldHttpEngine";
  private static volatile int sCmwapConnectionTypeFromDpc = -1;
  private ConcurrentHashMap<String, String> mDownloadingFiles = new ConcurrentHashMap();
  HttpCommunicator mHttpExcuter;
  boolean mOwnCommunicator;
  AtomicBoolean mWorking = new AtomicBoolean(true);
  
  public OldHttpEngine() {}
  
  public OldHttpEngine(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.mHttpExcuter = paramHttpCommunicator;
    this.mOwnCommunicator = paramBoolean;
  }
  
  private void doInnerDns(HttpNetReq paramHttpNetReq)
  {
    if ((paramHttpNetReq.mNeedIpConnect) && (paramHttpNetReq.mServerList == null) && (paramHttpNetReq.mReqUrl != null) && (!paramHttpNetReq.mReqUrl.startsWith("https")))
    {
      String str = InnerDns.getHostFromUrl(paramHttpNetReq.mReqUrl);
      int i = InnerDns.getPortFromUrl(paramHttpNetReq.mReqUrl);
      if (str != null)
      {
        ArrayList localArrayList = InnerDns.getInstance().reqSerAddrList(str, 1002);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Object localObject = ((ServerAddr)localArrayList.get(0)).getServerUrl(paramHttpNetReq.mReqUrl);
          paramHttpNetReq.mReqUrl = RichMediaUtil.replaceIp(paramHttpNetReq.mReqUrl, (String)localObject);
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
  
  private static String getTempPath(NetReq paramNetReq, String paramString1, String paramString2)
  {
    if ((paramNetReq != null) && (paramNetReq.mTempPath != null) && (paramNetReq.mTempPath.length() > 0)) {
      return paramNetReq.mTempPath;
    }
    return paramString1 + "." + MD5.toMD5(RichMediaUtil.getUrlResoursePath(paramString2, false)) + ".tmp";
  }
  
  public static void initCmwapConnectionTypeFromDpc()
  {
    if (sCmwapConnectionTypeFromDpc >= 0) {}
    for (;;)
    {
      return;
      Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {}
      }
      try
      {
        sCmwapConnectionTypeFromDpc = Integer.valueOf(localObject[4]).intValue();
        label54:
        if (sCmwapConnectionTypeFromDpc == -1) {
          sCmwapConnectionTypeFromDpc = 1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.richmedia.OldHttpEngine", 2, "[initCmwapConnectionTypeFromDpc]: " + sCmwapConnectionTypeFromDpc);
        return;
      }
      catch (Exception localException)
      {
        break label54;
      }
    }
  }
  
  private HttpMsg makeNewHttpMsgFromNetReq(NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return null;
    }
    if ((paramNetReq instanceof HttpNetReq))
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)localHttpNetReq.mPrivate;
      if ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.mIsCancelled.get())) {
        return null;
      }
      HttpMsg localHttpMsg = new HttpMsg(localHttpNetReq.mReqUrl, localHttpNetReq.mSendData, localOldHttpCommunicatorListner);
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
      if (sCmwapConnectionTypeFromDpc == -1) {
        initCmwapConnectionTypeFromDpc();
      }
      switch (sCmwapConnectionTypeFromDpc)
      {
      }
      for (;;)
      {
        if (paramNetReq.mPrioty == 1)
        {
          localHttpMsg.threadPriority = 201;
          label347:
          if ((localHttpNetReq.mOutStream != null) || (localHttpNetReq.mOutPath != null)) {
            localHttpMsg.setDataSlice(true);
          }
          localOldHttpCommunicatorListner.httpMsg = localHttpMsg;
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
            localHttpMsg.mCmwapConnectionType = sCmwapConnectionTypeFromDpc;
            continue;
            localHttpMsg.mCmwapConnectionType = (sCmwapConnectionTypeFromDpc / 4);
            continue;
            if (paramNetReq.mPrioty == 2)
            {
              localHttpMsg.threadPriority = 202;
              break label347;
            }
            if (paramNetReq.mPrioty != 0) {
              break label347;
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
    return new OldHttpEngine(new HttpCommunicator(), true).sendReqSync(paramNetReq);
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
    } while (!OldHttpEngine.OldHttpCommunicatorListner.class.isInstance(paramNetReq.mPrivate));
    Object localObject = (HttpNetReq)paramNetReq;
    int i = paramNetReq.mBusiProtoType;
    if (((HttpNetReq)localObject).mHttpMethod == 1) {}
    for (boolean bool = true;; bool = false)
    {
      RichMediaUtil.log(i, bool, paramNetReq.mFileType, paramNetReq.mMsgId, "cancelReq", "");
      localObject = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.mPrivate;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((OldHttpEngine.OldHttpCommunicatorListner)localObject).mIsCancelled);
        }
      }
      if (localObject == null) {
        break;
      }
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).mIsCancelled.set(true);
      HttpMsg localHttpMsg = ((OldHttpEngine.OldHttpCommunicatorListner)localObject).httpMsg;
      if ((this.mWorking.get()) && (this.mHttpExcuter != null)) {
        this.mHttpExcuter.cancelMsg(localHttpMsg);
      }
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).release(paramNetReq);
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).clearForGC();
      return;
    }
  }
  
  public void destroy()
  {
    if (this.mWorking.get())
    {
      this.mWorking.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "destroy " + this);
      }
      if ((this.mOwnCommunicator) && (this.mHttpExcuter != null)) {
        this.mHttpExcuter.close();
      }
      this.mHttpExcuter = null;
    }
  }
  
  void innerSendReq(NetReq paramNetReq, boolean paramBoolean)
  {
    OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
    do
    {
      try
      {
        HttpMsg localHttpMsg1 = makeNewHttpMsgFromNetReq(paramNetReq);
        localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.mPrivate;
        if ((localHttpMsg1 != null) && (localOldHttpCommunicatorListner != null))
        {
          localHttpMsg1.mIsSync = paramBoolean;
          NetResp localNetResp = paramNetReq.mResp;
          localNetResp.mTryTime += 1;
          localOldHttpCommunicatorListner.mLastReqReturnBytes = 0;
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
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
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
        OldHttpEngine.OldHttpCommunicatorListner.access$000(localOldHttpCommunicatorListner);
        return;
      }
    } while ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.mIsCancelled.get()));
    paramNetReq = paramNetReq.mResp;
    paramNetReq.mErrCode = 9369;
    paramNetReq.mErrDesc = "Out of memory";
    paramNetReq.mResult = 1;
    OldHttpEngine.OldHttpCommunicatorListner.access$000(localOldHttpCommunicatorListner);
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
        break label275;
      }
      localObject1 = localObject2;
      if (paramNetReq.mOutPath == null) {
        break label275;
      }
      localObject2 = getTempPath(paramNetReq, paramNetReq.mOutPath, ((HttpNetReq)localObject3).mReqUrl);
      paramNetReq.mKey = ((String)localObject2);
      localObject1 = localObject2;
      if (this.mDownloadingFiles.putIfAbsent(localObject2, localObject2) == null) {
        break label275;
      }
      i = 1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      doInnerDns((HttpNetReq)localObject3);
      ((HttpNetReq)localObject3).mResp = new NetResp((NetReq)localObject3);
      OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner = new OldHttpEngine.OldHttpCommunicatorListner(this);
      ((HttpNetReq)localObject3).mPrivate = localOldHttpCommunicatorListner;
      localOldHttpCommunicatorListner.httpReq = ((HttpNetReq)localObject3);
      localOldHttpCommunicatorListner.netResp = ((HttpNetReq)localObject3).mResp;
      if (i == 0) {
        localOldHttpCommunicatorListner.init();
      }
      if ((paramNetReq.mResp.mResult != 2) || (localOldHttpCommunicatorListner.initError))
      {
        OldHttpEngine.OldHttpCommunicatorListner.access$000(localOldHttpCommunicatorListner);
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
          QLog.e("Q.richmedia.OldHttpEngine", 2, (String)localObject2);
        }
        paramNetReq.mResp.mResult = 3;
        OldHttpEngine.OldHttpCommunicatorListner.access$000(localOldHttpCommunicatorListner);
        return;
      }
      innerSendReq(paramNetReq, false);
      return;
      label275:
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
      OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner = new OldHttpEngine.OldHttpCommunicatorListner(this);
      localHttpNetReq.mPrivate = localOldHttpCommunicatorListner;
      localOldHttpCommunicatorListner.httpReq = localHttpNetReq;
      localOldHttpCommunicatorListner.netResp = localHttpNetReq.mResp;
      localOldHttpCommunicatorListner.init();
      innerSendReq(paramNetReq, true);
      return paramNetReq.mResp;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine
 * JD-Core Version:    0.7.0.1
 */