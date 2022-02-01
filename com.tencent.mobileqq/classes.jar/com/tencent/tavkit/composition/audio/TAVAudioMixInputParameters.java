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
  @NonNull
  private final List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
  private final String mTAG;
  private int reportCount;
  
  public TAVAudioMixInputParameters(AssetTrack paramAssetTrack)
  {
    super(paramAssetTrack);
    paramAssetTrack = new StringBuilder();
    paramAssetTrack.append("TAVAudioMixInputParamet@");
    paramAssetTrack.append(Integer.toHexString(hashCode()));
    this.mTAG = paramAssetTrack.toString();
    this.audioConfigurationSegmentList = new ArrayList();
    this.reportCount = 0;
  }
  
  private void errorReport(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.reportCount < 1)
    {
      Logger.e(paramString1, paramString2, paramThrowable);
      this.reportCount += 1;
    }
  }
  
  private Float getVolume(@NonNull CMTime paramCMTime, TAVAudioConfigurationSegment paramTAVAudioConfigurationSegment)
  {
    if ((paramTAVAudioConfigurationSegment != null) && (paramTAVAudioConfigurationSegment.compositionTimeRange.containsTime(paramCMTime)))
    {
      TAVAudioConfiguration.VolumeEdge localVolumeEdge = paramTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge();
      CMTime localCMTime = paramTAVAudioConfigurationSegment.compositionTimeRange.getStart();
      if ((localVolumeEdge != null) && (localCMTime.add(localVolumeEdge.getDuration()).bigThan(paramCMTime))) {
        return Float.valueOf(localVolumeEdge.getVolume(paramCMTime.sub(localCMTime)));
      }
      localVolumeEdge = paramTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge();
      localCMTime = paramTAVAudioConfigurationSegment.compositionTimeRange.getEnd();
      if ((localVolumeEdge != null) && (localCMTime.sub(localVolumeEdge.getDuration()).smallThan(paramCMTime))) {
        return Float.valueOf(localVolumeEdge.getVolume(paramCMTime.sub(localCMTime.sub(localVolumeEdge.getDuration()))));
      }
      return Float.valueOf(paramTAVAudioConfigurationSegment.audioConfiguration.getVolume(paramCMTime));
    }
    return null;
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
      Float localFloat = getVolume(paramCMTime, (TAVAudioConfigurationSegment)localIterator.next());
      if (localFloat != null) {
        return localFloat.floatValue();
      }
    }
    errorReport(this.mTAG, "没有设置正确audioConfiguration，走到了非预想的分支", null);
    return super.getVolumeAtTime(paramCMTime);
  }
  
  public void setAudioConfigurationSegments(@NonNull List<TAVAudioConfigurationSegment> paramList)
  {
    this.audioConfigurationSegmentList.clear();
    this.audioConfigurationSegmentList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */