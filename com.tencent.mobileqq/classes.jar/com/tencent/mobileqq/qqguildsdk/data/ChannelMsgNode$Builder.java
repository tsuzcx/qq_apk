package com.tencent.mobileqq.qqguildsdk.data;

public class ChannelMsgNode$Builder
{
  private String a;
  private String b;
  private int c = -1000;
  private int d = -1000;
  private int e = -1000;
  private String f;
  private String g;
  
  public Builder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ChannelMsgNode a()
  {
    return new ChannelMsgNode(this);
  }
  
  public Builder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode.Builder
 * JD-Core Version:    0.7.0.1
 */