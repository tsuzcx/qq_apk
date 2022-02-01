package com.tencent.mobileqq.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class LastReversionMsg
  extends BaseToWriteTogetherMsg<LastReversionMsg.Head, LastReversionMsg.Body>
{
  Type getBodyType()
  {
    return LastReversionMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return LastReversionMsg.Head.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.LastReversionMsg
 * JD-Core Version:    0.7.0.1
 */