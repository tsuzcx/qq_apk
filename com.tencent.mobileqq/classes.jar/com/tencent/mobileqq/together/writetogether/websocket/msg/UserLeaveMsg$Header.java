package com.tencent.mobileqq.together.writetogether.websocket.msg;

public class UserLeaveMsg$Header
  extends BaseHeader
{
  public String docid;
  public String uid;
  public String uuId;
  
  public UserLeaveMsg$Header()
  {
    this.type = BaseWriteTogetherMsg.Type.USER_LEAVE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.UserLeaveMsg.Header
 * JD-Core Version:    0.7.0.1
 */