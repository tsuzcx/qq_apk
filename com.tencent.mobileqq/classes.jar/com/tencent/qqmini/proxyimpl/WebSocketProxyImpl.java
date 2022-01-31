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
  public ConcurrentHashMap<Integer, WebSocketProxyImpl.WebSocketTask> taskMap = new ConcurrentHashMap();
  
  public boolean closeSocket(int paramInt1, int paramInt2, String paramString)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.taskMap.get(Integer.valueOf(paramInt1));
    if ((localWebSocketTask != null) && (localWebSocketTask.mWebSocket != null)) {}
    try
    {
      localWebSocketTask.mWebSocket.close(paramInt2, paramString);
      ThreadManager.getSubThreadHandler().postDelayed(new WebSocketProxyImpl.1(this, localWebSocketTask, paramInt1, paramInt2, paramString), 1000L);
      this.taskMap.remove(Integer.valueOf(paramInt1));
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("WebSocketProxyImpl", 1, "closeSocket error:", paramString);
      }
    }
  }
  
  public boolean connectSocket(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    paramString1 = new WebSocketProxyImpl.WebSocketTask(this, paramInt1, paramString1, paramMap, paramInt2, paramWebSocketListener);
    this.taskMap.put(Integer.valueOf(paramInt1), paramString1);
    return true;
  }
  
  public boolean send(int paramInt, String paramString)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.taskMap.get(Integer.valueOf(paramInt));
    if ((localWebSocketTask != null) && (localWebSocketTask.mWebSocket != null)) {
      try
      {
        MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
        localWebSocketTask.mWebSocket.sendMessage(RequestBody.create(localMediaType, paramString));
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendStringMessage error:", paramString);
        return false;
      }
    }
    return false;
  }
  
  public boolean send(int paramInt, byte[] paramArrayOfByte)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.taskMap.get(Integer.valueOf(paramInt));
    if ((localWebSocketTask != null) && (localWebSocketTask.mWebSocket != null)) {
      try
      {
        MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+binary");
        localWebSocketTask.mWebSocket.sendMessage(RequestBody.create(localMediaType, paramArrayOfByte));
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendBinaryMessage error:", paramArrayOfByte);
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