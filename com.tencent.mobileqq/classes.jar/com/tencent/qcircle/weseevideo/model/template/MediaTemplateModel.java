package com.tencent.qcircle.weseevideo.model.template;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieMediaTemplateModel;

public class MediaTemplateModel
{
  private AutomaticMediaTemplateModel automaticMediaTemplateModel = new AutomaticMediaTemplateModel();
  private LightMediaTemplateModel lightMediaTemplateModel = new LightMediaTemplateModel();
  private MovieMediaTemplateModel movieMediaTemplateModel = new MovieMediaTemplateModel();
  private MediaResourceModel originMediaResourceModel = null;
  private String smartMatchTemplateTips;
  
  @NonNull
  public AutomaticMediaTemplateModel getAutomaticMediaTemplateModel()
  {
    return this.automaticMediaTemplateModel;
  }
  
  public LightMediaTemplateModel getLightMediaTemplateModel()
  {
    return this.lightMediaTemplateModel;
  }
  
  @NonNull
  public MovieMediaTemplateModel getMovieMediaTemplateModel()
  {
    return this.movieMediaTemplateModel;
  }
  
  public MediaResourceModel getOriginMediaResourceModel()
  {
    return this.originMediaResourceModel;
  }
  
  @Nullable
  public String getSmartMatchTemplateTips()
  {
    return this.smartMatchTemplateTips;
  }
  
  public boolean isAutoTemplateEmpty()
  {
    return this.automaticMediaTemplateModel.isEmpty();
  }
  
  public boolean isEmpty()
  {
    return (isAutoTemplateEmpty()) && (isMovieTemplateEmpty()) && (isLightTemplateEmpty());
  }
  
  public boolean isLightTemplateEmpty()
  {
    return this.lightMediaTemplateModel.isEmpty();
  }
  
  public boolean isMovieTemplateEmpty()
  {
    return this.movieMediaTemplateModel.isEmpty();
  }
  
  public void setAutomaticMediaTemplateModel(@NonNull AutomaticMediaTemplateModel paramAutomaticMediaTemplateModel)
  {
    this.automaticMediaTemplateModel = paramAutomaticMediaTemplateModel;
  }
  
  public void setLightMediaTemplateModel(LightMediaTemplateModel paramLightMediaTemplateModel)
  {
    this.lightMediaTemplateModel = paramLightMediaTemplateModel;
  }
  
  public void setMovieMediaTemplateModel(@NonNull MovieMediaTemplateModel paramMovieMediaTemplateModel)
  {
    this.movieMediaTemplateModel = paramMovieMediaTemplateModel;
  }
  
  public void setOriginMediaResourceModel(MediaResourceModel paramMediaResourceModel)
  {
    this.originMediaResourceModel = paramMediaResourceModel;
  }
  
  public void setSmartMatchTemplateTips(@Nullable String paramString)
  {
    this.smartMatchTemplateTips = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */