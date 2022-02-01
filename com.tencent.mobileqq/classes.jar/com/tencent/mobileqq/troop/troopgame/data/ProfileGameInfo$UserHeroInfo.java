package com.tencent.mobileqq.troop.troopgame.data;

import java.io.Serializable;

public class ProfileGameInfo$UserHeroInfo
  implements Serializable
{
  public String heroIcon;
  public long heroId = 0L;
  public int skilledLevel = 0;
  
  public ProfileGameInfo$UserHeroInfo(ProfileGameInfo paramProfileGameInfo, long paramLong, String paramString, int paramInt)
  {
    this.heroId = paramLong;
    this.heroIcon = paramString;
    this.skilledLevel = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo.UserHeroInfo
 * JD-Core Version:    0.7.0.1
 */