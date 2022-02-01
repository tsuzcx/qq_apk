package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class OnPostResult
{
  @SerializedName("errmsg")
  public String errMsg;
  public int result;
  @SerializedName("retry_interval")
  public int retryInterval;
  @SerializedName("retry_times")
  public int retryTimes;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.OnPostResult
 * JD-Core Version:    0.7.0.1
 */