package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

public class GProUserInfo
  implements IGProUserInfo
{
  private GProUser a;
  private String b;
  
  public GProUserInfo(GProUser paramGProUser)
  {
    this.a = paramGProUser;
    this.b = GProConvert.a(paramGProUser.getTinyId());
  }
  
  public GProUserInfo a(GProUser paramGProUser)
  {
    this.a = paramGProUser;
    return this;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.a.getMemberName();
  }
  
  public String c()
  {
    return this.a.getNickName();
  }
  
  public int d()
  {
    return this.a.getType();
  }
  
  public long e()
  {
    return this.a.getJoinTime();
  }
  
  public int f()
  {
    return this.a.getRobotType();
  }
  
  public boolean g()
  {
    return this.a.getGuildMute();
  }
  
  public boolean h()
  {
    return this.a.getInBlack();
  }
  
  public IGProClientIdentityInfo i()
  {
    return new GProClientIdentityInfo(this.a.getClientIdentity());
  }
  
  public IGProClientPresenceInfo j()
  {
    return new GProClientPresenceInfo(this.a.getClientPresence());
  }
  
  public GProUser k()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("GProUserInfo{");
    localStringBuffer.append("mUser=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", tinyId='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProUserInfo
 * JD-Core Version:    0.7.0.1
 */