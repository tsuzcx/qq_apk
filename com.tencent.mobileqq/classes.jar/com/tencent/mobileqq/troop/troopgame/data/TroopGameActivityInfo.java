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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityValue = ");
    localStringBuilder.append(this.activityValue);
    localStringBuilder.append(", rankNum = ");
    localStringBuilder.append(this.rankNum);
    localStringBuilder.append(", rankText = ");
    localStringBuilder.append(this.rankText);
    localStringBuilder.append(", rankEntrance = ");
    localStringBuilder.append(this.rankEntrance);
    localStringBuilder.append(", iconUrl = ");
    localStringBuilder.append(this.iconUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo
 * JD-Core Version:    0.7.0.1
 */