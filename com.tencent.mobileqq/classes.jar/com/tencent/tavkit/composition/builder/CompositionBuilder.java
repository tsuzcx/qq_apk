package com.tencent.tavkit.composition.builder;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class CompositionBuilder
{
  private BuilderModel builderModel;
  private MutableComposition composition;
  private boolean isAudioTracksMerge;
  private boolean isVideoTracksMerge;
  
  public CompositionBuilder(BuilderModel paramBuilderModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.builderModel = paramBuilderModel;
    this.isVideoTracksMerge = paramBoolean1;
    this.isAudioTracksMerge = paramBoolean2;
    this.composition = new MutableComposition();
  }
  
  @NonNull
  private AudioTransitionInfo getAudioTransitionInfo(List<? extends TAVTransitionableAudio> paramList, TAVAudioTransition paramTAVAudioTransition, TAVTransitionableAudio paramTAVTransitionableAudio, int paramInt)
  {
    if ((paramInt == 0) && (paramList.size() > 1)) {
      return new AudioTransitionInfo(null, paramTAVTransitionableAudio.getAudioTransition());
    }
    if (paramInt == paramList.size() - 1) {
      return new AudioTransitionInfo(paramTAVAudioTransition, null);
    }
    return new AudioTransitionInfo(paramTAVAudioTransition, paramTAVTransitionableAudio.getAudioTransition());
  }
  
  private void initCompositionWithAudioChannels()
  {
    Iterator localIterator = this.builderModel.getAudioChannels().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      traverseAudioChannel(localList, null, localArrayList, localHashMap);
      this.builderModel.addMainAudioTrackInfo(new AudioParamsInfo(localArrayList, localHashMap));
    }
  }
  
  private void initCompositionWithMixAudios(List<? extends TAVAudio> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVAudio localTAVAudio = (TAVAudio)paramList.next();
      int i = 0;
      while (i < localTAVAudio.numberOfAudioTracks())
      {
        CompositionTrack localCompositionTrack = localTAVAudio.audioCompositionTrackForComposition(this.composition, i, this.isAudioTracksMerge);
        if (localCompositionTrack != null) {
          this.builderModel.addAudioTrackInfo(new AudioMixInfo(localCompositionTrack, localTAVAudio));
        }
        i += 1;
      }
    }
  }
  
  private void initCompositionWithOverlays(List<? extends TAVVideo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVVideo localTAVVideo = (TAVVideo)paramList.next();
      int i = 0;
      while (i < localTAVVideo.numberOfVideoTracks())
      {
        CompositionTrack localCompositionTrack = localTAVVideo.videoCompositionTrackForComposition(this.composition, i, this.isVideoTracksMerge);
        if (localCompositionTrack != null) {
          this.builderModel.addOverlayTrackInfo(new VideoOverlayInfo(localCompositionTrack, localTAVVideo));
        }
        i += 1;
      }
    }
  }
  
  private void initCompositionWithVideoChannels()
  {
    Iterator localIterator = this.builderModel.getVideoChannels().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      ArrayList localArrayList = new ArrayList();
      traverseVideoChannel(localList, localArrayList);
      this.builderModel.addMainVideoTrackInfo(localArrayList);
    }
  }
  
  private void traverseAudioChannel(List<? extends TAVTransitionableAudio> paramList, TAVAudioTransition paramTAVAudioTransition, List<AudioInfo> paramList1, HashMap<String, AudioTransitionInfo> paramHashMap)
  {
    int i = 0;
    while (i < paramList.size())
    {
      TAVTransitionableAudio localTAVTransitionableAudio = (TAVTransitionableAudio)paramList.get(i);
      traverseAudioClip(paramList1, localTAVTransitionableAudio);
      paramHashMap.put(String.valueOf(i), getAudioTransitionInfo(paramList, paramTAVAudioTransition, localTAVTransitionableAudio, i));
      paramTAVAudioTransition = localTAVTransitionableAudio.getAudioTransition();
      i += 1;
    }
  }
  
  private void traverseAudioClip(List<AudioInfo> paramList, TAVTransitionableAudio paramTAVTransitionableAudio)
  {
    int i = 0;
    while (i < paramTAVTransitionableAudio.numberOfAudioTracks())
    {
      CompositionTrack localCompositionTrack = paramTAVTransitionableAudio.audioCompositionTrackForComposition(this.composition, i, this.isAudioTracksMerge);
      if (localCompositionTrack != null) {
        paramList.add(new AudioInfo(localCompositionTrack, paramTAVTransitionableAudio));
      }
      i += 1;
    }
  }
  
  private void traverseVideoChannel(List<? extends TAVTransitionableVideo> paramList, List<VideoInfo> paramList1)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      traverseVideoClip(paramList1, (TAVTransitionableVideo)paramList.next());
    }
  }
  
  private void traverseVideoClip(List<VideoInfo> paramList, TAVTransitionableVideo paramTAVTransitionableVideo)
  {
    int i = 0;
    while (i < paramTAVTransitionableVideo.numberOfVideoTracks())
    {
      CompositionTrack localCompositionTrack = paramTAVTransitionableVideo.videoCompositionTrackForComposition(this.composition, i, this.isVideoTracksMerge);
      if (localCompositionTrack != null) {
        paramList.add(new VideoInfo(localCompositionTrack, paramTAVTransitionableVideo));
      }
      i += 1;
    }
  }
  
  @NonNull
  MutableComposition build()
  {
    initCompositionWithVideoChannels();
    initCompositionWithAudioChannels();
    initCompositionWithOverlays(this.builderModel.getOverlays());
    initCompositionWithMixAudios(this.builderModel.getMixAudios());
    return this.composition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.CompositionBuilder
 * JD-Core Version:    0.7.0.1
 */