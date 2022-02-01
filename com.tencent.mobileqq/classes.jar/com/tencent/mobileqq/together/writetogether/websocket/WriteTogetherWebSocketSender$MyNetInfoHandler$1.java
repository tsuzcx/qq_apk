package com.tencent.mobileqq.together.writetogether.websocket;

import beqq;
import bequ;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherWebSocketSender$MyNetInfoHandler$1
  implements Runnable
{
  public WriteTogetherWebSocketSender$MyNetInfoHandler$1(bequ parambequ) {}
  
  public void run()
  {
    if (!WriteTogetherWebSocketSender.a(this.a.a).a())
    {
      QLog.w("WriteTogether.WriteTogetherWebSocketSender", 1, "sender waiting for websocket connection");
      WriteTogetherWebSocketSender.a(this.a.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.WriteTogetherWebSocketSender.MyNetInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */