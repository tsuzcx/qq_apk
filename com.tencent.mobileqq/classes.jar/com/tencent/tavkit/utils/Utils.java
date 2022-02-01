package com.tencent.tavkit.utils;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;
import java.util.Iterator;
import java.util.List;

public class Utils
{
  private static boolean containsTime(@NonNull CMTime paramCMTime, CMTimeRange paramCMTimeRange)
  {
    if (paramCMTimeRange == null) {
      return false;
    }
    return paramCMTimeRange.containsTime(paramCMTime);
  }
  
  public static boolean containsTime(@NonNull CMTime paramCMTime, TAVAudioConfiguration.VolumeEdge paramVolumeEdge)
  {
    if (paramVolumeEdge == null) {
      return false;
    }
    return containsTime(paramCMTime, paramVolumeEdge.getTimeRange());
  }
  
  public static float getEdgeVolumeByTime(@NonNull CMTime paramCMTime, TAVAudioConfiguration.VolumeEdge paramVolumeEdge, float paramFloat)
  {
    return paramFloat * paramVolumeEdge.getVolume(paramCMTime.sub(paramVolumeEdge.getTimeRange().getStart()));
  }
  
  public static Float getEdgesVolume(@NonNull CMTime paramCMTime, List<TAVAudioConfiguration.VolumeEdge> paramList, float paramFloat)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVAudioConfiguration.VolumeEdge localVolumeEdge = (TAVAudioConfiguration.VolumeEdge)paramList.next();
      if (containsTime(paramCMTime, localVolumeEdge)) {
        return Float.valueOf(getEdgeVolumeByTime(paramCMTime, localVolumeEdge, paramFloat));
      }
    }
    return null;
  }
  
  public static boolean isRectValid(CGRect paramCGRect)
  {
    return (paramCGRect != null) && (isSizeValid(paramCGRect.size));
  }
  
  public static boolean isSizeValid(CGSize paramCGSize)
  {
    return (paramCGSize != null) && (paramCGSize.width != 0.0F) && (paramCGSize.height != 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.utils.Utils
 * JD-Core Version:    0.7.0.1
 */