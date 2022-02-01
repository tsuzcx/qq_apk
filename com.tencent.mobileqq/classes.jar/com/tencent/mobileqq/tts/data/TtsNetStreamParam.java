package com.tencent.mobileqq.tts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtsNetStreamParam
{
  private static long sReqSeq;
  @SerializedName("appid")
  public String appId;
  public int businessID;
  public String clientVersion;
  public int net;
  @Expose(serialize=false)
  public String sKey;
  public Long sendUin;
  public Long seq;
  public String text;
  public String textMd5;
  public Long uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.TtsNetStreamParam
 * JD-Core Version:    0.7.0.1
 */