package com.tencent.tavkit.composition.builder;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.AudioMixInputParameters;
import com.tencent.tav.core.MutableAudioMix;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.video.TAVVideoCompositing;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.Iterator;
import java.util.List;

public class TAVCompositionBuilder
{
  private static final String TAG = "TAVCompositionBuilder";
  @NonNull
  private final BuilderModel builderModel;
  private boolean isAudioTracksMerge = true;
  private boolean isReloadChannels = true;
  private boolean isVideoTracksMerge = true;
  
  public TAVCompositionBuilder(TAVComposition paramTAVComposition)
  {
    this.builderModel = new BuilderModel(paramTAVComposition);
  }
  
  private AudioMix<? extends AudioMixInputParameters> buildAudioMix()
  {
    List localList = new AudioParamsBuilder(this.builderModel).build();
    if (localList.size() == 0) {
      return null;
    }
    return new MutableAudioMix(localList);
  }
  
  private Asset buildComposition()
  {
    if (this.isReloadChannels) {
      reloadChannels();
    }
    return new CompositionBuilder(this.builderModel, this.isVideoTracksMerge, this.isAudioTracksMerge).build();
  }
  
  private VideoComposition buildVideoComposition()
  {
    MutableVideoComposition localMutableVideoComposition = new MutableVideoComposition();
    localMutableVideoComposition.setFrameDuration(new CMTime(1L, 30));
    localMutableVideoComposition.setRenderSize(this.builderModel.getRenderSize());
    localMutableVideoComposition.setRenderLayoutMode(this.builderModel.getRenderLayoutMode());
    localMutableVideoComposition.setCustomVideoCompositorClass(TAVVideoCompositing.class);
    localMutableVideoComposition.setInstructions(new VideoInstructionsBuilder(this.builderModel).build());
    return localMutableVideoComposition;
  }
  
  private void reloadChannels()
  {
    Iterator localIterator = this.builderModel.getVideoChannels().iterator();
    while (localIterator.hasNext()) {
      CompositionUtils.reloadVideoStartTimeWithTransitionableVideo((List)localIterator.next());
    }
    Logger.longlogd("TAVCompositionBuilder", "buildComposition: reloadVideoChannels = " + this.builderModel.getVideoChannels());
    localIterator = this.builderModel.getAudioChannels().iterator();
    while (localIterator.hasNext()) {
      CompositionUtils.reloadAudioStartTimeWithTransitionableAudio((List)localIterator.next());
    }
    Logger.longlogd("TAVCompositionBuilder", "buildComposition: reloadAudioChannels = " + this.builderModel.getAudioChannels());
  }
  
  public TAVSource buildSource()
  {
    Logger.longlogd("TAVCompositionBuilder", "buildSource: begin, tavComposition = " + this.builderModel.getTavComposition());
    TAVSource localTAVSource = new TAVSource();
    localTAVSource.setAsset(buildComposition());
    localTAVSource.setVideoComposition(buildVideoComposition());
    localTAVSource.setAudioMix(buildAudioMix());
    Logger.longlogd("TAVCompositionBuilder", "buildSource: end, return source = " + localTAVSource);
    return localTAVSource;
  }
  
  public void setAudioTracksMerge(boolean paramBoolean)
  {
    this.isAudioTracksMerge = paramBoolean;
  }
  
  public void setReloadChannels(boolean paramBoolean)
  {
    this.isReloadChannels = paramBoolean;
  }
  
  public void setVideoTracksMerge(boolean paramBoolean)
  {
    this.isVideoTracksMerge = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.TAVCompositionBuilder
 * JD-Core Version:    0.7.0.1
 */