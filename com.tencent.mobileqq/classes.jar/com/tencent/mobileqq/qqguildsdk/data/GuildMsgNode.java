package com.tencent.mobileqq.qqguildsdk.data;

import java.util.List;

public class GuildMsgNode
{
  private String a;
  private String b;
  private String c;
  private List<ChannelMsgNode> d;
  
  public GuildMsgNode(GuildMsgNode.Builder paramBuilder)
  {
    this.a = GuildMsgNode.Builder.a(paramBuilder);
    this.b = GuildMsgNode.Builder.b(paramBuilder);
    this.c = GuildMsgNode.Builder.c(paramBuilder);
    this.d = GuildMsgNode.Builder.d(paramBuilder);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public List<ChannelMsgNode> d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildMsgNode{guildId : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", showNumber : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", name : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", channelMsgNodeList size : ");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode
 * JD-Core Version:    0.7.0.1
 */