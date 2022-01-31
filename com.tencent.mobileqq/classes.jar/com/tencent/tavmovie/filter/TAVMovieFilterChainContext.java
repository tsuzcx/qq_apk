package com.tencent.tavmovie.filter;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import java.util.ArrayList;
import java.util.List;

public class TAVMovieFilterChainContext
  implements TAVVideoEffect
{
  protected String reportKey = "TAVMovieFilterChainContext";
  private List<TAVVideoEffect> videoEffects = new ArrayList();
  
  public void addFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    this.videoEffects.add(paramTAVVideoEffect);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new TAVMovieFilterChainContext.MyCompositionEffect(this, this.videoEffects, null);
  }
  
  public String effectId()
  {
    return "TAVMovieFilterChainContext";
  }
  
  public List<TAVVideoEffect> getVideoEffects()
  {
    return this.videoEffects;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVMovieFilterChainContext
 * JD-Core Version:    0.7.0.1
 */