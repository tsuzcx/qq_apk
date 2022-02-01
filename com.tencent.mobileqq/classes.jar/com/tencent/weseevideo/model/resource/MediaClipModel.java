package com.tencent.weseevideo.model.resource;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.model.BaseMediaModel;

public class MediaClipModel
  extends BaseMediaModel
{
  private AudioConfigurationModel audioConfigurationModel = new AudioConfigurationModel();
  private VideoResourceModel resource = new VideoResourceModel();
  private VideoConfigurationModel videoConfigurationModel = new VideoConfigurationModel();
  
  @NonNull
  public AudioConfigurationModel getAudioConfigurationModel()
  {
    return this.audioConfigurationModel;
  }
  
  @NonNull
  public VideoResourceModel getResource()
  {
    return this.resource;
  }
  
  @NonNull
  public VideoConfigurationModel getVideoConfigurationModel()
  {
    return this.videoConfigurationModel;
  }
  
  public void setAudioConfigurationModel(@NonNull AudioConfigurationModel paramAudioConfigurationModel)
  {
    this.audioConfigurationModel = paramAudioConfigurationModel;
  }
  
  public void setResource(@NonNull VideoResourceModel paramVideoResourceModel)
  {
    this.resource = paramVideoResourceModel;
  }
  
  public void setVideoConfigurationModel(@NonNull VideoConfigurationModel paramVideoConfigurationModel)
  {
    this.videoConfigurationModel = paramVideoConfigurationModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.MediaClipModel
 * JD-Core Version:    0.7.0.1
 */