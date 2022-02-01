package com.tencent.mobileqq.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class HeartBeatMsg
  extends BaseToWriteTogetherMsg<HeartBeatMsg.Header, Object>
{
  public HeartBeatMsg() {}
  
  public HeartBeatMsg(String paramString1, String paramString2)
  {
    this.header = new HeartBeatMsg.Header(paramString1, paramString2);
    this.body = new Object();
  }
  
  Type getBodyType()
  {
    return Object.class;
  }
  
  Type getHeaderType()
  {
    return HeartBeatMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.HeartBeatMsg
 * JD-Core Version:    0.7.0.1
 */