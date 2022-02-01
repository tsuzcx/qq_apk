package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class UserNewInfoMsg
  extends BaseToWriteTogetherMsg<UserNewInfoMsg.Header, UserNewInfoMsg.Body>
{
  public UserNewInfoMsg()
  {
    this.type = BaseWriteTogetherMsg.Type.USER_NEWINFO;
  }
  
  Type getBodyType()
  {
    return UserNewInfoMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return UserNewInfoMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg
 * JD-Core Version:    0.7.0.1
 */