package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import java.util.List;

class TAVCutImageSession$14
  implements Runnable
{
  TAVCutImageSession$14(TAVCutImageSession paramTAVCutImageSession, int paramInt, float paramFloat) {}
  
  public void run()
  {
    TAVCutImageSession localTAVCutImageSession = this.this$0;
    localTAVCutImageSession.setEffectStrength((MediaModel)localTAVCutImageSession.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$effectStrength);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.14
 * JD-Core Version:    0.7.0.1
 */