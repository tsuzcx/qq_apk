package com.tencent.mobileqq.profile;

import java.io.Serializable;

public class ProfileGameInfo$UserHeroInfo
  implements Serializable
{
  public String heroIcon;
  public long heroId;
  public int skilledLevel;
  
  public ProfileGameInfo$UserHeroInfo(ProfileGameInfo paramProfileGameInfo, long paramLong, String paramString, int paramInt)
  {
    this.heroId = paramLong;
    this.heroIcon = paramString;
    this.skilledLevel = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileGameInfo.UserHeroInfo
 * JD-Core Version:    0.7.0.1
 */