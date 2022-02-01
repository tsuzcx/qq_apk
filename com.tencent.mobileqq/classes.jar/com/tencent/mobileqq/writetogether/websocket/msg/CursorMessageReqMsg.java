package com.tencent.mobileqq.writetogether.websocket.msg;

public class CursorMessageReqMsg
  extends BaseToWriteTogetherMsg<CursorMessageReqMsg.Header, CursorMessageReqMsg.Body>
{
  public CursorMessageReqMsg()
  {
    this.type = Type.CURSOR_MESSAGE;
  }
  
  public CursorMessageReqMsg(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this();
    this.header = new CursorMessageReqMsg.Header(this, paramString1, paramString2, paramString3);
    this.body = new CursorMessageReqMsg.Body(this, paramString2, paramString3, paramInt);
  }
  
  java.lang.reflect.Type getBodyType()
  {
    return CursorMessageReqMsg.Body.class;
  }
  
  java.lang.reflect.Type getHeaderType()
  {
    return CursorMessageReqMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageReqMsg
 * JD-Core Version:    0.7.0.1
 */