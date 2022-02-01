package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.List;

class TAVCutVideoSession$1
  implements MediaBuilderListener
{
  TAVCutVideoSession$1(TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    TAVCutVideoSession.access$002(this.this$0, paramMediaBuilderOutput);
    paramInt = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int i = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    if (this.this$0.tavCutVideoView != null) {
      this.this$0.tavCutVideoView.adjustStickerContainer(new Size(paramInt, i));
    }
    paramMediaBuilderOutput = this.this$0.constrainRenderSize(paramInt, i);
    TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager, paramMediaBuilderOutput);
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    paramMediaBuilderOutput = paramVideoRenderChainManager.getComposition();
    if (this.this$0.sessionConfig != null) {
      paramVideoRenderChainManager = this.this$0.sessionConfig.getRenderLayoutMode();
    } else {
      paramVideoRenderChainManager = null;
    }
    paramMediaBuilderOutput.setRenderLayoutMode(paramVideoRenderChainManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.1
 * JD-Core Version:    0.7.0.1
 */