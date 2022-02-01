package com.tencent.mobileqq.troop.troopgame.data;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileGameInfo
  implements Serializable
{
  public String area;
  public ArrayList<ProfileGameInfo.UserHeroInfo> bestHeroList = new ArrayList();
  public int bestOccupation = 0;
  public String encrptOpenId;
  public long gamesTotal = 0L;
  public int mGrade = 0;
  public long mvpTotal = 0L;
  public String partition;
  public String platid;
  public double seasonWinRate = 0.0D;
  
  public boolean isEmpty()
  {
    return (this.mGrade <= 0) && (this.seasonWinRate <= 0.0D) && (this.gamesTotal <= 0L) && (this.mvpTotal <= 0L) && (this.bestOccupation <= 0) && (this.bestHeroList.size() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo
 * JD-Core Version:    0.7.0.1
 */