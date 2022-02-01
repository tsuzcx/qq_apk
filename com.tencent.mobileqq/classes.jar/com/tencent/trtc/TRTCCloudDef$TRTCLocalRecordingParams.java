package com.tencent.trtc;

public class TRTCCloudDef$TRTCLocalRecordingParams
{
  public String filePath = "";
  public int interval = -1;
  public int recordType = 2;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filePath=");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append(", recordType=");
    localStringBuilder.append(this.recordType);
    localStringBuilder.append(", interval=");
    localStringBuilder.append(this.interval);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCLocalRecordingParams
 * JD-Core Version:    0.7.0.1
 */