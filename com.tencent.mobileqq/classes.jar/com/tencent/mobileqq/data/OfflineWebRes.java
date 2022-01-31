package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class OfflineWebRes
  extends Entity
{
  public String bid;
  public String fileName;
  public String hashName;
  public int hitCount = 1;
  @unique
  public String md5;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.OfflineWebRes
 * JD-Core Version:    0.7.0.1
 */