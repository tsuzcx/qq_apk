package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QIMFollwerAdd
  extends Entity
{
  public long careSCount = 0L;
  public long fansCount = 0L;
  public int gender = -1;
  public boolean isRead = false;
  public String longNick = "";
  public int opType = 1;
  public String smartRemark = "";
  public String source = "";
  public long totalNum = 0L;
  @unique
  public long uin = 0L;
  public long upTime = 0L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QIMFollwerAdd
 * JD-Core Version:    0.7.0.1
 */