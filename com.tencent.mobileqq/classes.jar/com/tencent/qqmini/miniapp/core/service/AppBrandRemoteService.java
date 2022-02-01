package com.tencent.qqmini.miniapp.core.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.manager.LoginManager;

public class AppBrandRemoteService
  extends AbsAppBrandService
{
  protected static final String TAG = "AppBrandRemoteService";
  protected static HandlerThread mHandlerThread;
  protected static Handler mThreadHandler;
  private AppBrandWebSocket appBrandWebSocket;
  protected String threadName = "mini_remote_service_thread";
  
  public AppBrandRemoteService(IMiniAppContext paramIMiniAppContext, ServiceEventListener paramServiceEventListener)
  {
    super(paramIMiniAppContext);
    try
    {
      if (mHandlerThread == null)
      {
        mHandlerThread = new HandlerThread(this.threadName);
        mHandlerThread.start();
        mThreadHandler = new Handler(mHandlerThread.getLooper());
      }
      paramServiceEventListener = paramIMiniAppContext.getMiniAppInfo();
      initFramework(paramIMiniAppContext, paramServiceEventListener.appId, paramServiceEventListener.debugInfo.roomId, paramServiceEventListener.debugInfo.wsUrl);
      return;
    }
    finally {}
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    paramString = String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateCallbackJs 2: ");
    localStringBuilder.append(paramString);
    QMLog.d("AppBrandRemoteService", localStringBuilder.toString());
    evaluateJs(paramString, null);
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateJs 2: ");
    localStringBuilder.append(paramString);
    QMLog.d("AppBrandRemoteService", localStringBuilder.toString());
    this.appBrandWebSocket.evaluateJs(paramString, paramValueCallback);
  }
  
  public void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("evaluateJs 1: ");
    paramString2.append(paramString1);
    QMLog.d("AppBrandRemoteService", paramString2.toString());
    evaluateJs(paramString1, paramValueCallback);
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateSubscribeJS  eventName=");
    localStringBuilder.append(paramString1);
    QMLog.d("AppBrandRemoteService", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(0);
    localStringBuilder.append(")");
    evaluateJs(localStringBuilder.toString(), null);
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    setCurrState(this.stateWaJsLoading);
  }
  
  public void initEmbeddedState(EmbeddedState paramEmbeddedState)
  {
    this.appBrandWebSocket.initEmbeddedState(paramEmbeddedState);
  }
  
  public void initFramework(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2, String paramString3)
  {
    String str1 = LoginManager.getInstance().getAccount();
    String str2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getA2();
    this.appBrandWebSocket = new AppBrandWebSocket(paramIMiniAppContext, mThreadHandler, this);
    paramIMiniAppContext = new StringBuilder();
    paramIMiniAppContext.append(paramString3);
    paramIMiniAppContext.append("?appId=");
    paramIMiniAppContext.append(paramString1);
    paramIMiniAppContext.append("&roomId=");
    paramIMiniAppContext.append(paramString2);
    paramIMiniAppContext.append("&uin=");
    paramIMiniAppContext.append(str1);
    paramIMiniAppContext.append("&bytesSig=");
    paramIMiniAppContext.append(str2);
    paramIMiniAppContext = paramIMiniAppContext.toString();
    this.appBrandWebSocket.connect(paramIMiniAppContext);
    paramString1 = new StringBuilder();
    paramString1.append(" connect: ");
    paramString1.append(paramIMiniAppContext);
    QMLog.d("AppBrandRemoteService", paramString1.toString());
  }
  
  public void sendDomEvent(String paramString, int paramInt)
  {
    AppBrandWebSocket localAppBrandWebSocket = this.appBrandWebSocket;
    if (localAppBrandWebSocket != null) {
      localAppBrandWebSocket.sendDomEvent(paramString, paramInt);
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    QMLog.d("AppBrandRemoteService", "setApkgInfo");
    this.appBrandWebSocket.setApkgInfo(paramApkgInfo);
    this.appBrandWebSocket.sendSetupContextCmd(new AppBrandRemoteService.1(this));
  }
  
  public void setAppBrandEventInterface(ServiceEventListener paramServiceEventListener)
  {
    QMLog.d("AppBrandRemoteService", "setAppBrandEventInterface");
    AppBrandWebSocket localAppBrandWebSocket = this.appBrandWebSocket;
    if (localAppBrandWebSocket != null) {
      localAppBrandWebSocket.setServiceEventListener(paramServiceEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService
 * JD-Core Version:    0.7.0.1
 */