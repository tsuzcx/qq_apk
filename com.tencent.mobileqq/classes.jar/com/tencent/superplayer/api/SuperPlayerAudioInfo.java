package com.tencent.superplayer.api;

public class SuperPlayerAudioInfo
  implements Cloneable
{
  private long mAudioChannelLayout = -1L;
  private int mAudioSampleFrameSizeByte = -1;
  private int mAudioSampleRateHZ = -1;
  private int mAuidoOutPutFormat = -1;
  
  public Object clone()
  {
    return super.clone();
  }
  
  public long getAudioChannelLayout()
  {
    return this.mAudioChannelLayout;
  }
  
  public int getAudioSampleFrameSize()
  {
    return this.mAudioSampleFrameSizeByte;
  }
  
  public int getAudioSampleRateHZ()
  {
    return this.mAudioSampleRateHZ;
  }
  
  public int getAuidoOutPutFormat()
  {
    return this.mAuidoOutPutFormat;
  }
  
  public void setAudioChannelLayout(long paramLong)
  {
    this.mAudioChannelLayout = paramLong;
  }
  
  public void setAudioSampleFrameSize(int paramInt)
  {
    this.mAudioSampleFrameSizeByte = paramInt;
  }
  
  public void setAudioSampleRateHZ(int paramInt)
  {
    this.mAudioSampleRateHZ = paramInt;
  }
  
  public void setAuidoOutPutFormat(int paramInt)
  {
    this.mAuidoOutPutFormat = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayerAudioInfo[ mAudioSampleRateHZ:");
    localStringBuilder.append(this.mAudioSampleRateHZ);
    localStringBuilder.append("\n");
    localStringBuilder.append("mAudioChannelLayout:");
    localStringBuilder.append(this.mAudioChannelLayout);
    localStringBuilder.append("\n");
    localStringBuilder.append("mAuidoOutPutFormat:");
    localStringBuilder.append(this.mAuidoOutPutFormat);
    localStringBuilder.append("\n");
    localStringBuilder.append("mAudioSampleFrameSizeByte:");
    localStringBuilder.append(this.mAudioSampleFrameSizeByte);
    localStringBuilder.append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerAudioInfo
 * JD-Core Version:    0.7.0.1
 */