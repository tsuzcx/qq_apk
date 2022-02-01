package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.jsonconverter.Alias;

public class ResInfo
{
  @Alias(a="resType")
  public int a = 0;
  @Alias(a="sourceId")
  public int b = 0;
  @Alias(a="sourceUrl")
  public String c = "";
  @Alias(a="sourceMd5")
  public String d = "";
  @Alias(a="name")
  public String e = "";
  @Alias(a="predownload")
  public int f = 1;
  @Alias(a="downloading")
  public boolean g = false;
  @Alias(a="isShow")
  public int h = 1;
  @Alias(a="showInApp")
  public int i;
  @Alias(a="orderIndex")
  public int j = 0;
  
  ResInfo a(ResInfo paramResInfo)
  {
    ResInfo localResInfo = new ResInfo();
    localResInfo.a = paramResInfo.a;
    localResInfo.b = paramResInfo.b;
    localResInfo.c = paramResInfo.c;
    localResInfo.d = paramResInfo.d;
    localResInfo.e = paramResInfo.e;
    localResInfo.f = paramResInfo.f;
    localResInfo.g = paramResInfo.g;
    localResInfo.h = paramResInfo.h;
    localResInfo.i = paramResInfo.i;
    localResInfo.j = paramResInfo.j;
    return localResInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ResInfo
 * JD-Core Version:    0.7.0.1
 */