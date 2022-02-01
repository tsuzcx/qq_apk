package com.tencent.weseevideo.model.resource;

import android.support.annotation.NonNull;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.model.BaseMediaModel;

public class MediaClipModel
  extends BaseMediaModel
{
  private AudioConfigurationModel audioConfigurationModel = new AudioConfigurationModel();
  private CropConfig config = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  private VideoResourceModel resource = new VideoResourceModel();
  private VideoConfigurationModel videoConfigurationModel = new VideoConfigurationModel();
  
  protected MediaClipModel clone()
  {
    MediaClipModel localMediaClipModel = new MediaClipModel();
    localMediaClipModel.setResource(getResource().clone());
    localMediaClipModel.setVideoConfigurationModel(getVideoConfigurationModel().clone());
    localMediaClipModel.setConfig(getConfig().clone());
    return localMediaClipModel;
  }
  
  @NonNull
  public AudioConfigurationModel getAudioConfigurationModel()
  {
    return this.audioConfigurationModel;
  }
  
  public CropConfig getConfig()
  {
    return this.config;
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
  
  public void setConfig(CropConfig paramCropConfig)
  {
    this.config = paramCropConfig;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.MediaClipModel
 * JD-Core Version:    0.7.0.1
 */