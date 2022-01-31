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
    if (paramDecodeConfig == null) {
      throw new NullPointerException();
    }
    this.inputFilePath = paramDecodeConfig.inputFilePath;
    this.speedType = paramDecodeConfig.speedType;
    this.noSleep = paramDecodeConfig.noSleep;
    this.repeat = paramDecodeConfig.repeat;
    this.startTimeMillSecond = paramDecodeConfig.startTimeMillSecond;
    this.endTimeMillSecond = paramDecodeConfig.endTimeMillSecond;
    this.prolongToTime = paramDecodeConfig.prolongToTime;
    this.syncDecode = paramDecodeConfig.syncDecode;
  }
  
  public String toString()
  {
    return "DecodeConfig{inputFilePath='" + this.inputFilePath + '\'' + ", speedType=" + this.speedType + ", noSleep=" + this.noSleep + ", repeat=" + this.repeat + ", startTimeMillSecond=" + this.startTimeMillSecond + ", endTimeMillSecond=" + this.endTimeMillSecond + ", rotation=" + this.rotation + ", adjustRotation=" + this.adjustRotation + ", isLocal=" + this.isLocal + ",prolongToTime=" + this.prolongToTime + ",syncDecode=" + this.syncDecode + '}';
  }
  
  public String verify()
  {
    if (TextUtils.isEmpty(this.inputFilePath)) {
      return "inputFilePath is empty";
    }
    if ((this.startTimeMillSecond < 0L) || (this.endTimeMillSecond < 0L)) {
      return "time less than 0, start=" + this.startTimeMillSecond + ", end=" + this.endTimeMillSecond;
    }
    if (this.endTimeMillSecond < this.startTimeMillSecond) {
      return "end time less than start time, end=" + this.endTimeMillSecond + ", start=" + this.startTimeMillSecond;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */