package com.tencent.mobileqq.writetogether.websocket.msg;

public class CursorMessageRspMsg$Notice
{
  public int gcp;
  public String userId;
  public String uuId;
  
  public CursorMessageRspMsg$Notice(CursorMessageRspMsg paramCursorMessageRspMsg, String paramString1, String paramString2, int paramInt)
  {
    this.userId = paramString1;
    this.uuId = paramString2;
    this.gcp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg.Notice
 * JD-Core Version:    0.7.0.1
 */