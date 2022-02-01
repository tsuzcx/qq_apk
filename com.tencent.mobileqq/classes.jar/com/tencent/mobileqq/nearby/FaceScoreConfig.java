package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class FaceScoreConfig
{
  public boolean a = false;
  public boolean b = false;
  public long c = 0L;
  public String d = "";
  public String e = "";
  public String f = "";
  
  public FaceScoreConfig() {}
  
  public FaceScoreConfig(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramLong;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public boolean a()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = this.c;
    return (l2 <= 0L) || (l1 > l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.FaceScoreConfig
 * JD-Core Version:    0.7.0.1
 */