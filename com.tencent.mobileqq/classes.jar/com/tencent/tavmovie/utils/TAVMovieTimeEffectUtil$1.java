package com.tencent.tavmovie.utils;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.Comparator;

final class TAVMovieTimeEffectUtil$1
  implements Comparator<TAVMovieTimeEffect>
{
  public int compare(TAVMovieTimeEffect paramTAVMovieTimeEffect1, TAVMovieTimeEffect paramTAVMovieTimeEffect2)
  {
    long l1 = paramTAVMovieTimeEffect1.getTimeRange().getStartUs();
    long l2 = paramTAVMovieTimeEffect2.getTimeRange().getStartUs();
    if (l1 == l2) {
      return 0;
    }
    if (l1 <= l2) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil.1
 * JD-Core Version:    0.7.0.1
 */