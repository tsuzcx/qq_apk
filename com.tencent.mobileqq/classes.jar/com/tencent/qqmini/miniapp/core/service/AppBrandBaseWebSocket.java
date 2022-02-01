package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.concurrent.atomic.AtomicInteger;

public class AppBrandBaseWebSocket
{
  public static final String TAG = "AppBrandRemoteService";
  public static AtomicInteger sWebSocketRequestId = new AtomicInteger(10000);
  protected WebSocketProxy.WebSocketListener mListener;
  public int mTaskId;
  protected IMiniAppContext miniAppContext;
  protected WebSocketProxy wsProxy;
  
  public void closeSocket(int paramInt, String paramString)
  {
    this.wsProxy.closeSocket(this.mTaskId, 1000, paramString);
  }
  
  public void connect(String paramString)
  {
    this.mTaskId = sWebSocketRequestId.getAndIncrement();
    this.wsProxy = ((WebSocketProxy)ProxyManager.get(WebSocketProxy.class));
    this.wsProxy.connectSocket(this.mTaskId, paramString, null, "", 30000, this.mListener);
  }
  
  public void destroy()
  {
    this.wsProxy = null;
  }
  
  public void sendStringMessage(String paramString)
  {
    QMLog.d("AppBrandRemoteService", "---> send Message" + paramString);
    this.wsProxy.send(this.mTaskId, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandBaseWebSocket
 * JD-Core Version:    0.7.0.1
 */