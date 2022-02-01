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
  private WriteTogetherWebSocketResHandler jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketWriteTogetherWebSocketResHandler = new WriteTogetherWebSocketResHandler();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  @Nullable
  private WebSocket jdField_a_of_type_Okhttp3WebSocket;
  WebSocketListener jdField_a_of_type_Okhttp3WebSocketListener;
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openWebSocketConn, url = ");
    ((StringBuilder)localObject).append("wss://writetogether.3g.qq.com/websocket");
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, ((StringBuilder)localObject).toString());
    localObject = new Request.Builder().url("wss://writetogether.3g.qq.com/websocket").build().newBuilder().build();
    this.jdField_a_of_type_Okhttp3OkHttpClient = new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    this.jdField_a_of_type_Okhttp3OkHttpClient.newWebSocket((Request)localObject, new WriteTogetherWebSocketEngine.1(this));
  }
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    if (!a()) {
      a();
    }
    if ((a()) && (this.jdField_a_of_type_Okhttp3WebSocket != null))
    {
      paramBaseToWriteTogetherMsg = paramBaseToWriteTogetherMsg.toJson();
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 2, new Object[] { "sendData: ", paramBaseToWriteTogetherMsg });
      }
      this.jdField_a_of_type_Okhttp3WebSocket.send(paramBaseToWriteTogetherMsg);
    }
  }
  
  void a(WebSocketListener paramWebSocketListener)
  {
    this.jdField_a_of_type_Okhttp3WebSocketListener = paramWebSocketListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    WebSocket localWebSocket = this.jdField_a_of_type_Okhttp3WebSocket;
    if (localWebSocket != null)
    {
      localWebSocket.close(1000, null);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketEngine
 * JD-Core Version:    0.7.0.1
 */