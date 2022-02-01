package com.tencent.mobileqq.writetogether.websocket.msg;

public class KickedMsg
  extends BaseToWriteTogetherMsg<BaseHeader, Void>
{
  public KickedMsg()
  {
    this.header = new BaseHeader();
    this.header.type = Type.KICKED;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.KickedMsg
 * JD-Core Version:    0.7.0.1
 */