package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import java.util.List;
import java.util.Map;

class TAVCutImageSession$8
  implements Runnable
{
  TAVCutImageSession$8(TAVCutImageSession paramTAVCutImageSession, float paramFloat1, String paramString1, float paramFloat2, Map paramMap, String paramString2) {}
  
  public void run()
  {
    if ((this.this$0.mediaModels != null) && (this.this$0.mediaModels.size() > 0))
    {
      int i = 0;
      while (i < this.this$0.mediaModels.size())
      {
        TAVCutImageSession localTAVCutImageSession = this.this$0;
        localTAVCutImageSession.resetAEKitModel((MediaModel)localTAVCutImageSession.mediaModels.get(i), (VideoRenderChainManager)this.this$0.renderChainManagers.get(i), this.val$effectStrength, this.val$lutPath, this.val$glowStrength, this.val$adjustParams, this.val$materialPath);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.8
 * JD-Core Version:    0.7.0.1
 */