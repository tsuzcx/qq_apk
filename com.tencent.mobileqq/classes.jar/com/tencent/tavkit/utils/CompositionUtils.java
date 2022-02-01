package com.tencent.tavkit.utils;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVCompositionTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import java.util.Iterator;
import java.util.List;

public class CompositionUtils
{
  private static final String TAG = "CompositionUtils";
  
  private static void checkScaleTimeRange(MutableCompositionTrack paramMutableCompositionTrack, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if ((!CMTime.CMTimeInvalid.equalsTo(paramCMTimeRange1.getDuration())) && (!paramCMTimeRange2.getDuration().equalsTo(paramCMTimeRange1.getDuration()))) {
      paramMutableCompositionTrack.scaleTimeRange(new CMTimeRange(paramCMTimeRange1.getStart(), paramCMTimeRange2.getDuration()), paramCMTimeRange1.getDuration());
    }
  }
  
  @NonNull
  public static TAVEmptyResource createEmptyResource(CMTime paramCMTime)
  {
    TAVEmptyResource localTAVEmptyResource = new TAVEmptyResource(paramCMTime);
    localTAVEmptyResource.setDuration(paramCMTime);
    localTAVEmptyResource.setScaledDuration(paramCMTime);
    return localTAVEmptyResource;
  }
  
  public static void insertTimeRangeToTrack(TrackInfo paramTrackInfo, MutableCompositionTrack paramMutableCompositionTrack, CMTimeRange paramCMTimeRange)
  {
    try
    {
      CMTimeRange localCMTimeRange = paramTrackInfo.getSelectedTimeRange();
      if (paramTrackInfo.getTrack() != null)
      {
        paramMutableCompositionTrack.insertTimeRange(localCMTimeRange, paramTrackInfo.getTrack(), paramCMTimeRange.getStart());
        checkScaleTimeRange(paramMutableCompositionTrack, paramCMTimeRange, localCMTimeRange);
        return;
      }
      if (paramTrackInfo.getCompositionTrackSegment(paramCMTimeRange) != null)
      {
        paramMutableCompositionTrack.insertCompositionTrackSegment(paramTrackInfo.getCompositionTrackSegment(paramCMTimeRange));
        return;
      }
      Logger.e("CompositionUtils", "insertTimeRangeToTrack: TrackInfo track and segment are null !!!");
      return;
    }
    catch (Exception paramTrackInfo)
    {
      paramTrackInfo.printStackTrace();
    }
  }
  
  public static MutableCompositionTrack mutableTrackCompatibleWithTimeRange(MutableComposition paramMutableComposition, CMTimeRange paramCMTimeRange, int paramInt)
  {
    paramMutableComposition = paramMutableComposition.tracksWithMediaType(paramInt).iterator();
    while (paramMutableComposition.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)paramMutableComposition.next();
      CMTimeRange localCMTimeRange = TAVTimeUtil.getIntersection(localMutableCompositionTrack.getTimeRange(), paramCMTimeRange);
      if ((localCMTimeRange == null) || (localCMTimeRange.getDuration().getTimeSeconds() <= 0.0F)) {
        return localMutableCompositionTrack;
      }
    }
    return null;
  }
  
  public static void reloadAudioStartTimeWithTransitionableAudio(List<? extends TAVTransitionableAudio> paramList)
  {
    reloadStartTimeWithTransitionable(paramList, new CompositionUtils.2(paramList));
  }
  
  private static void reloadStartTimeWithTransitionable(List<? extends TAVCompositionTimeRange> paramList, CompositionUtils.TransitionTimeCalculator paramTransitionTimeCalculator)
  {
    CMTime localCMTime3 = CMTime.CMTimeZero;
    Object localObject = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramList.size())
    {
      TAVCompositionTimeRange localTAVCompositionTimeRange = (TAVCompositionTimeRange)paramList.get(i);
      CMTime localCMTime2 = CMTime.CMTimeZero;
      if (paramTransitionTimeCalculator != null) {
        localCMTime2 = paramTransitionTimeCalculator.transition(i);
      }
      CMTime localCMTime4 = localTAVCompositionTimeRange.getTimeRange().getDuration();
      CMTime localCMTime1;
      if (localCMTime4.smallThan(localCMTime2))
      {
        localCMTime1 = CMTime.CMTimeZero;
      }
      else if (i < paramList.size() - 1)
      {
        localCMTime1 = localCMTime2;
        if (((TAVCompositionTimeRange)paramList.get(i + 1)).getTimeRange().getDuration().smallThan(localCMTime2)) {
          localCMTime1 = CMTime.CMTimeZero;
        }
      }
      else
      {
        localCMTime1 = CMTime.CMTimeZero;
      }
      localCMTime2 = localCMTime3.sub((CMTime)localObject);
      localTAVCompositionTimeRange.setStartTime(localCMTime2);
      localCMTime3 = localCMTime2.add(localCMTime4);
      i += 1;
      localObject = localCMTime1;
    }
  }
  
  public static void reloadVideoStartTimeWithTransitionableVideo(List<? extends TAVTransitionableVideo> paramList)
  {
    reloadStartTimeWithTransitionable(paramList, new CompositionUtils.1(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.utils.CompositionUtils
 * JD-Core Version:    0.7.0.1
 */