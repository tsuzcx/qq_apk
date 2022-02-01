package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import java.util.Map;

public final class TuringDIDConfig$Builder
{
  public ITuringDeviceInfoProvider I;
  public Context J;
  public int K;
  public String Q;
  public boolean R;
  public String W;
  public String aa;
  public int ba;
  public String ca;
  public Map<Integer, String> da;
  public String ea;
  public boolean ia;
  public int ja;
  public int ka;
  
  public final Builder appid(String paramString)
  {
    this.ea = paramString;
    return this;
  }
  
  public final TuringDIDConfig build()
  {
    return new TuringDIDConfig(this, null);
  }
  
  public final Builder channel(int paramInt)
  {
    this.K = paramInt;
    return this;
  }
  
  public final Builder clientBuildNo(int paramInt)
  {
    this.ba = paramInt;
    return this;
  }
  
  public final Builder clientChannel(String paramString)
  {
    this.W = paramString;
    return this;
  }
  
  public final Builder clientLc(String paramString)
  {
    this.ca = paramString;
    return this;
  }
  
  public final Builder clientMetaDataMap(Map<Integer, String> paramMap)
  {
    this.da = paramMap;
    return this;
  }
  
  public final Builder clientVersion(String paramString)
  {
    this.aa = paramString;
    return this;
  }
  
  public final Builder loadLibrary(boolean paramBoolean)
  {
    this.R = paramBoolean;
    return this;
  }
  
  public final Builder phyFeature(boolean paramBoolean)
  {
    this.ia = paramBoolean;
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
    this.ka = paramInt;
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
    this.ja = paramInt;
    return this;
  }
  
  public final Builder turingDeviceInfoProvider(ITuringDeviceInfoProvider paramITuringDeviceInfoProvider)
  {
    this.I = paramITuringDeviceInfoProvider;
    return this;
  }
  
  public final Builder uniqueId(String paramString)
  {
    this.Q = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.TuringDIDConfig.Builder
 * JD-Core Version:    0.7.0.1
 */