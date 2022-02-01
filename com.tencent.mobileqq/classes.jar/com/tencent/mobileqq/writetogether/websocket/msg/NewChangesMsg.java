package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.JsonDeserializer;
import com.tencent.mobileqq.easysync2.AttribPool;
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
    return AttribPool.class;
  }
  
  Type getHeaderType()
  {
    return AcceptCommitAndNewChangesHeader.class;
  }
  
  protected JsonDeserializer getJsonDeserializer()
  {
    return AttribPool.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.NewChangesMsg
 * JD-Core Version:    0.7.0.1
 */