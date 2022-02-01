package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appid,groupType")
public class TroopAIOAppInfo
  extends Entity
  implements Serializable, Comparable<TroopAIOAppInfo>
{
  static final long serialVersionUID = 1L;
  public String action;
  public String actionType;
  public int appid;
  public boolean canRemove;
  public String enName;
  public int enableC2C;
  public int enableGroup;
  public int groupType;
  public String hashVal;
  public String iconPress;
  public String iconUrl;
  public String iconYouth;
  public int identifyMask = 31;
  public boolean isCommon = false;
  public boolean isGray;
  public String minVersion;
  public String name;
  public String redDotID;
  public boolean redPoint;
  public String simpleDayPressUrl;
  public String simpleDayUrl;
  public String simpleNightPressUrl;
  public String simpleNightUrl;
  public int sort;
  public String url;
  
  public TroopAIOAppInfo() {}
  
  public TroopAIOAppInfo(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    copyFrom(paramTroopAIOAppInfo);
  }
  
  public static boolean checkVersion(String paramString)
  {
    return (paramString != null) && (paramString.matches("\\d+(\\.\\d+)*"));
  }
  
  public int compareTo(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    if (paramTroopAIOAppInfo != null) {
      return this.sort - paramTroopAIOAppInfo.sort;
    }
    return 0;
  }
  
  public void copyFrom(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    if (paramTroopAIOAppInfo != null)
    {
      this.appid = paramTroopAIOAppInfo.appid;
      this.redDotID = paramTroopAIOAppInfo.redDotID;
      this.groupType = paramTroopAIOAppInfo.groupType;
      this.hashVal = paramTroopAIOAppInfo.hashVal;
      this.iconUrl = paramTroopAIOAppInfo.iconUrl;
      this.name = paramTroopAIOAppInfo.name;
      this.url = paramTroopAIOAppInfo.url;
      this.redPoint = paramTroopAIOAppInfo.redPoint;
      this.canRemove = paramTroopAIOAppInfo.canRemove;
      this.minVersion = paramTroopAIOAppInfo.minVersion;
      this.identifyMask = paramTroopAIOAppInfo.identifyMask;
      this.isGray = paramTroopAIOAppInfo.isGray;
      this.simpleNightUrl = paramTroopAIOAppInfo.simpleNightUrl;
      this.simpleNightPressUrl = paramTroopAIOAppInfo.simpleNightPressUrl;
      this.simpleDayUrl = paramTroopAIOAppInfo.simpleDayUrl;
      this.simpleDayPressUrl = paramTroopAIOAppInfo.simpleDayPressUrl;
      this.sort = paramTroopAIOAppInfo.sort;
      this.action = paramTroopAIOAppInfo.action;
      this.actionType = paramTroopAIOAppInfo.actionType;
      this.iconPress = paramTroopAIOAppInfo.iconPress;
      this.enableC2C = paramTroopAIOAppInfo.enableC2C;
    }
  }
  
  public boolean isValidTroopApp()
  {
    return (this.appid > 0) && (!TextUtils.isEmpty(this.hashVal)) && (!TextUtils.isEmpty(this.iconUrl)) && (!TextUtils.isEmpty(this.name));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopAppInfo{appid=");
    localStringBuilder.append(this.appid);
    localStringBuilder.append(", redDotID=");
    localStringBuilder.append(this.redDotID);
    localStringBuilder.append(", groupType='");
    localStringBuilder.append(this.groupType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hashVal='");
    localStringBuilder.append(this.hashVal);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", redPoint=");
    localStringBuilder.append(this.redPoint);
    localStringBuilder.append(", canRemove=");
    localStringBuilder.append(this.canRemove);
    localStringBuilder.append(", minVersion='");
    localStringBuilder.append(this.minVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isGray=");
    localStringBuilder.append(this.isGray);
    localStringBuilder.append(", isCommon=");
    localStringBuilder.append(this.isCommon);
    localStringBuilder.append(", identifyMask=");
    localStringBuilder.append(Integer.toBinaryString(this.identifyMask));
    localStringBuilder.append(", simpleDayUrl=");
    localStringBuilder.append(this.simpleDayUrl);
    localStringBuilder.append(", simpleDayPressUrl=");
    localStringBuilder.append(this.simpleDayPressUrl);
    localStringBuilder.append(", simpleNightUrl=");
    localStringBuilder.append(this.simpleNightUrl);
    localStringBuilder.append(", simpleNightPressUrl=");
    localStringBuilder.append(this.simpleNightPressUrl);
    localStringBuilder.append(", sort=");
    localStringBuilder.append(this.sort);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.action);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.actionType);
    localStringBuilder.append(", iconPress=");
    localStringBuilder.append(this.iconPress);
    localStringBuilder.append(", enable=");
    localStringBuilder.append(this.enableC2C);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAIOAppInfo
 * JD-Core Version:    0.7.0.1
 */