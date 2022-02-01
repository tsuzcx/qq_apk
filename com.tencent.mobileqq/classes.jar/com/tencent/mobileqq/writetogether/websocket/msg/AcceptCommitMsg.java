package com.tencent.mobileqq.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class AcceptCommitMsg
  extends BaseToWriteTogetherMsg<AcceptCommitAndNewChangesHeader, AcceptCommitMsg.Data>
{
  Type getBodyType()
  {
    return AcceptCommitMsg.Data.class;
  }
  
  Type getHeaderType()
  {
    return AcceptCommitAndNewChangesHeader.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.AcceptCommitMsg
 * JD-Core Version:    0.7.0.1
 */