package com.tencent.tfd.sdk.wxa;

import android.content.Context;

public final class TuringDIDConfig$Builder
{
  public Context F;
  public String G;
  public int H;
  public int I;
  public String J;
  public String K;
  public int Q;
  public String R;
  public int S;
  
  public final TuringDIDConfig build()
  {
    return new TuringDIDConfig(this, null);
  }
  
  public final Builder channel(int paramInt)
  {
    this.S = paramInt;
    return this;
  }
  
  public final Builder clientBuildNo(int paramInt)
  {
    this.Q = paramInt;
    return this;
  }
  
  public final Builder clientChannel(String paramString)
  {
    this.J = paramString;
    return this;
  }
  
  public final Builder clientLc(String paramString)
  {
    this.R = paramString;
    return this;
  }
  
  public final Builder clientVersion(String paramString)
  {
    this.K = paramString;
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
    this.I = paramInt;
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
    this.H = paramInt;
    return this;
  }
  
  public final Builder uniqueId(String paramString)
  {
    this.G = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.TuringDIDConfig.Builder
 * JD-Core Version:    0.7.0.1
 */