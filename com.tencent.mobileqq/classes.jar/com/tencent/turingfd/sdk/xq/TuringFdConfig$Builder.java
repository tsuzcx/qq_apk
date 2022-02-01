package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public final class TuringFdConfig$Builder
{
  public int Ad;
  public int Bd;
  public int Gh;
  public int Hh;
  public int Ih;
  public int Jh;
  public WeakReference<Activity> Kh;
  public int Lh;
  public String metaData;
  public String pd;
  public String sd;
  public int ta;
  public String td;
  public int ud;
  public Context v;
  public String vd;
  public String ya;
  public boolean yd;
  
  public final Builder alwaysSyncReq(boolean paramBoolean)
  {
    this.yd = paramBoolean;
    return this;
  }
  
  public final Builder appid(String paramString)
  {
    this.ya = paramString;
    return this;
  }
  
  public TuringFdConfig build()
  {
    return new TuringFdConfig(this, null);
  }
  
  public final Builder channel(int paramInt)
  {
    this.ta = paramInt;
    return this;
  }
  
  public final Builder clientAppid(int paramInt)
  {
    this.Lh = paramInt;
    return this;
  }
  
  public final Builder clientBuildNo(int paramInt)
  {
    this.ud = paramInt;
    return this;
  }
  
  public final Builder clientChannel(String paramString)
  {
    this.sd = paramString;
    return this;
  }
  
  public final Builder clientLc(String paramString)
  {
    this.vd = paramString;
    return this;
  }
  
  public final Builder clientVersion(String paramString)
  {
    this.td = paramString;
    return this;
  }
  
  public final Builder metaData(String paramString)
  {
    this.metaData = paramString;
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
        this.Bd = paramInt;
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
        this.Ad = paramInt;
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringFdConfig.Builder
 * JD-Core Version:    0.7.0.1
 */