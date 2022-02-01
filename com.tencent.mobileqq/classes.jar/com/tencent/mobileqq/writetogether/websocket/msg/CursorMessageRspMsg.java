package com.tencent.mobileqq.writetogether.websocket.msg;

public class CursorMessageRspMsg
  extends BaseToWriteTogetherMsg<CursorMessageRspMsg.Header, CursorMessageRspMsg.Body>
{
  public CursorMessageRspMsg()
  {
    this.type = Type.CURSOR_MESSAGE;
  }
  
  public CursorMessageRspMsg(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this();
    this.header = new CursorMessageRspMsg.Header(this, paramString1, paramString2, paramString3);
    this.body = new CursorMessageRspMsg.Body(this, paramString2, paramString3, paramInt);
  }
  
  java.lang.reflect.Type getBodyType()
  {
    return CursorMessageRspMsg.Body.class;
  }
  
  java.lang.reflect.Type getHeaderType()
  {
    return CursorMessageRspMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageRspMsg
 * JD-Core Version:    0.7.0.1
 */