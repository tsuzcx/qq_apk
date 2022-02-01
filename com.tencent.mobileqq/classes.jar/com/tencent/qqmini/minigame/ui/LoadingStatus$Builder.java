package com.tencent.qqmini.minigame.ui;

public class LoadingStatus$Builder
{
  private LoadingStatus mStatus = new LoadingStatus(null);
  
  public LoadingStatus build()
  {
    return this.mStatus;
  }
  
  public Builder setMessage(String paramString)
  {
    LoadingStatus.access$102(this.mStatus, paramString);
    return this;
  }
  
  public Builder setProgress(float paramFloat)
  {
    LoadingStatus.access$202(this.mStatus, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.LoadingStatus.Builder
 * JD-Core Version:    0.7.0.1
 */