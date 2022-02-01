package com.tencent.turingfd.sdk.ams.ga;

import android.security.keystore.KeyGenParameterSpec.Builder;
import java.security.spec.AlgorithmParameterSpec;

public class Octans$do
  extends Octans
{
  public KeyGenParameterSpec.Builder ce = null;
  
  public Octans$do(String paramString, int paramInt)
  {
    super(paramString, paramInt);
    this.ce = new KeyGenParameterSpec.Builder(paramString, paramInt);
  }
  
  public AlgorithmParameterSpec build()
  {
    return this.ce.build();
  }
  
  public Octans setDigests(String... paramVarArgs)
  {
    this.ce.setDigests(paramVarArgs);
    return this;
  }
  
  public Octans setSignaturePaddings(String... paramVarArgs)
  {
    this.ce.setSignaturePaddings(paramVarArgs);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Octans.do
 * JD-Core Version:    0.7.0.1
 */