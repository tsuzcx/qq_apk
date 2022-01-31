package com.tencent.tavkit.composition.builder;

import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.List;

class BuilderModel
{
  private final List<AudioMixInfo> audioTrackInfo;
  private final List<AudioParamsInfo> mainAudioTrackInfo;
  private final List<List<VideoInfo>> mainVideoTrackInfo;
  private final List<VideoOverlayInfo> overlayTrackInfo;
  private final TAVComposition tavComposition;
  
  BuilderModel(TAVComposition paramTAVComposition)
  {
    this.tavComposition = paramTAVComposition;
    this.mainVideoTrackInfo = new ArrayList();
    this.mainAudioTrackInfo = new ArrayList();
    this.overlayTrackInfo = new ArrayList();
    this.audioTrackInfo = new ArrayList();
  }
  
  void addAudioTrackInfo(AudioMixInfo paramAudioMixInfo)
  {
    this.audioTrackInfo.add(paramAudioMixInfo);
  }
  
  void addMainAudioTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    this.mainAudioTrackInfo.add(paramAudioParamsInfo);
  }
  
  void addMainVideoTrackInfo(List<VideoInfo> paramList)
  {
    this.mainVideoTrackInfo.add(paramList);
  }
  
  void addOverlayTrackInfo(VideoOverlayInfo paramVideoOverlayInfo)
  {
    this.overlayTrackInfo.add(paramVideoOverlayInfo);
  }
  
  List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    return this.tavComposition.getAudioChannels();
  }
  
  List<AudioMixInfo> getAudioTrackInfo()
  {
    return this.audioTrackInfo;
  }
  
  int getBackgroundColor()
  {
    return this.tavComposition.getBackgroundColor();
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    return this.tavComposition.getGlobalVideoEffect();
  }
  
  List<AudioParamsInfo> getMainAudioTrackInfo()
  {
    return this.mainAudioTrackInfo;
  }
  
  public List<List<VideoInfo>> getMainVideoTrackInfo()
  {
    return this.mainVideoTrackInfo;
  }
  
  List<? extends TAVAudio> getMixAudios()
  {
    return this.tavComposition.getAudios();
  }
  
  public List<VideoOverlayInfo> getOverlayTrackInfo()
  {
    return this.overlayTrackInfo;
  }
  
  List<? extends TAVVideo> getOverlays()
  {
    return this.tavComposition.getOverlays();
  }
  
  VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    return this.tavComposition.getRenderLayoutMode();
  }
  
  CGSize getRenderSize()
  {
    return this.tavComposition.getRenderSize();
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    return this.tavComposition.getVideoChannels();
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    return this.tavComposition.getVideoMixEffect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.BuilderModel
 * JD-Core Version:    0.7.0.1
 */