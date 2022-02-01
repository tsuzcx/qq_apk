package com.tencent.mobileqq.writetogether.websocket.msg;

public class CursorMessageReqMsg$Notice
{
  public int gcp;
  public String userId;
  public String uuId;
  
  public CursorMessageReqMsg$Notice(CursorMessageReqMsg paramCursorMessageReqMsg, String paramString1, String paramString2, int paramInt)
  {
    this.userId = paramString1;
    this.uuId = paramString2;
    this.gcp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageReqMsg.Notice
 * JD-Core Version:    0.7.0.1
 */