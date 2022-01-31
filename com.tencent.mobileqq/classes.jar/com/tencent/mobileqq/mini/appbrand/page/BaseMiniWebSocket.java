package com.tencent.mobileqq.mini.appbrand.page;

import android.os.Handler;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketCall;
import com.squareup.okhttp.ws.WebSocketListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class BaseMiniWebSocket
{
  public static final String TAG = "ServiceRemoteRuntime";
  protected WebSocketListener mListener;
  private OkHttpClient mOkHttpClient;
  protected Handler mThreadHandler;
  protected WebSocket mWebSocket;
  private WebSocketCall mWebSocketCall;
  
  public void closeSocket(int paramInt, String paramString)
  {
    if (this.mWebSocket != null) {}
    try
    {
      this.mWebSocket.close(paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void connect(String paramString)
  {
    this.mOkHttpClient = new OkHttpClient();
    this.mOkHttpClient.setConnectTimeout(30L, TimeUnit.SECONDS);
    this.mOkHttpClient.setWriteTimeout(30L, TimeUnit.SECONDS);
    this.mOkHttpClient.setReadTimeout(30L, TimeUnit.SECONDS);
    paramString = new Request.Builder().url(paramString).build();
    this.mWebSocketCall = WebSocketCall.create(this.mOkHttpClient, paramString);
    if (this.mListener != null) {
      this.mWebSocketCall.enqueue(this.mListener);
    }
  }
  
  public void destroy()
  {
    if (this.mOkHttpClient != null)
    {
      this.mOkHttpClient.getDispatcher().getExecutorService().shutdown();
      this.mOkHttpClient = null;
    }
  }
  
  public void sendStringMessage(String paramString)
  {
    if ((this.mWebSocket != null) && (this.mThreadHandler != null)) {
      this.mThreadHandler.post(new BaseMiniWebSocket.1(this, paramString));
    }
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.mThreadHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.BaseMiniWebSocket
 * JD-Core Version:    0.7.0.1
 */