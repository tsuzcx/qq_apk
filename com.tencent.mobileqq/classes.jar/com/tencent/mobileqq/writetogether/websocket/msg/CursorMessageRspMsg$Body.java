package com.tencent.mobileqq.writetogether.websocket.msg;

public class CursorMessageRspMsg$Body
{
  public CursorMessageRspMsg.NoticeWrapper notice;
  
  public CursorMessageRspMsg$Body(CursorMessageRspMsg paramCursorMessageRspMsg, String paramString1, String paramString2, int paramInt)
  {
    this.notice = new CursorMessageRspMsg.NoticeWrapper(paramCursorMessageRspMsg, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg.Body
 * JD-Core Version:    0.7.0.1
 */