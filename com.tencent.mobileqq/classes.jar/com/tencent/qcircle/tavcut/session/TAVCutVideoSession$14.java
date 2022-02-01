package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.tavkit.composition.TAVComposition;

class TAVCutVideoSession$14
  implements MediaBuilderListener
{
  TAVCutVideoSession$14(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    TAVCutVideoSession.access$002(this.this$0, paramMediaBuilderOutput);
    paramMediaBuilderOutput = TAVCutVideoSession.access$400(this.this$0, paramVideoRenderChainManager);
    TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager, paramMediaBuilderOutput);
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    TAVComposition localTAVComposition = paramVideoRenderChainManager.getComposition();
    if (this.this$0.sessionConfig != null) {
      paramMediaBuilderOutput = this.this$0.sessionConfig.getRenderLayoutMode();
    } else {
      paramMediaBuilderOutput = null;
    }
    localTAVComposition.setRenderLayoutMode(paramMediaBuilderOutput);
    this.this$0.getPlayer().updateComposition(paramVideoRenderChainManager.getComposition(), this.val$autoPlay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.14
 * JD-Core Version:    0.7.0.1
 */