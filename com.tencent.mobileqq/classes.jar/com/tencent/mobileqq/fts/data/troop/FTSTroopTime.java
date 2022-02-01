package com.tencent.mobileqq.fts.data.troop;

import com.tencent.mobileqq.persistence.Entity;

public class FTSTroopTime
  extends Entity
{
  public long mTimeStamp;
  public String mTroopUin;
  public long mUin;
  
  protected void prewrite()
  {
    super.prewrite();
    this.mUin = Long.parseLong(this.mTroopUin);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopUin=");
    localStringBuilder.append(this.mTroopUin);
    localStringBuilder.append(" timeStamp=");
    localStringBuilder.append(this.mTimeStamp);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.troop.FTSTroopTime
 * JD-Core Version:    0.7.0.1
 */