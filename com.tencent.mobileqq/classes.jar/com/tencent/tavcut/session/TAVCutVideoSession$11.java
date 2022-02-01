package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;

class TAVCutVideoSession$11
  implements MediaBuilderListener
{
  TAVCutVideoSession$11(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    if (paramVideoRenderChainManager == null) {
      return;
    }
    paramMediaBuilderOutput = TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager);
    paramVideoRenderChainManager.getComposition().setRenderSize(paramMediaBuilderOutput);
    TAVCutVideoSession.access$200(this.this$0, paramVideoRenderChainManager.getComposition());
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    TAVComposition localTAVComposition = paramVideoRenderChainManager.getComposition();
    if (this.this$0.sessionConfig != null) {}
    for (paramMediaBuilderOutput = this.this$0.sessionConfig.getRenderLayoutMode();; paramMediaBuilderOutput = null)
    {
      localTAVComposition.setRenderLayoutMode(paramMediaBuilderOutput);
      if (this.this$0.getPlayer() == null) {
        break;
      }
      this.this$0.getPlayer().setPlayRange(new CMTimeRange(CMTime.CMTimeZero, paramVideoRenderChainManager.getComposition().getDuration()));
      this.this$0.getPlayer().updateComposition(paramVideoRenderChainManager.getComposition(), this.val$autoPlay);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.11
 * JD-Core Version:    0.7.0.1
 */