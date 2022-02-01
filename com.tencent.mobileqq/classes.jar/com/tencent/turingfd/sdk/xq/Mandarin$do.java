package com.tencent.turingfd.sdk.xq;

import android.security.keystore.KeyGenParameterSpec.Builder;
import java.security.spec.AlgorithmParameterSpec;

public class Mandarin$do
  extends Mandarin
{
  public KeyGenParameterSpec.Builder a = null;
  
  public Mandarin$do(String paramString, int paramInt)
  {
    this.a = new KeyGenParameterSpec.Builder(paramString, paramInt);
  }
  
  public Mandarin a(String... paramVarArgs)
  {
    this.a.setDigests(paramVarArgs);
    return this;
  }
  
  public AlgorithmParameterSpec a()
  {
    return this.a.build();
  }
  
  public Mandarin b(String... paramVarArgs)
  {
    this.a.setSignaturePaddings(paramVarArgs);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Mandarin.do
 * JD-Core Version:    0.7.0.1
 */