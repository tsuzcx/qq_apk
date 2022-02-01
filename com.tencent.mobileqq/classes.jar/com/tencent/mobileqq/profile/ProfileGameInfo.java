package com.tencent.mobileqq.profile;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileGameInfo
  implements Serializable
{
  public ArrayList<ProfileGameInfo.UserHeroInfo> bestHeroList = new ArrayList();
  public int bestOccupation;
  public long gamesTotal;
  public int mGrade;
  public long mvpTotal;
  public double seasonWinRate;
  
  public boolean isEmpty()
  {
    return (this.mGrade <= 0) && (this.seasonWinRate <= 0.0D) && (this.gamesTotal <= 0L) && (this.mvpTotal <= 0L) && (this.bestOccupation <= 0) && (this.bestHeroList.size() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileGameInfo
 * JD-Core Version:    0.7.0.1
 */