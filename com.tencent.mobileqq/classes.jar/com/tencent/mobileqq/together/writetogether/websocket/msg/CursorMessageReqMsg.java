package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class CursorMessageReqMsg
  extends BaseToWriteTogetherMsg<CursorMessageReqMsg.Header, CursorMessageReqMsg.Body>
{
  public CursorMessageReqMsg()
  {
    this.type = BaseWriteTogetherMsg.Type.CURSOR_MESSAGE;
  }
  
  public CursorMessageReqMsg(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this();
    this.header = new CursorMessageReqMsg.Header(this, paramString1, paramString2, paramString3);
    this.body = new CursorMessageReqMsg.Body(this, paramString2, paramString3, paramInt);
  }
  
  Type getBodyType()
  {
    return CursorMessageReqMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return CursorMessageReqMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageReqMsg
 * JD-Core Version:    0.7.0.1
 */