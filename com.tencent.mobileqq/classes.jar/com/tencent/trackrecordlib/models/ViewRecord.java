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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViewRecord{mRecentDecorViewHashcode=");
    localStringBuilder.append(this.mRecentDecorViewHashcode);
    localStringBuilder.append(", mRecentTotalViewNum=");
    localStringBuilder.append(this.mRecentTotalViewNum);
    localStringBuilder.append(", mRecentHookTime=");
    localStringBuilder.append(this.mRecentHookTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.models.ViewRecord
 * JD-Core Version:    0.7.0.1
 */