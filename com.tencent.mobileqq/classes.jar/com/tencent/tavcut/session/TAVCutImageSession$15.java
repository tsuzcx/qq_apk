package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$15
  implements Runnable
{
  TAVCutImageSession$15(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    MediaModel localMediaModel = (MediaModel)this.this$0.mediaModels.get(this.val$index);
    AEKitModel localAEKitModel2 = localMediaModel.getMediaEffectModel().getAeKitModel();
    AEKitModel localAEKitModel1 = localAEKitModel2;
    if (localAEKitModel2 == null) {
      localAEKitModel1 = new AEKitModel(1);
    }
    localAEKitModel1.setOverlayImagePath(this.val$overlayImgPath);
    localMediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel1);
    this.this$0.updateRenderChain((VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), localMediaModel.getMediaEffectModel());
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.15
 * JD-Core Version:    0.7.0.1
 */