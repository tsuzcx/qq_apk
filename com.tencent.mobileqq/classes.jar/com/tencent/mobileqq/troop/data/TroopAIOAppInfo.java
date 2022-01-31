package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appid,groupType")
public class TroopAIOAppInfo
  extends Entity
{
  public int appid;
  public boolean canRemove;
  public int groupType;
  public String hashVal;
  public String iconUrl;
  public int identifyMask = 31;
  public boolean isCommon;
  public String minVersion;
  public String name;
  public boolean redPoint;
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
  
  public void copyFrom(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    if (paramTroopAIOAppInfo != null)
    {
      this.appid = paramTroopAIOAppInfo.appid;
      this.groupType = paramTroopAIOAppInfo.groupType;
      this.hashVal = paramTroopAIOAppInfo.hashVal;
      this.iconUrl = paramTroopAIOAppInfo.iconUrl;
      this.name = paramTroopAIOAppInfo.name;
      this.url = paramTroopAIOAppInfo.url;
      this.redPoint = paramTroopAIOAppInfo.redPoint;
      this.canRemove = paramTroopAIOAppInfo.canRemove;
      this.minVersion = paramTroopAIOAppInfo.minVersion;
      this.identifyMask = paramTroopAIOAppInfo.identifyMask;
    }
  }
  
  public boolean isValidTroopApp()
  {
    return (this.appid > 0) && (!TextUtils.isEmpty(this.hashVal)) && (!TextUtils.isEmpty(this.iconUrl)) && (!TextUtils.isEmpty(this.name));
  }
  
  public String toString()
  {
    return "TroopAppInfo{appid=" + this.appid + ", groupType='" + this.groupType + '\'' + ", hashVal='" + this.hashVal + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", redPoint=" + this.redPoint + ", canRemove=" + this.canRemove + ", minVersion='" + this.minVersion + '\'' + ", isCommon=" + this.isCommon + ", identifyMask=" + Integer.toBinaryString(this.identifyMask) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAIOAppInfo
 * JD-Core Version:    0.7.0.1
 */