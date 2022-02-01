package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class UserLeaveMsg
  extends BaseToWriteTogetherMsg<UserLeaveMsg.Header, UserLeaveMsg.Body>
{
  public UserLeaveMsg()
  {
    this.type = BaseWriteTogetherMsg.Type.USER_LEAVE;
  }
  
  Type getBodyType()
  {
    return UserLeaveMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return UserLeaveMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.UserLeaveMsg
 * JD-Core Version:    0.7.0.1
 */