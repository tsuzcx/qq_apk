package com.tencent.weseevideo.composition.builder;

import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.weseevideo.model.template.light.LightTemplate;
import com.tencent.weseevideo.model.template.movie.MovieTemplate;

public class MediaBuilderOutput
{
  private TAVAutomaticTemplate automaticTemplate;
  private LightTemplate lightTemplate;
  private MovieTemplate movieTemplate;
  
  public TAVAutomaticTemplate getAutomaticTemplate()
  {
    return this.automaticTemplate;
  }
  
  public LightTemplate getLightTemplate()
  {
    return this.lightTemplate;
  }
  
  public MovieTemplate getMovieTemplate()
  {
    return this.movieTemplate;
  }
  
  public void setAutomaticTemplate(TAVAutomaticTemplate paramTAVAutomaticTemplate)
  {
    this.automaticTemplate = paramTAVAutomaticTemplate;
  }
  
  public void setLightTemplate(LightTemplate paramLightTemplate)
  {
    this.lightTemplate = paramLightTemplate;
  }
  
  public void setMovieTemplate(MovieTemplate paramMovieTemplate)
  {
    this.movieTemplate = paramMovieTemplate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.builder.MediaBuilderOutput
 * JD-Core Version:    0.7.0.1
 */