package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.HashMap;
import java.util.List;

class TAVCutImageSession$11
  implements Runnable
{
  TAVCutImageSession$11(TAVCutImageSession paramTAVCutImageSession, int paramInt, HashMap paramHashMap) {}
  
  public void run()
  {
    this.this$0.setAIFilter((MediaModel)this.this$0.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$adjustParams, 0L, ((MediaClipModel)((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaResourceModel().getVideos().get(0)).getResource().getSelectTimeDuration());
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.11
 * JD-Core Version:    0.7.0.1
 */