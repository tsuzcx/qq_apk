package com.tencent.turingfd.sdk.ams.ga;

import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public class Octans$if
  extends Octans
{
  public final String de;
  public int ee;
  public int fe = -1;
  public AlgorithmParameterSpec ge;
  public X500Principal he;
  public BigInteger ie;
  public Date je;
  public Date ke;
  public Date le;
  public Date me;
  public Date ne;
  public String[] oe;
  public String[] pe;
  public String[] qe;
  public String[] re;
  public boolean se = true;
  public boolean te;
  public int ue = -1;
  
  public Octans$if(String paramString, int paramInt)
  {
    super(paramString, paramInt);
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        this.de = paramString;
        this.ee = paramInt;
        return;
      }
      throw new IllegalArgumentException("keystoreAlias must not be empty");
    }
    throw new NullPointerException("keystoreAlias == null");
  }
  
  public AlgorithmParameterSpec build()
  {
    Class localClass1 = Class.forName("android.security.keystore.KeyGenParameterSpec");
    Class localClass2 = Integer.TYPE;
    Class localClass3 = Boolean.TYPE;
    return (AlgorithmParameterSpec)localClass1.getConstructor(new Class[] { String.class, localClass2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, localClass2, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, [Ljava.lang.String.class, localClass3, localClass3, Integer.TYPE }).newInstance(new Object[] { this.de, Integer.valueOf(this.fe), this.ge, this.he, this.ie, this.je, this.ke, this.le, this.me, this.ne, Integer.valueOf(this.ee), this.oe, this.pe, this.qe, this.re, Boolean.valueOf(this.se), Boolean.valueOf(this.te), Integer.valueOf(this.ue) });
  }
  
  public Octans setDigests(String... paramVarArgs)
  {
    String[] arrayOfString = paramVarArgs;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length > 0) {
        arrayOfString = (String[])paramVarArgs.clone();
      }
    }
    this.oe = arrayOfString;
    return this;
  }
  
  public Octans setSignaturePaddings(String... paramVarArgs)
  {
    String[] arrayOfString = paramVarArgs;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length > 0) {
        arrayOfString = (String[])paramVarArgs.clone();
      }
    }
    this.qe = arrayOfString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Octans.if
 * JD-Core Version:    0.7.0.1
 */