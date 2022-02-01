package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class BaseHeader
{
  @SerializedName("group_code")
  public long groupCode;
  public String sig;
  protected Type type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.BaseHeader
 * JD-Core Version:    0.7.0.1
 */