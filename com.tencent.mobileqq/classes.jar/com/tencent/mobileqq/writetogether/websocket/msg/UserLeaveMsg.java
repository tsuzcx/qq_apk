package com.tencent.mobileqq.writetogether.websocket.msg;

public class UserLeaveMsg
  extends BaseToWriteTogetherMsg<UserLeaveMsg.Header, UserLeaveMsg.Body>
{
  public UserLeaveMsg()
  {
    this.type = Type.USER_LEAVE;
  }
  
  java.lang.reflect.Type getBodyType()
  {
    return UserLeaveMsg.Body.class;
  }
  
  java.lang.reflect.Type getHeaderType()
  {
    return UserLeaveMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserLeaveMsg
 * JD-Core Version:    0.7.0.1
 */