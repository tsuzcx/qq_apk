package com.tencent.turingfd.sdk.xq;

import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public class Mandarin$if
  extends Mandarin
{
  public final String a;
  public int b;
  public String[] c;
  public String[] d;
  
  public Mandarin$if(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        this.a = paramString;
        this.b = paramInt;
        return;
      }
      throw new IllegalArgumentException("keystoreAlias must not be empty");
    }
    throw new NullPointerException("keystoreAlias == null");
  }
  
  public Mandarin a(String... paramVarArgs)
  {
    String[] arrayOfString = paramVarArgs;
    if (paramVarArgs.length > 0) {
      arrayOfString = (String[])paramVarArgs.clone();
    }
    this.c = arrayOfString;
    return this;
  }
  
  public AlgorithmParameterSpec a()
  {
    Class localClass1 = Class.forName("android.security.keystore.KeyGenParameterSpec");
    Class localClass2 = Integer.TYPE;
    Class localClass3 = Boolean.TYPE;
    return (AlgorithmParameterSpec)localClass1.getConstructor(new Class[] { String.class, localClass2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, localClass2, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, localClass3, localClass3, localClass2 }).newInstance(new Object[] { this.a, Integer.valueOf(-1), null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, Integer.valueOf(-1) });
  }
  
  public Mandarin b(String... paramVarArgs)
  {
    String[] arrayOfString = paramVarArgs;
    if (paramVarArgs.length > 0) {
      arrayOfString = (String[])paramVarArgs.clone();
    }
    this.d = arrayOfString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Mandarin.if
 * JD-Core Version:    0.7.0.1
 */