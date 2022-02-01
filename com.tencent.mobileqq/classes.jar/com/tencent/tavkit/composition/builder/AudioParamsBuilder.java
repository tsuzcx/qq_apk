package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters;
import com.tencent.tavkit.composition.audio.TAVAudioTapProcessor;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class AudioParamsBuilder
{
  private HashMap<Integer, TAVAudioMixInputParameters> audioMixInputParametersHashMap = new HashMap();
  private final BuilderModel builderModel;
  
  AudioParamsBuilder(BuilderModel paramBuilderModel)
  {
    this.builderModel = paramBuilderModel;
  }
  
  private void buildAudioParametersByTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    Iterator localIterator = paramAudioParamsInfo.audioInfos.iterator();
    while (localIterator.hasNext())
    {
      AudioInfo localAudioInfo = (AudioInfo)localIterator.next();
      int i = localAudioInfo.compositionTrack.getTrackID();
      TAVAudioMixInputParameters localTAVAudioMixInputParameters = (TAVAudioMixInputParameters)this.audioMixInputParametersHashMap.get(Integer.valueOf(i));
      paramAudioParamsInfo = localTAVAudioMixInputParameters;
      if (localTAVAudioMixInputParameters == null)
      {
        paramAudioParamsInfo = new TAVAudioMixInputParameters(localAudioInfo.compositionTrack);
        this.audioMixInputParametersHashMap.put(Integer.valueOf(i), paramAudioParamsInfo);
      }
      paramAudioParamsInfo.addAudioConfiguration(new CMTimeRange(localAudioInfo.audio.getStartTime(), localAudioInfo.audio.getDuration()), localAudioInfo.audio.getAudioConfiguration());
      paramAudioParamsInfo.setAudioTapProcessor(new TAVAudioTapProcessor(paramAudioParamsInfo.getAudioConfigurationSegmentList()));
    }
  }
  
  private void buildBgAudioInputParameters()
  {
    Iterator localIterator = this.builderModel.getAudioTrackInfo().iterator();
    while (localIterator.hasNext())
    {
      AudioMixInfo localAudioMixInfo = (AudioMixInfo)localIterator.next();
      int i = localAudioMixInfo.track.getTrackID();
      TAVAudioMixInputParameters localTAVAudioMixInputParameters2 = (TAVAudioMixInputParameters)this.audioMixInputParametersHashMap.get(Integer.valueOf(i));
      TAVAudioMixInputParameters localTAVAudioMixInputParameters1 = localTAVAudioMixInputParameters2;
      if (localTAVAudioMixInputParameters2 == null)
      {
        localTAVAudioMixInputParameters1 = new TAVAudioMixInputParameters(localAudioMixInfo.track);
        this.audioMixInputParametersHashMap.put(Integer.valueOf(i), localTAVAudioMixInputParameters1);
      }
      localTAVAudioMixInputParameters1.addAudioConfiguration(new CMTimeRange(localAudioMixInfo.audio.getStartTime(), localAudioMixInfo.audio.getDuration()), localAudioMixInfo.audio.getAudioConfiguration());
      localTAVAudioMixInputParameters1.setAudioTapProcessor(new TAVAudioTapProcessor(localTAVAudioMixInputParameters1.getAudioConfigurationSegmentList()));
    }
  }
  
  private void buildMainAudioInputParameters()
  {
    List localList = this.builderModel.getMainAudioTrackInfo();
    int i = 0;
    while (i < localList.size())
    {
      buildAudioParametersByTrackInfo((AudioParamsInfo)localList.get(i));
      i += 1;
    }
  }
  
  List<TAVAudioMixInputParameters> build()
  {
    buildMainAudioInputParameters();
    buildBgAudioInputParameters();
    return new ArrayList(this.audioMixInputParametersHashMap.values());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioParamsBuilder
 * JD-Core Version:    0.7.0.1
 */