package com.tencent.trackrecordlib.models;

public class ViewRecord
{
  public int mRecentDecorViewHashcode;
  public long mRecentHookTime;
  public int mRecentTotalViewNum;
  
  public ViewRecord() {}
  
  public ViewRecord(int paramInt1, int paramInt2, long paramLong)
  {
    this.mRecentDecorViewHashcode = paramInt1;
    this.mRecentTotalViewNum = paramInt2;
    this.mRecentHookTime = paramLong;
  }
  
  public ViewRecord(ViewRecord paramViewRecord)
  {
    this.mRecentDecorViewHashcode = paramViewRecord.mRecentDecorViewHashcode;
    this.mRecentTotalViewNum = paramViewRecord.mRecentTotalViewNum;
    this.mRecentHookTime = paramViewRecord.mRecentHookTime;
  }
  
  public String toString()
  {
    return "ViewRecord{mRecentDecorViewHashcode=" + this.mRecentDecorViewHashcode + ", mRecentTotalViewNum=" + this.mRecentTotalViewNum + ", mRecentHookTime=" + this.mRecentHookTime + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.models.ViewRecord
 * JD-Core Version:    0.7.0.1
 */