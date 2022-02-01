package com.tencent.mobileqq.loginregister;

import oicq.wlogin_sdk.tools.ErrMsg;

public class SubSmsLoginErrorInfo
{
  public String a;
  public String b;
  public long c;
  public int d;
  public long e;
  public int f;
  public ErrMsg g;
  
  public SubSmsLoginErrorInfo(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong1;
    this.d = paramInt1;
    this.e = paramLong2;
    this.f = paramInt2;
    this.g = paramErrMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.SubSmsLoginErrorInfo
 * JD-Core Version:    0.7.0.1
 */