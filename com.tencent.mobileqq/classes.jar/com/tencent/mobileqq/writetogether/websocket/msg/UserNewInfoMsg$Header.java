package com.tencent.mobileqq.writetogether.websocket.msg;

public class UserNewInfoMsg$Header
  extends BaseHeader
{
  public String docid;
  public String uid;
  public String uuId;
  
  public UserNewInfoMsg$Header()
  {
    this.type = Type.USER_NEWINFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg.Header
 * JD-Core Version:    0.7.0.1
 */