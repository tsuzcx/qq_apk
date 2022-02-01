package com.tencent.mobileqq.troop.troopgame.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TroopGameInfo
  implements Serializable
{
  public static final String TAG = "TroopGameInfo";
  public long fightScore;
  public double fightScoreRank;
  public List<GradeDistributedInfo> gradeDistributedList = new ArrayList();
  public int mGrade;
  public long mGradeId;
  public long mHeroId;
  public int mHonor;
  public double mWinRate;
  public long weekGPlayGameCount;
  public long weekPlayUserCount;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo
 * JD-Core Version:    0.7.0.1
 */