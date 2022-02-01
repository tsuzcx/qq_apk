package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProGuildJoin;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

public class GuildJoinInfo
  implements IGuildJoinInfo
{
  private GProGuildJoin a;
  
  public GuildJoinInfo(GProGuildJoin paramGProGuildJoin)
  {
    this.a = paramGProGuildJoin;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getGuildId());
  }
  
  public String b()
  {
    return this.a.getName();
  }
  
  public String c()
  {
    return this.a.getAvatar();
  }
  
  public String d()
  {
    return this.a.getJoinSig();
  }
  
  public String e()
  {
    return GProConvert.a(this.a.getUserId());
  }
  
  public int f()
  {
    return this.a.getUserType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildJoinInfo
 * JD-Core Version:    0.7.0.1
 */