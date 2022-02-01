package com.tencent.mobileqq.qqguildsdk.data;

public class ChannelMsgNode
{
  private String a;
  private String b;
  private int c = -1000;
  private int d = -1000;
  private int e = -1000;
  private String f;
  private String g;
  
  public ChannelMsgNode(ChannelMsgNode.Builder paramBuilder)
  {
    this.a = ChannelMsgNode.Builder.a(paramBuilder);
    this.b = ChannelMsgNode.Builder.b(paramBuilder);
    this.c = ChannelMsgNode.Builder.c(paramBuilder);
    this.d = ChannelMsgNode.Builder.d(paramBuilder);
    this.e = ChannelMsgNode.Builder.e(paramBuilder);
    this.f = ChannelMsgNode.Builder.f(paramBuilder);
    this.g = ChannelMsgNode.Builder.g(paramBuilder);
    this.c = ChannelMsgNode.Builder.c(paramBuilder);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelMsgNode{channelId : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", msgNotifyType : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", finalNotifyType : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", fromTId : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("fromNick : ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode
 * JD-Core Version:    0.7.0.1
 */