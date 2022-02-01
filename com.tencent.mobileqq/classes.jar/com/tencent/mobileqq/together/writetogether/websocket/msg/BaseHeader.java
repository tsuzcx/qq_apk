package com.tencent.mobileqq.together.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class BaseHeader
{
  @SerializedName("group_code")
  public long groupCode;
  public String sig;
  protected BaseWriteTogetherMsg.Type type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.BaseHeader
 * JD-Core Version:    0.7.0.1
 */