package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class ConnClosedMsg
  extends BaseToWriteTogetherMsg<BaseHeader, Void>
{
  public ConnClosedMsg()
  {
    this.header = new BaseHeader();
    this.header.type = BaseWriteTogetherMsg.Type.CONN_CLOSED;
  }
  
  Type getBodyType()
  {
    return Void.TYPE;
  }
  
  Type getHeaderType()
  {
    return BaseHeader.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.ConnClosedMsg
 * JD-Core Version:    0.7.0.1
 */