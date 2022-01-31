package com.tencent.tavmovie;

import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TAVMovieBuilder
{
  private TAVMovie movie;
  private TAVTemplate template;
  
  public TAVMovieBuilder(TAVMovie paramTAVMovie)
  {
    this(paramTAVMovie, null);
  }
  
  public TAVMovieBuilder(TAVMovie paramTAVMovie, TAVTemplate paramTAVTemplate)
  {
    this.movie = paramTAVMovie;
    this.template = paramTAVTemplate;
  }
  
  public AudioMix buildAudioMix()
  {
    if (this.movie != null) {
      return buildSource().getAudioMix();
    }
    return null;
  }
  
  public TAVSource buildSource()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.movie != null)
    {
      localObject1 = localObject2;
      if (this.template != null) {
        localObject1 = this.template.buildCompositionFromMovie(this.movie);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.movie.convertToComposition();
      }
      localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2).buildSource();
    }
    return localObject1;
  }
  
  public VideoComposition buildVideoComposition()
  {
    if (this.movie != null) {
      return buildSource().getVideoComposition();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.TAVMovieBuilder
 * JD-Core Version:    0.7.0.1
 */