package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.text.TextUtils;

public class DecodeConfig
{
  public int adjustRotation = 0;
  public long endTimeMillSecond = 0L;
  public int height;
  public String inputFilePath;
  public boolean isLandscape;
  public boolean isLocal;
  public boolean noSleep = false;
  public long prolongToTime = -1L;
  public boolean repeat;
  public int rotation = 0;
  public int speedType = 0;
  public long startTimeMillSecond = 0L;
  public boolean syncDecode = false;
  public int width;
  
  public DecodeConfig()
  {
    this(null, 0, true, false);
  }
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, 0L, 0L);
  }
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.inputFilePath = paramString;
    this.speedType = paramInt;
    this.noSleep = paramBoolean2;
    this.repeat = paramBoolean1;
    this.startTimeMillSecond = paramLong1;
    this.endTimeMillSecond = paramLong2;
  }
  
  public void copyFrom(DecodeConfig paramDecodeConfig)
  {
    if (paramDecodeConfig != null)
    {
      this.inputFilePath = paramDecodeConfig.inputFilePath;
      this.speedType = paramDecodeConfig.speedType;
      this.noSleep = paramDecodeConfig.noSleep;
      this.repeat = paramDecodeConfig.repeat;
      this.startTimeMillSecond = paramDecodeConfig.startTimeMillSecond;
      this.endTimeMillSecond = paramDecodeConfig.endTimeMillSecond;
      this.prolongToTime = paramDecodeConfig.prolongToTime;
      this.syncDecode = paramDecodeConfig.syncDecode;
      return;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecodeConfig{inputFilePath='");
    localStringBuilder.append(this.inputFilePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", speedType=");
    localStringBuilder.append(this.speedType);
    localStringBuilder.append(", noSleep=");
    localStringBuilder.append(this.noSleep);
    localStringBuilder.append(", repeat=");
    localStringBuilder.append(this.repeat);
    localStringBuilder.append(", startTimeMillSecond=");
    localStringBuilder.append(this.startTimeMillSecond);
    localStringBuilder.append(", endTimeMillSecond=");
    localStringBuilder.append(this.endTimeMillSecond);
    localStringBuilder.append(", rotation=");
    localStringBuilder.append(this.rotation);
    localStringBuilder.append(", adjustRotation=");
    localStringBuilder.append(this.adjustRotation);
    localStringBuilder.append(", isLocal=");
    localStringBuilder.append(this.isLocal);
    localStringBuilder.append(",prolongToTime=");
    localStringBuilder.append(this.prolongToTime);
    localStringBuilder.append(",syncDecode=");
    localStringBuilder.append(this.syncDecode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String verify()
  {
    if (TextUtils.isEmpty(this.inputFilePath)) {
      return "inputFilePath is empty";
    }
    long l1 = this.startTimeMillSecond;
    if (l1 >= 0L)
    {
      long l2 = this.endTimeMillSecond;
      if (l2 >= 0L)
      {
        if (l2 < l1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("end time less than start time, end=");
          localStringBuilder.append(this.endTimeMillSecond);
          localStringBuilder.append(", start=");
          localStringBuilder.append(this.startTimeMillSecond);
          return localStringBuilder.toString();
        }
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time less than 0, start=");
    localStringBuilder.append(this.startTimeMillSecond);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.endTimeMillSecond);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */