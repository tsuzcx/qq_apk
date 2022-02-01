package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class CursorMessageRspMsg
  extends BaseToWriteTogetherMsg<CursorMessageRspMsg.Header, CursorMessageRspMsg.Body>
{
  public CursorMessageRspMsg()
  {
    this.type = BaseWriteTogetherMsg.Type.CURSOR_MESSAGE;
  }
  
  public CursorMessageRspMsg(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this();
    this.header = new CursorMessageRspMsg.Header(this, paramString1, paramString2, paramString3);
    this.body = new CursorMessageRspMsg.Body(this, paramString2, paramString3, paramInt);
  }
  
  Type getBodyType()
  {
    return CursorMessageRspMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return CursorMessageRspMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg
 * JD-Core Version:    0.7.0.1
 */