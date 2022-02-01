package com.tencent.mobileqq.qqguildsdk.data;

import java.util.List;

public class GuildMsgNode$Builder
{
  private String a;
  private String b;
  private String c;
  private List<ChannelMsgNode> d;
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public Builder a(List<ChannelMsgNode> paramList)
  {
    this.d = paramList;
    return this;
  }
  
  public GuildMsgNode a()
  {
    return new GuildMsgNode(this);
  }
  
  public Builder b(String paramString)
  {
    this.c = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode.Builder
 * JD-Core Version:    0.7.0.1
 */