package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProGuildUserSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

public class GProUserSimpleProfile
  implements IGProUserSimpleProfile
{
  private GProGuildUserSimpleProfile a;
  
  public GProUserSimpleProfile(GProGuildUserSimpleProfile paramGProGuildUserSimpleProfile)
  {
    this.a = paramGProGuildUserSimpleProfile;
  }
  
  public GProUserSimpleProfile(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    this.a = new GProGuildUserSimpleProfile(GProConvert.a(paramString), paramGuildUserAvatar.c(), paramGuildUserAvatar.b(), paramGuildUserAvatar.d(), null, 0, null);
  }
  
  public GProUserSimpleProfile(String paramString1, String paramString2)
  {
    this.a = new GProGuildUserSimpleProfile(GProConvert.a(paramString1), null, 0, 0L, paramString2, 0, null);
  }
  
  public String a()
  {
    return this.a.getAvatarUrl();
  }
  
  public void a(GProGuildUserSimpleProfile paramGProGuildUserSimpleProfile)
  {
    this.a = paramGProGuildUserSimpleProfile;
  }
  
  public boolean a(GuildUserAvatar paramGuildUserAvatar)
  {
    boolean bool;
    if (paramGuildUserAvatar.d() != c())
    {
      this.a.setAvatarTimeStamp(paramGuildUserAvatar.d());
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (paramGuildUserAvatar.b() != b())
    {
      this.a.setAvatarSizeFlag(paramGuildUserAvatar.b());
      bool = true;
    }
    if (!paramGuildUserAvatar.c().equals(a()))
    {
      this.a.setAvatarUrl(paramGuildUserAvatar.c());
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if (!paramString.equals(d()))
    {
      this.a.setNick(paramString);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.a.getAvatarSizeFlag();
  }
  
  public long c()
  {
    return this.a.getAvatarTimeStamp();
  }
  
  public String d()
  {
    return this.a.getNick();
  }
  
  public GuildUserAvatar e()
  {
    return new GuildUserAvatar(GProConvert.a(this.a.getTinyId()), this.a.getAvatarUrl(), this.a.getAvatarSizeFlag(), this.a.getAvatarTimeStamp());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProUserSimpleProfile
 * JD-Core Version:    0.7.0.1
 */