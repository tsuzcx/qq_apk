package com.tencent.qqmini.minigame.ui;

import android.support.annotation.NonNull;

public class LoadingStatus
{
  private String message = "";
  private float progress = 0.0F;
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getProcessInPercentage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)(this.progress * 100.0F));
    localStringBuilder.append("%");
    return localStringBuilder.toString();
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public boolean isInProgress()
  {
    float f = this.progress;
    return (f > 0.0F) && (f < 1.0F);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LoadingStatus {progress=");
    localStringBuilder.append(this.progress);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.LoadingStatus
 * JD-Core Version:    0.7.0.1
 */