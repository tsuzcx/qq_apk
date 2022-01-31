package com.tencent.tav.player;

import com.tencent.tav.asset.AssetTrack;

public class PlayerItemTrack
{
  private AssetTrack assetTrack;
  private float currentVideoFrameRate;
  private boolean enabled = true;
  private String videoFieldMode;
  
  public AssetTrack getAssetTrack()
  {
    return this.assetTrack;
  }
  
  public float getCurrentVideoFrameRate()
  {
    return this.currentVideoFrameRate;
  }
  
  public String getVideoFieldMode()
  {
    return this.videoFieldMode;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  void setAssetTrack(AssetTrack paramAssetTrack)
  {
    this.assetTrack = paramAssetTrack;
  }
  
  void setCurrentVideoFrameRate(float paramFloat)
  {
    this.currentVideoFrameRate = paramFloat;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void setVideoFieldMode(String paramString)
  {
    this.videoFieldMode = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.player.PlayerItemTrack
 * JD-Core Version:    0.7.0.1
 */