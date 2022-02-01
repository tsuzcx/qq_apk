package com.tencent.mobileqq.data.fts;

import com.tencent.mobileqq.persistence.fts.FTSOptSync;

public class FTSNewTroopSync
  extends FTSOptSync
{
  public long mMemberUin;
  public long mTroopUin;
  
  public FTSNewTroopSync() {}
  
  public FTSNewTroopSync(int paramInt, long paramLong)
  {
    this.mOpt = paramInt;
    this.mTroopUin = paramLong;
  }
  
  public FTSNewTroopSync(int paramInt, long paramLong1, long paramLong2)
  {
    this.mOpt = paramInt;
    this.mTroopUin = paramLong1;
    this.mMemberUin = paramLong2;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("mOpt=");
    localStringBuffer.append(this.mOpt);
    localStringBuffer.append(" mTroopUin=");
    localStringBuffer.append(this.mTroopUin);
    localStringBuffer.append(" mMemberUin=");
    localStringBuffer.append(this.mMemberUin);
    return localStringBuffer.toString();
  }
  
  public FTSTroopSync transTroopSync()
  {
    return new FTSTroopSync(this.mOpt, this.mTroopUin, this.mMemberUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.fts.FTSNewTroopSync
 * JD-Core Version:    0.7.0.1
 */