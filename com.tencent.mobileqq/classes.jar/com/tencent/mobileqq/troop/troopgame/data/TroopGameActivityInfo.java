package com.tencent.mobileqq.troop.troopgame.data;

import android.support.annotation.NonNull;
import java.io.Serializable;

public class TroopGameActivityInfo
  implements Serializable
{
  public static final String TAG = "TroopGameActivityInfo";
  public long activityValue = 0L;
  public String iconUrl;
  public String rankEntrance;
  public long rankNum = 0L;
  public String rankText;
  
  @NonNull
  public String toString()
  {
    return "activityValue = " + this.activityValue + ", rankNum = " + this.rankNum + ", rankText = " + this.rankText + ", rankEntrance = " + this.rankEntrance + ", iconUrl = " + this.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo
 * JD-Core Version:    0.7.0.1
 */