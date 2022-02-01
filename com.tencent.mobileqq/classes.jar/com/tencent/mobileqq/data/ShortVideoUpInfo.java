package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ShortVideoUpInfo
  extends Entity
{
  @unique
  public String key;
  public long lastIp;
  public long timeStamp;
  public long transferedSize;
  public String uKey;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShortVideoUpInfo
 * JD-Core Version:    0.7.0.1
 */