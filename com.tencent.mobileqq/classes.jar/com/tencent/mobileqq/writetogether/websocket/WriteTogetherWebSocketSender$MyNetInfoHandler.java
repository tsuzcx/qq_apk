package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.app.ThreadManagerV2;

class WriteTogetherWebSocketSender$MyNetInfoHandler
  extends NetChangedListener
{
  private WriteTogetherWebSocketSender$MyNetInfoHandler(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender) {}
  
  protected void a()
  {
    ThreadManagerV2.excute(new WriteTogetherWebSocketSender.MyNetInfoHandler.1(this), 128, null, true);
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */