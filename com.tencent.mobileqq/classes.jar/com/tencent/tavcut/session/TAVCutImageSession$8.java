package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
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
        this.this$0.resetAEKitModel((MediaModel)this.this$0.mediaModels.get(i), (VideoRenderChainManager)this.this$0.renderChainManagers.get(i), this.val$effectStrength, this.val$lutPath, this.val$glowStrength, this.val$adjustParams, this.val$materialPath);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.8
 * JD-Core Version:    0.7.0.1
 */