package com.tencent.tmediacodec.reuse;

import android.support.annotation.NonNull;

public final class ReusePolicy
{
  public static final ReusePolicy DEFAULT = new ReusePolicy(1920, 1920);
  public static final int DEFAULT_INIT_HEIGHT = 1920;
  public static final int DEFAULT_INIT_WIDTH = 1920;
  public ReusePolicy.EraseType eraseType;
  public int initHeight;
  public int initWidth;
  public boolean reConfigByRealFormat;
  
  public ReusePolicy(int paramInt1, int paramInt2)
  {
    this.initWidth = paramInt1;
    this.initHeight = paramInt2;
    this.reConfigByRealFormat = true;
    this.eraseType = ReusePolicy.EraseType.First;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initWidth:");
    localStringBuilder.append(this.initWidth);
    localStringBuilder.append(", initHeight:");
    localStringBuilder.append(this.initHeight);
    localStringBuilder.append(", reConfigByRealFormat:");
    localStringBuilder.append(this.reConfigByRealFormat);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.reuse.ReusePolicy
 * JD-Core Version:    0.7.0.1
 */