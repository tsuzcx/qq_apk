package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.util.CompositionUtils;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.composition.image.WSImageRender;

class TAVCutImageSession$3
  implements MediaBuilderListener
{
  TAVCutImageSession$3(TAVCutImageSession paramTAVCutImageSession, int paramInt, CGSize paramCGSize) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.this$0.renderChainManagers.put(this.val$index, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(this.val$index, paramVideoRenderChainManager.getComposition());
    paramVideoRenderChainManager.getComposition().setRenderSize(this.val$size);
    paramVideoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    paramMediaBuilderOutput = new WSImageRender();
    CompositionUtils.removeTAVAspectEffect(paramVideoRenderChainManager.getComposition());
    paramMediaBuilderOutput.init(paramVideoRenderChainManager.getComposition(), paramVideoRenderChainManager.getComposition().getRenderSize());
    paramMediaBuilderOutput.setMineIndex(this.val$index);
    paramMediaBuilderOutput.setCurrent(this.this$0.getCurrentIndex());
    TAVCutImageSession.access$300(this.this$0).put(this.val$index, paramMediaBuilderOutput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.3
 * JD-Core Version:    0.7.0.1
 */