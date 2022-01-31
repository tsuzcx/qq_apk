package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.HashMap;
import java.util.List;

class TAVCutImageSession$10
  implements Runnable
{
  TAVCutImageSession$10(TAVCutImageSession paramTAVCutImageSession, int paramInt1, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt2, float paramFloat2) {}
  
  public void run()
  {
    this.this$0.setAEKitAIFilter((MediaModel)this.this$0.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, 0L, ((MediaClipModel)((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaResourceModel().getVideos().get(0)).getResource().getSelectTimeDuration());
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.10
 * JD-Core Version:    0.7.0.1
 */