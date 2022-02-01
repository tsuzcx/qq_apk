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
    return (int)(this.progress * 100.0F) + "%";
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public boolean isInProgress()
  {
    return (this.progress > 0.0F) && (this.progress < 1.0F);
  }
  
  @NonNull
  public String toString()
  {
    return "LoadingStatus {progress=" + this.progress + "} ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.LoadingStatus
 * JD-Core Version:    0.7.0.1
 */