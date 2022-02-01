package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.easysync2.AttribPool;
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
    return AttribPool.class;
  }
  
  Type getHeaderType()
  {
    return UserChangesHeader.class;
  }
  
  protected JsonDeserializer getJsonDeserializer()
  {
    return AttribPool.a();
  }
  
  protected JsonSerializer getJsonSerializer()
  {
    return AttribPool.a();
  }
  
  protected Type getSerializeType()
  {
    return AttribPool.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserChangesReqMsg
 * JD-Core Version:    0.7.0.1
 */