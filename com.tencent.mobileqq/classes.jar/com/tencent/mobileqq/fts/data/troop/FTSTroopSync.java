package com.tencent.mobileqq.fts.data.troop;

import com.tencent.mobileqq.fts.v1.FTSOptSync;

public class FTSTroopSync
  extends FTSOptSync
{
  public static final int OPT_CHECK_TIME_STAMP = 5;
  public static final int OPT_GET_MEMBER_LIST = 1;
  public static final int OPT_KICK_OUT_MEMBER = 2;
  public static final int OPT_MODIFY_MEMBER_CARD = 3;
  public static final int OPT_QUIT_TROOP = 4;
  public long mMemberUin;
  public long mTroopUin;
  
  public FTSTroopSync() {}
  
  public FTSTroopSync(int paramInt, long paramLong)
  {
    this.mOpt = paramInt;
    this.mTroopUin = paramLong;
  }
  
  public FTSTroopSync(int paramInt, long paramLong1, long paramLong2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.troop.FTSTroopSync
 * JD-Core Version:    0.7.0.1
 */