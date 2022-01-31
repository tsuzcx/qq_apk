package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ActivityDAUInfo
  extends Entity
{
  @unique
  public String activityName;
  public int count;
  public int displayCount;
  public String domain;
  public String pageName;
  public String preActivityList;
  public String reportVersion;
  public long showTime;
  public String webTitle;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ActivityDAUInfo
 * JD-Core Version:    0.7.0.1
 */