package com.tencent.thumbplayer.api.composition;

import com.tencent.thumbplayer.composition.TPEmptyTrackClip;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrack;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.composition.TPMediaDRMAsset;
import java.util.Iterator;
import java.util.List;

public class TPMediaCompositionFactory
{
  public static ITPMediaTrackClip createEmptyTrackClip(int paramInt, long paramLong1, long paramLong2)
  {
    TPEmptyTrackClip localTPEmptyTrackClip = new TPEmptyTrackClip(paramInt);
    localTPEmptyTrackClip.setCutTimeRange(paramLong1, paramLong2);
    return localTPEmptyTrackClip;
  }
  
  public static ITPMediaComposition createMediaComposition()
  {
    return new TPMediaComposition();
  }
  
  public static ITPMediaDRMAsset createMediaDRMAsset(int paramInt, String paramString)
  {
    return new TPMediaDRMAsset(paramInt, paramString);
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt)
  {
    return new TPMediaCompositionTrack(paramInt);
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt, List<ITPMediaTrackClip> paramList)
  {
    TPMediaCompositionTrack localTPMediaCompositionTrack = new TPMediaCompositionTrack(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localTPMediaCompositionTrack.addTrackClip((ITPMediaTrackClip)paramList.next());
    }
    return localTPMediaCompositionTrack;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt, ITPMediaTrackClip... paramVarArgs)
  {
    TPMediaCompositionTrack localTPMediaCompositionTrack = new TPMediaCompositionTrack(paramInt);
    int i = paramVarArgs.length;
    paramInt = 0;
    while (paramInt < i)
    {
      localTPMediaCompositionTrack.addTrackClip(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    return localTPMediaCompositionTrack;
  }
  
  public static ITPMediaTrackClip createMediaTrackClip(String paramString, int paramInt)
  {
    return new TPMediaCompositionTrackClip(paramString, paramInt);
  }
  
  public static ITPMediaTrackClip createMediaTrackClip(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return new TPMediaCompositionTrackClip(paramString, paramInt, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory
 * JD-Core Version:    0.7.0.1
 */