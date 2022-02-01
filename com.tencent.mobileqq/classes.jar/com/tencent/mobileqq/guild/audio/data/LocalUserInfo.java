package com.tencent.mobileqq.guild.audio.data;

public class LocalUserInfo
  extends UserInfo
{
  public String a = "";
  public String b = "";
  public volatile boolean c = false;
  public int d = -1;
  public int e = 0;
  
  public LocalUserInfo a()
  {
    LocalUserInfo localLocalUserInfo = new LocalUserInfo();
    localLocalUserInfo.a(this);
    return localLocalUserInfo;
  }
  
  public void a(UserInfo paramUserInfo)
  {
    super.a(paramUserInfo);
    if ((paramUserInfo instanceof LocalUserInfo))
    {
      paramUserInfo = (LocalUserInfo)paramUserInfo;
      this.a = paramUserInfo.a;
      this.b = paramUserInfo.b;
      this.c = paramUserInfo.c;
      this.d = paramUserInfo.d;
      this.e = paramUserInfo.e;
    }
  }
  
  public void b()
  {
    super.b();
    this.a = "";
    this.b = "";
    this.c = false;
    this.d = -1;
    this.e = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalUserInfo{id='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userType=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", Role=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", isMicOn=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", volume=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", muteToMe=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", globalMute=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", guildId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isInRoom=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", audioRoute=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", memberNumMax=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.LocalUserInfo
 * JD-Core Version:    0.7.0.1
 */