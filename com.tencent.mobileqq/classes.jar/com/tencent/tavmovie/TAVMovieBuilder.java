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
    Object localObject = this.movie;
    TAVComposition localTAVComposition = null;
    if (localObject != null)
    {
      TAVTemplate localTAVTemplate = this.template;
      if (localTAVTemplate != null) {
        localTAVComposition = localTAVTemplate.buildCompositionFromMovie((TAVMovie)localObject);
      }
      localObject = localTAVComposition;
      if (localTAVComposition == null) {
        localObject = this.movie.convertToComposition();
      }
      return new TAVCompositionBuilder((TAVComposition)localObject).buildSource();
    }
    return null;
  }
  
  public VideoComposition buildVideoComposition()
  {
    if (this.movie != null) {
      return buildSource().getVideoComposition();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.TAVMovieBuilder
 * JD-Core Version:    0.7.0.1
 */