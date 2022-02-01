package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$15
  implements Runnable
{
  TAVCutImageSession$15(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    MediaModel localMediaModel = (MediaModel)this.this$0.mediaModels.get(this.val$index);
    AEKitModel localAEKitModel = localMediaModel.getMediaEffectModel().getAeKitModel();
    Object localObject = localAEKitModel;
    if (localAEKitModel == null) {
      localObject = new AEKitModel(1);
    }
    ((AEKitModel)localObject).setOverlayImagePath(this.val$overlayImgPath);
    localMediaModel.getMediaEffectModel().setAeKitModel((AEKitModel)localObject);
    localObject = this.this$0;
    ((TAVCutImageSession)localObject).updateRenderChain((VideoRenderChainManager)((TAVCutImageSession)localObject).renderChainManagers.get(this.val$index), localMediaModel.getMediaEffectModel(), false);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.15
 * JD-Core Version:    0.7.0.1
 */