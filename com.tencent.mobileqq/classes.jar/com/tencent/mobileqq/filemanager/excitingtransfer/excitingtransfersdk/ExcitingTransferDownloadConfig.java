package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferDownloadConfig
{
  public long mSliceSize = 524288L;
  public int uMaxParrallelSlice = 3;
  public int uMaxWaitingSlice = 30;
  public int uNotifyIntervals = 1000;
  public int uSliceNum = 10;
  public int uSpeedDuration = 2000;
  
  @NonNull
  public String toString()
  {
    return "mSliceSize:" + this.mSliceSize + " uMaxParrallelSlice:" + this.uMaxParrallelSlice + " uMaxWaitingSlice:" + this.uMaxWaitingSlice + " uNotifyIntervals:" + this.uNotifyIntervals + " uSpeedDuration:" + this.uSpeedDuration + " uSliceNum:" + this.uSliceNum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig
 * JD-Core Version:    0.7.0.1
 */