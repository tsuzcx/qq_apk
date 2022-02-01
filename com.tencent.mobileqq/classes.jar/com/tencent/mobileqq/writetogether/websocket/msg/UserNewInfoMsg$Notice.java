package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class UserNewInfoMsg$Notice
{
  public long aliveTime;
  public int colorId;
  @SerializedName("session_type")
  public int sessionType;
  public String userId;
  public String uuId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg.Notice
 * JD-Core Version:    0.7.0.1
 */