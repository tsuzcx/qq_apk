package com.tencent.tavkit.composition.builder;

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
    Object localObject = this.builderModel.getVideoChannels().iterator();
    while (((Iterator)localObject).hasNext()) {
      CompositionUtils.reloadVideoStartTimeWithTransitionableVideo((List)((Iterator)localObject).next());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildComposition: reloadVideoChannels = ");
    ((StringBuilder)localObject).append(this.builderModel.getVideoChannels());
    Logger.d("TAVCompositionBuilder", ((StringBuilder)localObject).toString());
    localObject = this.builderModel.getAudioChannels().iterator();
    while (((Iterator)localObject).hasNext()) {
      CompositionUtils.reloadAudioStartTimeWithTransitionableAudio((List)((Iterator)localObject).next());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildComposition: reloadAudioChannels = ");
    ((StringBuilder)localObject).append(this.builderModel.getAudioChannels());
    Logger.d("TAVCompositionBuilder", ((StringBuilder)localObject).toString());
  }
  
  public TAVSource buildSource()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildSource: begin, tavComposition = ");
    ((StringBuilder)localObject).append(this.builderModel.getTavComposition());
    Logger.i("TAVCompositionBuilder", ((StringBuilder)localObject).toString());
    localObject = new TAVSource();
    ((TAVSource)localObject).setAsset(buildComposition());
    ((TAVSource)localObject).setVideoComposition(buildVideoComposition());
    ((TAVSource)localObject).setAudioMix(buildAudioMix());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildSource: end, return source = ");
    localStringBuilder.append(localObject);
    Logger.i("TAVCompositionBuilder", localStringBuilder.toString());
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.TAVCompositionBuilder
 * JD-Core Version:    0.7.0.1
 */