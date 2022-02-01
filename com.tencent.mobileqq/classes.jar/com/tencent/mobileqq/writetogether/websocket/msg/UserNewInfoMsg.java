package com.tencent.mobileqq.writetogether.websocket.msg;

public class UserNewInfoMsg
  extends BaseToWriteTogetherMsg<UserNewInfoMsg.Header, UserNewInfoMsg.Body>
{
  public UserNewInfoMsg()
  {
    this.type = Type.USER_NEWINFO;
  }
  
  java.lang.reflect.Type getBodyType()
  {
    return UserNewInfoMsg.Body.class;
  }
  
  java.lang.reflect.Type getHeaderType()
  {
    return UserNewInfoMsg.Header.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg
 * JD-Core Version:    0.7.0.1
 */