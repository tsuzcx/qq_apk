package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;

class TAVCutVideoSession$13
  implements MediaBuilderListener
{
  TAVCutVideoSession$13(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    TAVCutVideoSession.access$002(this.this$0, paramMediaBuilderOutput);
    paramMediaBuilderOutput = TAVCutVideoSession.access$300(this.this$0, paramVideoRenderChainManager);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.13
 * JD-Core Version:    0.7.0.1
 */