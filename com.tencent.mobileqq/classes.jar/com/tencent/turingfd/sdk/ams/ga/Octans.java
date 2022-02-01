package com.tencent.turingfd.sdk.ams.ga;

import android.os.Build.VERSION;
import java.security.spec.AlgorithmParameterSpec;

public abstract class Octans
{
  public Octans(String paramString, int paramInt) {}
  
  public static Octans d(String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return new Octans.do(paramString, paramInt);
    }
    return new Octans.if(paramString, paramInt);
  }
  
  public abstract AlgorithmParameterSpec build();
  
  public abstract Octans setDigests(String... paramVarArgs);
  
  public abstract Octans setSignaturePaddings(String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Octans
 * JD-Core Version:    0.7.0.1
 */