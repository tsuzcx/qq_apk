package com.tencent.tavkit.composition;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransition;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.HashMap;
import java.util.List;

public class TAVClip
  implements TAVTransitionableAudio, TAVTransitionableVideo, Cloneable
{
  private TAVAudioConfiguration audioConfiguration = new TAVAudioConfiguration();
  private HashMap<String, Object> extraTrackInfoMap = new HashMap();
  private TAVResource resource;
  private CMTime startTime = CMTime.CMTimeZero;
  @Nullable
  private TAVTransition transition;
  private TAVVideoConfiguration videoConfiguration = new TAVVideoConfiguration();
  
  public TAVClip() {}
  
  public TAVClip(Asset paramAsset)
  {
    this(new TAVAssetTrackResource(paramAsset));
  }
  
  public TAVClip(CMTime paramCMTime)
  {
    this(paramCMTime, false);
  }
  
  public TAVClip(CMTime paramCMTime, boolean paramBoolean)
  {
    this(new TAVEmptyResource(paramCMTime, paramBoolean));
  }
  
  public TAVClip(CIImage paramCIImage, CMTime paramCMTime)
  {
    this(new TAVImageResource(paramCIImage, paramCMTime));
  }
  
  public TAVClip(TAVResource paramTAVResource)
  {
    this();
    this.resource = paramTAVResource;
  }
  
  public CompositionTrack audioCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean)
  {
    TrackInfo localTrackInfo = this.resource.trackInfoForType(2, paramInt);
    MutableCompositionTrack localMutableCompositionTrack1 = null;
    if (localTrackInfo == null) {
      return null;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, localTrackInfo.getScaleToDuration());
    if (paramBoolean) {
      localMutableCompositionTrack1 = CompositionUtils.mutableTrackCompatibleWithTimeRange(paramMutableComposition, localCMTimeRange, 2);
    }
    MutableCompositionTrack localMutableCompositionTrack2 = localMutableCompositionTrack1;
    if (localMutableCompositionTrack1 == null)
    {
      localMutableCompositionTrack2 = localMutableCompositionTrack1;
      if (localTrackInfo.getMediaType() != 0) {
        localMutableCompositionTrack2 = paramMutableComposition.addMutableTrackWithMediaType(localTrackInfo.getMediaType(), 0);
      }
    }
    if (localMutableCompositionTrack2 != null) {
      CompositionUtils.insertTimeRangeToTrack(localTrackInfo, localMutableCompositionTrack2, localCMTimeRange);
    }
    return localMutableCompositionTrack2;
  }
  
  public TAVClip clone()
  {
    TAVClip localTAVClip = new TAVClip();
    localTAVClip.resource = this.resource.clone();
    localTAVClip.videoConfiguration = this.videoConfiguration.clone();
    localTAVClip.audioConfiguration = this.audioConfiguration.clone();
    TAVTransition localTAVTransition = this.transition;
    if (localTAVTransition != null) {
      localTAVClip.transition = localTAVTransition;
    }
    localTAVClip.extraTrackInfoMap = new HashMap(this.extraTrackInfoMap);
    return localTAVClip;
  }
  
  public void fitToSpeed(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    CMTime localCMTime = this.resource.getSourceTimeRange().getDuration();
    this.resource.setScaledDuration(localCMTime.multi(1.0F / paramFloat));
  }
  
  public TAVAudioConfiguration getAudioConfiguration()
  {
    return this.audioConfiguration;
  }
  
  public TAVAudioTransition getAudioTransition()
  {
    TAVTransition localTAVTransition = this.transition;
    if (localTAVTransition != null) {
      return localTAVTransition.getAudioTransition();
    }
    return null;
  }
  
  public CMTime getDuration()
  {
    return this.resource.getScaledDuration();
  }
  
  public Object getExtraTrackInfo(String paramString)
  {
    return this.extraTrackInfoMap.get(paramString);
  }
  
  public TAVResource getResource()
  {
    return this.resource;
  }
  
  public CMTime getStartTime()
  {
    return this.startTime;
  }
  
  public CMTimeRange getTargetTimeRange()
  {
    return new CMTimeRange(this.startTime, getDuration());
  }
  
  public CMTimeRange getTimeRange()
  {
    return getTargetTimeRange();
  }
  
  @Nullable
  public TAVTransition getTransition()
  {
    return this.transition;
  }
  
  public TAVVideoConfiguration getVideoConfiguration()
  {
    return this.videoConfiguration;
  }
  
  public TAVVideoTransition getVideoTransition()
  {
    TAVTransition localTAVTransition = this.transition;
    if (localTAVTransition != null) {
      return localTAVTransition.getVideoTransition();
    }
    return null;
  }
  
  public int numberOfAudioTracks()
  {
    return this.resource.tracksForType(2).size();
  }
  
  public int numberOfVideoTracks()
  {
    return this.resource.tracksForType(1).size();
  }
  
  public void putExtraTrackInfo(String paramString, Object paramObject)
  {
    this.extraTrackInfoMap.put(paramString, paramObject);
  }
  
  public void setAudioConfiguration(TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    this.audioConfiguration = paramTAVAudioConfiguration;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    this.resource.setScaledDuration(paramCMTime);
  }
  
  public void setResource(TAVResource paramTAVResource)
  {
    this.resource = paramTAVResource;
  }
  
  public void setStartTime(CMTime paramCMTime)
  {
    this.startTime = paramCMTime;
    paramCMTime = this.videoConfiguration;
    if (paramCMTime != null) {
      paramCMTime.updateTimeRange(getTimeRange());
    }
  }
  
  public void setTransition(@Nullable TAVTransition paramTAVTransition)
  {
    this.transition = paramTAVTransition;
  }
  
  public void setVideoConfiguration(TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    this.videoConfiguration = paramTAVVideoConfiguration;
  }
  
  public CIImage sourceImageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    return this.resource.imageAtTime(paramCMTime, paramCGSize);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVClip{resource=");
    localStringBuilder.append(this.resource);
    localStringBuilder.append(", videoConfiguration=");
    localStringBuilder.append(this.videoConfiguration);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", transition=");
    localStringBuilder.append(this.transition);
    localStringBuilder.append(", extraTrackInfoMap=");
    localStringBuilder.append(this.extraTrackInfoMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public CompositionTrack videoCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean)
  {
    TrackInfo localTrackInfo = this.resource.trackInfoForType(1, paramInt);
    MutableCompositionTrack localMutableCompositionTrack1 = null;
    if (localTrackInfo == null) {
      return null;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, localTrackInfo.getScaleToDuration());
    if (paramBoolean) {
      localMutableCompositionTrack1 = CompositionUtils.mutableTrackCompatibleWithTimeRange(paramMutableComposition, localCMTimeRange, 1);
    }
    MutableCompositionTrack localMutableCompositionTrack2 = localMutableCompositionTrack1;
    if (localMutableCompositionTrack1 == null)
    {
      localMutableCompositionTrack2 = localMutableCompositionTrack1;
      if (localTrackInfo.getMediaType() != 0) {
        localMutableCompositionTrack2 = paramMutableComposition.addMutableTrackWithMediaType(localTrackInfo.getMediaType(), -1);
      }
    }
    if (localMutableCompositionTrack2 != null) {
      CompositionUtils.insertTimeRangeToTrack(localTrackInfo, localMutableCompositionTrack2, localCMTimeRange);
    }
    return localMutableCompositionTrack2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVClip
 * JD-Core Version:    0.7.0.1
 */