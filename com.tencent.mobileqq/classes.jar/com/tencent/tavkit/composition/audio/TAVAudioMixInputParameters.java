package com.tencent.tavkit.composition.audio;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVAudioMixInputParameters
  extends MutableAudioMixInputParameters
{
  private static final String TAG = "TAVAudioMixInputParameters";
  @NonNull
  private List<TAVAudioConfigurationSegment> audioConfigurationSegmentList = new ArrayList();
  
  public TAVAudioMixInputParameters(AssetTrack paramAssetTrack)
  {
    super(paramAssetTrack);
  }
  
  public void addAudioConfiguration(@NonNull CMTimeRange paramCMTimeRange, @NonNull TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    this.audioConfigurationSegmentList.add(new TAVAudioConfigurationSegment(paramCMTimeRange, paramTAVAudioConfiguration));
  }
  
  public List<TAVAudioConfigurationSegment> getAudioConfigurationSegmentList()
  {
    return this.audioConfigurationSegmentList;
  }
  
  public float getVolumeAtTime(@NonNull CMTime paramCMTime)
  {
    Iterator localIterator = this.audioConfigurationSegmentList.iterator();
    while (localIterator.hasNext())
    {
      TAVAudioConfigurationSegment localTAVAudioConfigurationSegment = (TAVAudioConfigurationSegment)localIterator.next();
      if ((localTAVAudioConfigurationSegment != null) && (localTAVAudioConfigurationSegment.compositionTimeRange.containsTime(paramCMTime)))
      {
        if ((localTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge() != null) && (localTAVAudioConfigurationSegment.compositionTimeRange.getStart().add(localTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge().getDuration()).bigThan(paramCMTime))) {
          return localTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge().getVolume(paramCMTime.sub(localTAVAudioConfigurationSegment.compositionTimeRange.getStart()));
        }
        if ((localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge() != null) && (localTAVAudioConfigurationSegment.compositionTimeRange.getEnd().sub(localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getDuration()).smallThan(paramCMTime))) {
          return localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getVolume(paramCMTime.sub(localTAVAudioConfigurationSegment.compositionTimeRange.getEnd().sub(localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getDuration())));
        }
        return localTAVAudioConfigurationSegment.audioConfiguration.getVolume(paramCMTime);
      }
    }
    Logger.e("TAVAudioMixInputParameters", "没有设置正确audioConfiguration，走到了非预想的分支");
    return super.getVolumeAtTime(paramCMTime);
  }
  
  public void setAudioConfigurationSegments(@NonNull List<TAVAudioConfigurationSegment> paramList)
  {
    this.audioConfigurationSegmentList.clear();
    this.audioConfigurationSegmentList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */