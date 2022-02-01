package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.writetogether.client.RoomController;
import java.util.concurrent.LinkedBlockingDeque;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

class WriteTogetherWebSocketSender$1
  extends WebSocketListener
{
  WriteTogetherWebSocketSender$1(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender) {}
  
  public void onClosed(WebSocket arg1, int paramInt, String paramString)
  {
    ??? = this.a;
    ???.a = false;
    synchronized (WriteTogetherWebSocketSender.a(???))
    {
      WriteTogetherWebSocketSender.a(this.a).notify();
      WriteTogetherWebSocketSender.b(this.a).a(true);
      if (WriteTogetherWebSocketSender.c(this.a).size() == 0)
      {
        ??? = this.a;
        ???.a(WriteTogetherWebSocketSender.b(???).a());
      }
      return;
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.a.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender.1
 * JD-Core Version:    0.7.0.1
 */