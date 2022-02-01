package com.tencent.tavmovie;

import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import java.util.List;

public abstract interface TAVTemplate
{
  public abstract TAVComposition buildCompositionFromMovie(TAVMovie paramTAVMovie);
  
  public abstract List<TAVMovieSegment> convertClips(List<TAVMovieClip> paramList);
  
  public abstract List<TAVMovieClip> getMovieClips();
  
  public abstract void parseToMovie(TAVMovie paramTAVMovie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.TAVTemplate
 * JD-Core Version:    0.7.0.1
 */