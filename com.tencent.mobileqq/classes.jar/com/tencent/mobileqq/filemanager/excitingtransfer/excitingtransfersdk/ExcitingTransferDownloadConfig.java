package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferDownloadConfig
{
  public long mSliceSize = 524288L;
  public int uMaxParrallelSlice = 3;
  public int uMaxWaitingSlice = 30;
  public int uNotifyIntervals = 1000;
  public int uSliceNum = 10;
  public int uSpeedDuration = 2000;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSliceSize:");
    localStringBuilder.append(this.mSliceSize);
    localStringBuilder.append(" uMaxParrallelSlice:");
    localStringBuilder.append(this.uMaxParrallelSlice);
    localStringBuilder.append(" uMaxWaitingSlice:");
    localStringBuilder.append(this.uMaxWaitingSlice);
    localStringBuilder.append(" uNotifyIntervals:");
    localStringBuilder.append(this.uNotifyIntervals);
    localStringBuilder.append(" uSpeedDuration:");
    localStringBuilder.append(this.uSpeedDuration);
    localStringBuilder.append(" uSliceNum:");
    localStringBuilder.append(this.uSliceNum);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig
 * JD-Core Version:    0.7.0.1
 */