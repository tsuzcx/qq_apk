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
    this.a.jdField_a_of_type_Boolean = false;
    synchronized (WriteTogetherWebSocketSender.a(this.a))
    {
      WriteTogetherWebSocketSender.a(this.a).notify();
      WriteTogetherWebSocketSender.a(this.a).a(true);
      if (WriteTogetherWebSocketSender.a(this.a).size() == 0) {
        this.a.a(WriteTogetherWebSocketSender.a(this.a).a());
      }
      return;
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWritetogetherClientRoomController.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender.1
 * JD-Core Version:    0.7.0.1
 */