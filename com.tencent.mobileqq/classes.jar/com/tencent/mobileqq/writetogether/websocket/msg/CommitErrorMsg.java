package com.tencent.mobileqq.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class CommitErrorMsg
  extends BaseToWriteTogetherMsg<CommitErrorMsg.Header, CommitErrorMsg.Body>
{
  Type getBodyType()
  {
    return CommitErrorMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return CommitErrorMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CommitErrorMsg
 * JD-Core Version:    0.7.0.1
 */