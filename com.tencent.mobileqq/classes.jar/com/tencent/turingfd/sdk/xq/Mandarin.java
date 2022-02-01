package com.tencent.turingfd.sdk.xq;

import android.os.Build.VERSION;
import java.security.spec.AlgorithmParameterSpec;

public abstract class Mandarin
{
  public static Mandarin a(String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return new Mandarin.do(paramString, paramInt);
    }
    return new Mandarin.if(paramString, paramInt);
  }
  
  public abstract Mandarin a(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec a();
  
  public abstract Mandarin b(String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Mandarin
 * JD-Core Version:    0.7.0.1
 */