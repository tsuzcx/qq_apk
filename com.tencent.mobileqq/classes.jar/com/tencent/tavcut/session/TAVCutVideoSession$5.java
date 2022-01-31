package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;

class TAVCutVideoSession$5
  implements MediaBuilderListener
{
  TAVCutVideoSession$5(TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    TAVCutVideoSession.access$300(this.this$0).setRenderSize(new CGSize(1280.0F, 1280.0F));
    TAVCutVideoSession.access$300(this.this$0).setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.5
 * JD-Core Version:    0.7.0.1
 */