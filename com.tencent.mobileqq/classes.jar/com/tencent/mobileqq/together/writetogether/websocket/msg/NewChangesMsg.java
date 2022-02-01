package com.tencent.mobileqq.together.writetogether.websocket.msg;

import bdef;
import com.google.gson.JsonDeserializer;
import java.lang.reflect.Type;

public class NewChangesMsg
  extends BaseToWriteTogetherMsg<AcceptCommitAndNewChangesHeader, NewChangesMsg.Body>
{
  Type getBodyType()
  {
    return NewChangesMsg.Body.class;
  }
  
  protected Type getDeserializeType()
  {
    return bdef.class;
  }
  
  Type getHeaderType()
  {
    return AcceptCommitAndNewChangesHeader.class;
  }
  
  protected JsonDeserializer getJsonDeserializer()
  {
    return bdef.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.NewChangesMsg
 * JD-Core Version:    0.7.0.1
 */