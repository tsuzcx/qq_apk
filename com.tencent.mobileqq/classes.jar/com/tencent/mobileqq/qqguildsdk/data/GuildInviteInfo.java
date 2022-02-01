package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

public class GuildInviteInfo
  implements IGuildInviteInfo
{
  private GProInviteInfo a;
  
  public GuildInviteInfo(GProInviteInfo paramGProInviteInfo)
  {
    this.a = paramGProInviteInfo;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getGuildId());
  }
  
  public String b()
  {
    return GProConvert.a(this.a.getChnId());
  }
  
  public String c()
  {
    return this.a.getName();
  }
  
  public String d()
  {
    return this.a.getNickName();
  }
  
  public String e()
  {
    return this.a.getBase64Avatar();
  }
  
  public String f()
  {
    return this.a.getJoinSig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildInviteInfo
 * JD-Core Version:    0.7.0.1
 */