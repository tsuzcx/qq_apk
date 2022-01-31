package com.tencent.weseevideo.model;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;

public class MediaModel
  extends BaseMediaModel
{
  private MediaEffectModel mediaEffectModel = new MediaEffectModel();
  private MediaResourceModel mediaResourceModel = new MediaResourceModel();
  
  @NonNull
  public MediaEffectModel getMediaEffectModel()
  {
    return this.mediaEffectModel;
  }
  
  @NonNull
  public MediaResourceModel getMediaResourceModel()
  {
    return this.mediaResourceModel;
  }
  
  public void setMediaEffectModel(MediaEffectModel paramMediaEffectModel)
  {
    this.mediaEffectModel = paramMediaEffectModel;
  }
  
  public void setMediaResourceModel(MediaResourceModel paramMediaResourceModel)
  {
    this.mediaResourceModel = paramMediaResourceModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.model.MediaModel
 * JD-Core Version:    0.7.0.1
 */