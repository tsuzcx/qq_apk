package com.tencent.mobileqq.troop.troopapps.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appId")
public class TroopAppInfo
  extends Entity
{
  public String AppTipIcon;
  public int AppTipIconTimeStamp;
  public int AppTipInfoSeq;
  public int AppTipReportIdClick;
  public int AppTipReportIdShow;
  public String AppTipToolTip;
  public String androidDownloadUrl;
  public String androidOpen;
  public int appFrom;
  public String appIcon;
  public int appIconUpdateTime;
  public long appId;
  public int appInnerType;
  public String appIntro;
  public int appIsNew;
  public String appName;
  public int appNewTime;
  public int appSortKey;
  public int appStatus;
  public int appType;
  public int appUpdateTime;
  public String appUrl;
  public int appWindowHeight;
  public int appWindowWidth;
  public int initFlag;
  public String openParam;
  public int settingFlag;
  public String tags;
  public String versionAndroid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo
 * JD-Core Version:    0.7.0.1
 */