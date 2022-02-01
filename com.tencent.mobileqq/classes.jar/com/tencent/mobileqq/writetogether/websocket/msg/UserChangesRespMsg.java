package com.tencent.mobileqq.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class UserChangesRespMsg
  extends BaseToWriteTogetherMsg<UserChangesHeader, OnPostWrapper>
{
  Type getBodyType()
  {
    return OnPostWrapper.class;
  }
  
  Type getHeaderType()
  {
    return UserChangesHeader.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserChangesRespMsg
 * JD-Core Version:    0.7.0.1
 */