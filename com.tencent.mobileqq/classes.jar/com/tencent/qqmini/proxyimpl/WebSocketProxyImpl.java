package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import okhttp3.MediaType;
import okhttp3.WebSocket;
import okio.ByteString;

@ProxyService(proxy=WebSocketProxy.class)
public class WebSocketProxyImpl
  extends WebSocketProxy
{
  public ConcurrentHashMap<Integer, WebSocketProxyImpl.WebSocketTask> a = new ConcurrentHashMap();
  
  public boolean closeSocket(int paramInt1, int paramInt2, String paramString)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.a.get(Integer.valueOf(paramInt1));
    if ((localWebSocketTask != null) && (localWebSocketTask.d != null)) {
      try
      {
        localWebSocketTask.d.close(paramInt2, paramString);
        ThreadManager.getSubThreadHandler().postDelayed(new WebSocketProxyImpl.1(this, localWebSocketTask, paramInt1, paramInt2, paramString), 1000L);
      }
      catch (Exception paramString)
      {
        QLog.e("WebSocketProxyImpl", 1, "closeSocket error:", paramString);
      }
    }
    this.a.remove(Integer.valueOf(paramInt1));
    return false;
  }
  
  public boolean connectSocket(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, WebSocketProxy.WebSocketListener paramWebSocketListener)
  {
    paramString1 = new WebSocketProxyImpl.WebSocketTask(this, paramInt1, paramString1, paramMap, paramInt2, paramWebSocketListener);
    this.a.put(Integer.valueOf(paramInt1), paramString1);
    return true;
  }
  
  public boolean send(int paramInt, String paramString)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.a.get(Integer.valueOf(paramInt));
    if ((localWebSocketTask != null) && (localWebSocketTask.d != null)) {
      try
      {
        MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
        localWebSocketTask.d.send(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendStringMessage error:", paramString);
      }
    }
    return false;
  }
  
  public boolean send(int paramInt, byte[] paramArrayOfByte)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = (WebSocketProxyImpl.WebSocketTask)this.a.get(Integer.valueOf(paramInt));
    if ((localWebSocketTask != null) && (localWebSocketTask.d != null)) {
      try
      {
        localWebSocketTask.d.send(ByteString.of(paramArrayOfByte));
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("WebSocketProxyImpl", 1, "sendBinaryMessage error:", paramArrayOfByte);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl
 * JD-Core Version:    0.7.0.1
 */