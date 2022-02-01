package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class TuringFdConfig$Builder
{
  public String Ad;
  public int Ai;
  public int Bd;
  public int Bi;
  public String Cd;
  public int Ci;
  public String Da;
  public Map<Integer, String> Dd;
  public int Di;
  public WeakReference<Activity> Ei;
  public Context F;
  public int Fi;
  public boolean Gd;
  public ITuringPrivacyLite Gi;
  public int Id;
  public int Jd;
  public String metaData;
  public String vd;
  public int ya;
  public String zd;
  
  public final Builder alwaysSyncReq(boolean paramBoolean)
  {
    this.Gd = paramBoolean;
    return this;
  }
  
  public final Builder appid(String paramString)
  {
    this.Da = paramString;
    return this;
  }
  
  public TuringFdConfig build()
  {
    return new TuringFdConfig(this, null);
  }
  
  public final Builder channel(int paramInt)
  {
    this.ya = paramInt;
    return this;
  }
  
  public final Builder clientAppid(int paramInt)
  {
    this.Fi = paramInt;
    return this;
  }
  
  public final Builder clientBuildNo(int paramInt)
  {
    this.Bd = paramInt;
    return this;
  }
  
  public final Builder clientChannel(String paramString)
  {
    this.zd = paramString;
    return this;
  }
  
  public final Builder clientLc(String paramString)
  {
    this.Cd = paramString;
    return this;
  }
  
  public final Builder clientMetaDataMap(Map<Integer, String> paramMap)
  {
    this.Dd = paramMap;
    return this;
  }
  
  public final Builder clientVersion(String paramString)
  {
    this.Ad = paramString;
    return this;
  }
  
  public final Builder metaData(String paramString)
  {
    this.metaData = paramString;
    return this;
  }
  
  public final Builder retryTime(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    paramInt = i;
    if (i > 10) {
      paramInt = 10;
    }
    this.Jd = paramInt;
    return this;
  }
  
  public final Builder timeout(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 500) {
      i = 500;
    }
    paramInt = i;
    if (i > 10000) {
      paramInt = 10000;
    }
    this.Id = paramInt;
    return this;
  }
  
  public final Builder turingPrivacyLite(ITuringPrivacyLite paramITuringPrivacyLite)
  {
    this.Gi = paramITuringPrivacyLite;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringFdConfig.Builder
 * JD-Core Version:    0.7.0.1
 */