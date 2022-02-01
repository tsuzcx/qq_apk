package com.tencent.mobileqq.guild.profilecard.main;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

public class ShowToastModel
{
  private int a;
  private String b;
  private IGProSecurityResult c;
  
  public static ShowToastModel a(int paramInt, String paramString)
  {
    ShowToastModel localShowToastModel = new ShowToastModel();
    localShowToastModel.a(paramInt);
    localShowToastModel.a(paramString);
    return localShowToastModel;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(IGProSecurityResult paramIGProSecurityResult)
  {
    this.c = paramIGProSecurityResult;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean b()
  {
    return this.a == 0;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public IGProSecurityResult d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.main.ShowToastModel
 * JD-Core Version:    0.7.0.1
 */