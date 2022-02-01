package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;

public class SimpleWebSocketAdapter
  implements VWebSocketAdapter
{
  public static String a = "viola.SimpleWebSocketAdapter";
  private WebSocket b;
  private VWebSocketAdapter.EventListener c;
  
  public void close(int paramInt, String paramString)
  {
    Object localObject = this.b;
    if (localObject != null) {
      try
      {
        ((WebSocket)localObject).close(paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("close Exception:");
          localStringBuilder.append(paramString.getMessage());
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void connect(String paramString1, @Nullable String paramString2, VWebSocketAdapter.EventListener paramEventListener)
  {
    this.c = paramEventListener;
    paramEventListener = new OkHttpClient().newBuilder().connectTimeout(3600L, TimeUnit.SECONDS).readTimeout(3600L, TimeUnit.SECONDS).writeTimeout(3600L, TimeUnit.SECONDS).build();
    Request.Builder localBuilder = new Request.Builder();
    if (paramString2 != null) {
      localBuilder.addHeader("Sec-WebSocket-Protocol", paramString2);
    }
    localBuilder.url(paramString1);
    paramEventListener.newWebSocket(localBuilder.build(), new SimpleWebSocketAdapter.1(this));
  }
  
  public void destroy()
  {
    WebSocket localWebSocket = this.b;
    if (localWebSocket != null) {
      try
      {
        localWebSocket.close(WebSocketCloseCodes.CLOSE_GOING_AWAY.getCode(), WebSocketCloseCodes.CLOSE_GOING_AWAY.name());
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("destroy Exception");
          localStringBuilder.append(localException.getMessage());
          QLog.e(str, 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void disconnect() {}
  
  public void send(String paramString)
  {
    Object localObject = this.b;
    if (localObject != null) {
      try
      {
        ((WebSocket)localObject).send(paramString);
        if (!QLog.isDebugVersion()) {
          return;
        }
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("send data:");
        localStringBuilder.append(paramString);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("send Exception:");
          localStringBuilder.append(paramString.getMessage());
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
        paramString.printStackTrace();
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.d(a, 2, "send ws is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.SimpleWebSocketAdapter
 * JD-Core Version:    0.7.0.1
 */