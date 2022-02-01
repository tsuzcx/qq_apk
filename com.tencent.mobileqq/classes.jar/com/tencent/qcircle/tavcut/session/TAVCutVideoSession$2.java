package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutVideoSession$2
  implements MediaBuilderListener
{
  TAVCutVideoSession$2(TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    paramInt = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int i = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    paramMediaBuilderOutput = this.this$0.constrainRenderSize(paramInt, i);
    TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager, paramMediaBuilderOutput);
    TAVCutVideoSession.access$202(this.this$0, paramVideoRenderChainManager.getComposition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.2
 * JD-Core Version:    0.7.0.1
 */