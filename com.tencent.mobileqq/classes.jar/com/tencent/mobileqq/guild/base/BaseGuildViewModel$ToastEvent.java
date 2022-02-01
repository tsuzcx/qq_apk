package com.tencent.mobileqq.guild.base;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

public class BaseGuildViewModel$ToastEvent
{
  public String a;
  public int b;
  public IGProSecurityResult c;
  
  public BaseGuildViewModel$ToastEvent(int paramInt, String paramString)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public BaseGuildViewModel$ToastEvent(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    this.b = paramInt;
    this.a = paramString;
    this.c = paramIGProSecurityResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent
 * JD-Core Version:    0.7.0.1
 */