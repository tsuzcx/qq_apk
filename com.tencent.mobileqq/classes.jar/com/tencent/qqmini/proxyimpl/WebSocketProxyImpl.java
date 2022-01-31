package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ws.WebSocket;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class WebSocketProxyImpl
  extends WebSocketProxy
{
  private static final String TAG = "WebSocketProxyImpl";
  public ConcurrentHashMap<String, WebSocketProxyImpl.WebSocketTask> taskMap = new ConcurrentHashMap();
  
  public boolean closeSocket(String paramString1, int paramInt, String paramString2)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.taskMap.get(paramString1);
    if ((localWebSocketTask != null) && (localWebSocketTask.mWebSocket != null)) {}
    try
    {
      localWebSocketTask.mWebSocket.close(paramInt, paramString2);
      ThreadManager.getSubThreadHandler().postDelayed(new WebSocketProxyImpl.1(this, localWebSocketTask, paramInt, paramString2), 1000L);
      this.taskMap.remove(paramString1);
      return false;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        QLog.e("WebSocketProxyImpl", 1, "closeSocket error:", paramString2);
      }
    }
  }
  
  public boolean connectSocket(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    paramMap = new WebSocketProxyImpl.WebSocketTask(this, paramString1, paramMap, paramInt, paramWebSocketListener);
    this.taskMap.put(paramString1, paramMap);
    return false;
  }
  
  public boolean send(String paramString1, String paramString2)
  {
    paramString1 = (WebSocketProxyImpl.WebSocketTask)this.taskMap.get(paramString1);
    if ((paramString1 != null) && (paramString1.mWebSocket != null)) {
      try
      {
        MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
        paramString1.mWebSocket.sendMessage(RequestBody.create(localMediaType, paramString2));
        return true;
      }
      catch (Exception paramString1)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendStringMessage error:", paramString1);
        return false;
      }
    }
    return false;
  }
  
  public boolean send(String paramString, byte[] paramArrayOfByte)
  {
    paramString = (WebSocketProxyImpl.WebSocketTask)this.taskMap.get(paramString);
    if ((paramString != null) && (paramString.mWebSocket != null)) {
      try
      {
        MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+binary");
        paramString.mWebSocket.sendMessage(RequestBody.create(localMediaType, paramArrayOfByte));
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendBinaryMessage error:", paramString);
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl
 * JD-Core Version:    0.7.0.1
 */