package com.tencent.thumbplayer.core.player;

import androidx.annotation.NonNull;

public class TPNativePlayerSurfaceRenderInfo$TPVideoCropInfo
{
  public int cropBottom = -1;
  public int cropLeft = -1;
  public int cropRight = -1;
  public int cropTop = -1;
  public int height = -1;
  public int width = -1;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width:");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height:");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", cropLeft:");
    localStringBuilder.append(this.cropLeft);
    localStringBuilder.append(", cropRight:");
    localStringBuilder.append(this.cropRight);
    localStringBuilder.append(", cropTop:");
    localStringBuilder.append(this.cropTop);
    localStringBuilder.append(", cropBottom:");
    localStringBuilder.append(this.cropBottom);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo
 * JD-Core Version:    0.7.0.1
 */