package com.tencent.mobileqq.writetogether.websocket;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.writetogether.websocket.msg.ConnClosedMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLException;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class WriteTogetherWebSocketEngine$1
  extends WebSocketListener
{
  WriteTogetherWebSocketEngine$1(WriteTogetherWebSocketEngine paramWriteTogetherWebSocketEngine) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, "onClosed");
    WriteTogetherWebSocketEngine.a(this.a).set(false);
    WriteTogetherWebSocketEngine.a(this.a, null);
    if (this.a.a != null) {
      this.a.a.onClosed(paramWebSocket, paramInt, paramString);
    }
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openWebSocketConn onFailure, e = ");
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    QLog.e("WriteTogether.WriteTogetherWebSocketEngine", 1, localStringBuilder.toString());
    if (this.a.a != null) {
      this.a.a.onFailure(paramWebSocket, paramThrowable, paramResponse);
    }
    if (((paramThrowable instanceof EOFException)) || ((paramThrowable instanceof SocketException)) || ((paramThrowable instanceof SSLException)))
    {
      this.a.c();
      WriteTogetherWebSocketEngine.b(this.a).a(new ConnClosedMsg());
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 2, new Object[] { "onMessage: ", paramString });
    }
    WriteTogetherWebSocketEngine.b(this.a).a(paramString);
    if (this.a.a != null) {
      this.a.a.onMessage(paramWebSocket, paramString);
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    WriteTogetherWebSocketEngine.b(this.a).a(paramByteString);
    if (this.a.a != null) {
      this.a.a.onMessage(paramWebSocket, paramByteString);
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    QLog.d("WriteTogether.WriteTogetherWebSocketEngine", 1, "onOpen");
    WriteTogetherWebSocketEngine.a(this.a, paramWebSocket);
    if (!WriteTogetherWebSocketEngine.a(this.a).get())
    {
      WriteTogetherWebSocketEngine.a(this.a).set(true);
      if (this.a.a != null) {
        this.a.a.onOpen(paramWebSocket, paramResponse);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketEngine.1
 * JD-Core Version:    0.7.0.1
 */