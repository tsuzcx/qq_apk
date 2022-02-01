package com.tencent.mobileqq.together.writetogether.websocket.msg;

public class UserNewInfoMsg$Header
  extends BaseHeader
{
  public String docid;
  public String uid;
  public String uuId;
  
  public UserNewInfoMsg$Header()
  {
    this.type = BaseWriteTogetherMsg.Type.USER_NEWINFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg.Header
 * JD-Core Version:    0.7.0.1
 */