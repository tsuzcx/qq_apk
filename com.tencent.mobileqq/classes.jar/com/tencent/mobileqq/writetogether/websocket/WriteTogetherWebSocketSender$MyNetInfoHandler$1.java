package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.qphone.base.util.QLog;

class WriteTogetherWebSocketSender$MyNetInfoHandler$1
  implements Runnable
{
  WriteTogetherWebSocketSender$MyNetInfoHandler$1(WriteTogetherWebSocketSender.MyNetInfoHandler paramMyNetInfoHandler) {}
  
  public void run()
  {
    if (!WriteTogetherWebSocketSender.a(this.a.a).a())
    {
      QLog.w("WriteTogether.WriteTogetherWebSocketSender", 1, "sender waiting for websocket connection");
      WriteTogetherWebSocketSender.a(this.a.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender.MyNetInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */