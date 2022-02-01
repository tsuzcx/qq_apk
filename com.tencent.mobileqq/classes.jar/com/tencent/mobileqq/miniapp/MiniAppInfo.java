package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.HashSet;
import java.util.Set;

public class MiniAppInfo
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public int i;
  public String j = "";
  public String k;
  public long l;
  public long m;
  public long n;
  public Set<String> o = new HashSet();
  public String p;
  public Bundle q;
  public String r;
  public String s;
  public String t;
  
  public MiniAppInfo(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    this.p = a(paramString, paramInt);
    this.q = new Bundle();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String[] a(String paramString)
  {
    return paramString.split("_");
  }
  
  public boolean a()
  {
    return this.n > NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean b()
  {
    return this.l > NetConnInfoCenter.getServerTimeMillis();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppInfo: appId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", platform=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", appPkgUrl=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", wording=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", infoNextReqMillis=");
    localStringBuilder.append(this.l);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */