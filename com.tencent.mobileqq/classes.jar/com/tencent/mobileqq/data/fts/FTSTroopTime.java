package com.tencent.mobileqq.data.fts;

import aukm;

public class FTSTroopTime
  extends aukm
{
  public long mTimeStamp;
  public String mTroopUin;
  public long mUin;
  
  public void prewrite()
  {
    super.prewrite();
    this.mUin = Long.parseLong(this.mTroopUin);
  }
  
  public String toString()
  {
    return "TroopUin=" + this.mTroopUin + " timeStamp=" + this.mTimeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.fts.FTSTroopTime
 * JD-Core Version:    0.7.0.1
 */