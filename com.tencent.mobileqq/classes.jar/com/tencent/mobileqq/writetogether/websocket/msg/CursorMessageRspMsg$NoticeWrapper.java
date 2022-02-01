package com.tencent.mobileqq.writetogether.websocket.msg;

public class CursorMessageRspMsg$NoticeWrapper
{
  public CursorMessageRspMsg.Notice notice;
  public String uuId;
  
  public CursorMessageRspMsg$NoticeWrapper(CursorMessageRspMsg paramCursorMessageRspMsg, String paramString1, String paramString2, int paramInt)
  {
    this.uuId = paramString2;
    this.notice = new CursorMessageRspMsg.Notice(paramCursorMessageRspMsg, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg.NoticeWrapper
 * JD-Core Version:    0.7.0.1
 */