package com.tencent.mobileqq.guild.widget;

public class ChannelTitleLayout$LayoutParamBuilder
{
  private String a = "";
  private String b = "";
  private boolean c = false;
  private boolean d = false;
  private String e = "";
  private int f = 0;
  
  public LayoutParamBuilder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public LayoutParamBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public LayoutParamBuilder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public ChannelTitleLayout.Param a()
  {
    return new ChannelTitleLayout.Param(this.a, this.b, this.c, this.d, this.e, this.f);
  }
  
  public LayoutParamBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public LayoutParamBuilder b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public LayoutParamBuilder c(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.ChannelTitleLayout.LayoutParamBuilder
 * JD-Core Version:    0.7.0.1
 */