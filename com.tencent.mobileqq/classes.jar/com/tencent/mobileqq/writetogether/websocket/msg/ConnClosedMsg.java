package com.tencent.mobileqq.writetogether.websocket.msg;

public class ConnClosedMsg
  extends BaseToWriteTogetherMsg<BaseHeader, Void>
{
  public ConnClosedMsg()
  {
    this.header = new BaseHeader();
    this.header.type = Type.CONN_CLOSED;
  }
  
  java.lang.reflect.Type getBodyType()
  {
    return Void.TYPE;
  }
  
  java.lang.reflect.Type getHeaderType()
  {
    return BaseHeader.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.ConnClosedMsg
 * JD-Core Version:    0.7.0.1
 */