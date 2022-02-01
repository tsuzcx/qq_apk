package com.tencent.mobileqq.together.writetogether.websocket.msg;

import bdef;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class UserChangesReqMsg
  extends BaseToWriteTogetherMsg<UserChangesHeader, UserChangesReqMsg.UserChangesReqBody>
{
  public UserChangesReqMsg() {}
  
  public UserChangesReqMsg(UserChangesHeader paramUserChangesHeader, UserChangesReqMsg.UserChangesReqBody paramUserChangesReqBody)
  {
    this.header = paramUserChangesHeader;
    this.body = paramUserChangesReqBody;
  }
  
  Type getBodyType()
  {
    return UserChangesReqMsg.UserChangesReqBody.class;
  }
  
  protected Type getDeserializeType()
  {
    return bdef.class;
  }
  
  Type getHeaderType()
  {
    return UserChangesHeader.class;
  }
  
  protected JsonDeserializer getJsonDeserializer()
  {
    return bdef.a();
  }
  
  protected JsonSerializer getJsonSerializer()
  {
    return bdef.a();
  }
  
  protected Type getSerializeType()
  {
    return bdef.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.UserChangesReqMsg
 * JD-Core Version:    0.7.0.1
 */