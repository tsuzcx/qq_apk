package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutVideoSession$14
  implements MediaBuilderListener
{
  TAVCutVideoSession$14(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    TAVComposition localTAVComposition;
    if (TAVCutVideoSession.access$300(this.this$0))
    {
      TAVCutVideoSession.access$200(this.this$0, paramVideoRenderChainManager.getComposition());
      paramMediaBuilderOutput = TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager);
      paramVideoRenderChainManager.getComposition().setRenderSize(paramMediaBuilderOutput);
      this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
      this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
      localTAVComposition = paramVideoRenderChainManager.getComposition();
      if (this.this$0.sessionConfig == null) {
        break label184;
      }
    }
    label184:
    for (paramMediaBuilderOutput = this.this$0.sessionConfig.getRenderLayoutMode();; paramMediaBuilderOutput = null)
    {
      localTAVComposition.setRenderLayoutMode(paramMediaBuilderOutput);
      this.this$0.getPlayer().updateComposition(paramVideoRenderChainManager.getComposition(), this.val$autoPlay);
      return;
      paramInt = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
      int i = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
      paramMediaBuilderOutput = this.this$0.constrainRenderSize(paramInt, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.14
 * JD-Core Version:    0.7.0.1
 */