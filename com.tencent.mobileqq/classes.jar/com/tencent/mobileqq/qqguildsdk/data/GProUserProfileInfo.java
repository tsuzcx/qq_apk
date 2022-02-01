package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProGuildUserProfile;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import java.util.ArrayList;

public class GProUserProfileInfo
  implements IGProUserProfileInfo
{
  private final GProGuildUserProfile a;
  
  public GProUserProfileInfo(GProGuildUserProfile paramGProGuildUserProfile)
  {
    this.a = paramGProGuildUserProfile;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getTinyId());
  }
  
  public String b()
  {
    return this.a.getAvatarUrl();
  }
  
  public String c()
  {
    return this.a.getNick();
  }
  
  public int d()
  {
    return this.a.getGender();
  }
  
  public short e()
  {
    return this.a.getBirthDay();
  }
  
  public byte f()
  {
    return this.a.getAge();
  }
  
  public String g()
  {
    return this.a.getCountry();
  }
  
  public String h()
  {
    return this.a.getProvince();
  }
  
  public String i()
  {
    return this.a.getCity();
  }
  
  public int j()
  {
    return this.a.getUserType();
  }
  
  public long k()
  {
    return this.a.getJoinTime();
  }
  
  public String l()
  {
    return this.a.getMemberName();
  }
  
  public GuildUserAvatar m()
  {
    return new GuildUserAvatar(GProConvert.a(this.a.getTinyId()), this.a.getAvatarUrl(), this.a.getAvatarSizeFlag(), this.a.getAvatarTimeStamp());
  }
  
  public IGProClientPresenceInfo n()
  {
    return new GProClientPresenceInfo(this.a.getClientPresence());
  }
  
  public ArrayList<IGProClientArchiveInfo> o()
  {
    return GProConvert.a(this.a.getClientArchives());
  }
  
  public ArrayList<IGProClientAccountInfo> p()
  {
    return GProConvert.b(this.a.getClientAccount());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProUserProfileInfo{info=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProUserProfileInfo
 * JD-Core Version:    0.7.0.1
 */