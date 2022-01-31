package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;

public class ProbeRequest
{
  private String ip;
  ProbeItem root;
  int trigglePoint;
  
  public ProbeRequest(String paramString, int paramInt, ProbeItem paramProbeItem)
  {
    this.ip = paramString;
    this.root = paramProbeItem;
    this.trigglePoint = paramInt;
  }
  
  public ProbeRequest(String paramString, ProbeItem paramProbeItem)
  {
    this(paramString, -1, paramProbeItem);
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.ip)) {
      return "unkonw";
    }
    return this.ip;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeRequest
 * JD-Core Version:    0.7.0.1
 */