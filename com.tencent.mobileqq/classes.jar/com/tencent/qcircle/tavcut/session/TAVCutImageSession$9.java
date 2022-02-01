package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import java.util.List;
import java.util.Map;

class TAVCutImageSession$9
  implements Runnable
{
  TAVCutImageSession$9(TAVCutImageSession paramTAVCutImageSession, int paramInt, float paramFloat1, String paramString1, float paramFloat2, Map paramMap, String paramString2) {}
  
  public void run()
  {
    TAVCutImageSession localTAVCutImageSession = this.this$0;
    localTAVCutImageSession.resetAEKitModel((MediaModel)localTAVCutImageSession.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$effectStrength, this.val$lutPath, this.val$glowStrength, this.val$adjustParams, this.val$materialPath);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.9
 * JD-Core Version:    0.7.0.1
 */