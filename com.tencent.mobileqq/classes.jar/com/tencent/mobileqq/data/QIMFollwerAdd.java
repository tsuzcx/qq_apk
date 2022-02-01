package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QIMFollwerAdd
  extends Entity
{
  public long careSCount;
  public long fansCount;
  public int gender = -1;
  public boolean isRead;
  public String longNick = "";
  public int opType = 1;
  public String smartRemark = "";
  public String source = "";
  public long totalNum;
  @unique
  public long uin;
  public long upTime;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QIMFollwerAdd
 * JD-Core Version:    0.7.0.1
 */