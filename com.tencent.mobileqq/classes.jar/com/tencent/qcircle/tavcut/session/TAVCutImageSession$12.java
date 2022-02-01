package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.HashMap;
import java.util.List;

class TAVCutImageSession$12
  implements Runnable
{
  TAVCutImageSession$12(TAVCutImageSession paramTAVCutImageSession, int paramInt1, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt2, float paramFloat2) {}
  
  public void run()
  {
    TAVCutImageSession localTAVCutImageSession = this.this$0;
    localTAVCutImageSession.resetAEKitModelForAI((MediaModel)localTAVCutImageSession.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, ((MediaClipModel)((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaResourceModel().getVideos().get(0)).getResource().getSelectTimeDuration());
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.12
 * JD-Core Version:    0.7.0.1
 */