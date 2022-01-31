package com.tencent.mobileqq.mini.websocket;

import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketCall;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.MiniAppWebsocketListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class WebsocketRequestTask
{
  public static AtomicInteger sId = new AtomicInteger();
  private RequestPlugin.MiniAppWebsocketListener listener;
  private OkHttpClient mOkHttpClient;
  private WebSocketCall mWebSocket;
  private WebsocketRequestTask.RequestParam requestParam;
  
  public WebsocketRequestTask(WebsocketRequestTask.RequestParam paramRequestParam, RequestPlugin.MiniAppWebsocketListener paramMiniAppWebsocketListener)
  {
    paramMiniAppWebsocketListener.currSocketId = (sId.getAndIncrement() + 1);
    Object localObject = new Request.Builder().url(paramRequestParam.url).build().newBuilder();
    if (paramRequestParam.mHeaders != null)
    {
      Iterator localIterator = paramRequestParam.mHeaders.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Request.Builder)localObject).addHeader(str, (String)paramRequestParam.mHeaders.get(str));
      }
    }
    localObject = ((Request.Builder)localObject).build();
    this.mOkHttpClient = new OkHttpClient();
    long l = paramRequestParam.timeout / 1000 + 1;
    this.mOkHttpClient.setConnectTimeout(l, TimeUnit.SECONDS);
    this.mOkHttpClient.setWriteTimeout(l, TimeUnit.SECONDS);
    this.mOkHttpClient.setReadTimeout(0L, TimeUnit.SECONDS);
    this.mWebSocket = WebSocketCall.create(this.mOkHttpClient, (Request)localObject);
    this.mWebSocket.enqueue(paramMiniAppWebsocketListener);
    this.listener = paramMiniAppWebsocketListener;
    this.requestParam = paramRequestParam;
  }
  
  public void closeSocket(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("closeSocket listener ： ").append(this.listener).append(";  listener.webSocket : ");
      if (this.listener == null) {
        break label122;
      }
    }
    for (WebSocket localWebSocket = this.listener.webSocket;; localWebSocket = null)
    {
      QLog.d("WebsocketRequestTask", 2, localWebSocket);
      if ((this.listener != null) && (this.listener.webSocket != null)) {}
      try
      {
        this.listener.webSocket.close(paramInt, paramString);
        ThreadManager.getSubThreadHandler().postDelayed(new WebsocketRequestTask.1(this, paramInt, paramString), 1000L);
        return;
      }
      catch (Throwable localThrowable)
      {
        label122:
        QLog.e("WebsocketRequestTask", 1, "closeSocket error:", localThrowable);
        if ((localThrowable.getMessage() == null) || (!localThrowable.getMessage().contains("closed"))) {
          break;
        }
        this.listener.onClose(paramInt, paramString);
        return;
      }
      finally
      {
        this.listener.webSocket = null;
      }
    }
  }
  
  public void destory()
  {
    if (this.mOkHttpClient != null)
    {
      this.mOkHttpClient.getDispatcher().getExecutorService().shutdown();
      this.mOkHttpClient = null;
    }
  }
  
  public WebsocketRequestTask.RequestParam getRequestParam()
  {
    return this.requestParam;
  }
  
  public void sendBinaryMessage(byte[] paramArrayOfByte)
  {
    if ((this.listener != null) && (this.listener.webSocket != null)) {}
    try
    {
      MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+binary");
      this.listener.webSocket.sendMessage(RequestBody.create(localMediaType, paramArrayOfByte));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      QLog.e("WebsocketRequestTask", 1, "sendBinaryMessage error:", paramArrayOfByte);
      return;
    }
    finally {}
  }
  
  public void sendStringMessage(String paramString)
  {
    if ((this.listener != null) && (this.listener.webSocket != null)) {}
    try
    {
      MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
      this.listener.webSocket.sendMessage(RequestBody.create(localMediaType, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      QLog.e("WebsocketRequestTask", 1, "sendStringMessage error:", paramString);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.websocket.WebsocketRequestTask
 * JD-Core Version:    0.7.0.1
 */