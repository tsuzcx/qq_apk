package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ReportedBanner
  extends Entity
{
  @unique
  public long cid;
  public long endtime;
  public String md5;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ReportedBanner
 * JD-Core Version:    0.7.0.1
 */