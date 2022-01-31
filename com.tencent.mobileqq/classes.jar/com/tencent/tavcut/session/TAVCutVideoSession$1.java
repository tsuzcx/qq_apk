package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutVideoSession$1
  implements MediaBuilderListener
{
  TAVCutVideoSession$1(TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    paramInt = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int i = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    if (TAVCutVideoSession.access$000(this.this$0) != null) {
      TAVCutVideoSession.access$000(this.this$0).adjustStickerContainer(new Size(paramInt, i));
    }
    this.this$0.constrainRenderSize(paramInt, i, paramVideoRenderChainManager);
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    paramMediaBuilderOutput = paramVideoRenderChainManager.getComposition();
    if (this.this$0.sessionConfig != null) {}
    for (paramVideoRenderChainManager = this.this$0.sessionConfig.getRenderLayoutMode();; paramVideoRenderChainManager = null)
    {
      paramMediaBuilderOutput.setRenderLayoutMode(paramVideoRenderChainManager);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.1
 * JD-Core Version:    0.7.0.1
 */