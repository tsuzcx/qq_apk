package com.tencent.mobileqq.writetogether.websocket;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WriteTogetherWebSocketEngine
{
  WebSocketListener a;
  private AtomicBoolean b = new AtomicBoolean(false);
  @Nullable
  private WebSocket c;
  private OkHttpClient d;
  private WriteTogetherWebSocketResHandler e = new WriteTogetherWebSocketResHandler();
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    if (!a()) {
      b();
    }
    if ((a()) && (this.c != null))
    {
      paramBaseToWriteTogetherMsg = paramBaseToWriteTogetherMsg.toJson();
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 2, new Object[] { "sendData: ", paramBaseToWriteTogetherMsg });
      }
      this.c.send(paramBaseToWriteTogetherMsg);
    }
  }
  
  void a(WebSocketListener paramWebSocketListener)
  {
    this.a = paramWebSocketListener;
  }
  
  public boolean a()
  {
    return this.b.get();
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openWebSocketConn, url = ");
    ((StringBuilder)localObject).append("wss://writetogether.3g.qq.com/websocket");
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, ((StringBuilder)localObject).toString());
    localObject = new Request.Builder().url("wss://writetogether.3g.qq.com/websocket").build().newBuilder().build();
    this.d = new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    this.d.newWebSocket((Request)localObject, new WriteTogetherWebSocketEngine.1(this));
  }
  
  public void c()
  {
    WebSocket localWebSocket = this.c;
    if (localWebSocket != null)
    {
      localWebSocket.close(1000, null);
      this.b.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketEngine
 * JD-Core Version:    0.7.0.1
 */