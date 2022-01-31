package com.tencent.turingfd.sdk.xq;

import android.content.Context;

public final class TuringDIDConfig$Builder
{
  public Context l;
  public String m;
  public int n;
  public int o;
  public String p;
  public String s;
  public String t;
  public int u;
  public String v;
  
  public final Builder appid(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public final TuringDIDConfig build()
  {
    return new TuringDIDConfig(this, null);
  }
  
  public final Builder clientBuildNo(int paramInt)
  {
    this.u = paramInt;
    return this;
  }
  
  public final Builder clientChannel(String paramString)
  {
    this.s = paramString;
    return this;
  }
  
  public final Builder clientLc(String paramString)
  {
    this.v = paramString;
    return this;
  }
  
  public final Builder clientVersion(String paramString)
  {
    this.t = paramString;
    return this;
  }
  
  public final Builder retryTime(int paramInt)
  {
    int i = 10;
    int j = 1;
    if (paramInt < 1) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt > 10) {
        paramInt = i;
      }
      for (;;)
      {
        this.o = paramInt;
        return this;
      }
    }
  }
  
  public final Builder timeout(int paramInt)
  {
    int i = 10000;
    int j = 500;
    if (paramInt < 500) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt > 10000) {
        paramInt = i;
      }
      for (;;)
      {
        this.n = paramInt;
        return this;
      }
    }
  }
  
  public final Builder userId(String paramString)
  {
    this.m = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringDIDConfig.Builder
 * JD-Core Version:    0.7.0.1
 */