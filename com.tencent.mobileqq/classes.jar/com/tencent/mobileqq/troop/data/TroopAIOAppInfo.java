package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import aukm;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appid,groupType")
public class TroopAIOAppInfo
  extends aukm
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
  public int identifyMask = 31;
  public boolean isCommon;
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
    return "TroopAppInfo{appid=" + this.appid + ", redDotID=" + this.redDotID + ", groupType='" + this.groupType + '\'' + ", hashVal='" + this.hashVal + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", redPoint=" + this.redPoint + ", canRemove=" + this.canRemove + ", minVersion='" + this.minVersion + '\'' + ", isGray=" + this.isGray + ", isCommon=" + this.isCommon + ", identifyMask=" + Integer.toBinaryString(this.identifyMask) + ", simpleDayUrl=" + this.simpleDayUrl + ", simpleDayPressUrl=" + this.simpleDayPressUrl + ", simpleNightUrl=" + this.simpleNightUrl + ", simpleNightPressUrl=" + this.simpleNightPressUrl + ", sort=" + this.sort + ", action=" + this.action + ", actionType=" + this.actionType + ", iconPress=" + this.iconPress + ", enable=" + this.enableC2C + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAIOAppInfo
 * JD-Core Version:    0.7.0.1
 */