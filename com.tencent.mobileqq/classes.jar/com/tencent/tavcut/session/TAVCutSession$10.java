package com.tencent.tavcut.session;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;

class TAVCutSession$10
  implements Runnable
{
  TAVCutSession$10(TAVCutSession paramTAVCutSession, long paramLong1, long paramLong2, MediaModel paramMediaModel, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    AEKitModel localAEKitModel = new AEKitModel();
    localAEKitModel.setStartTime(this.val$startTime);
    localAEKitModel.setDuration(this.val$duration);
    this.val$mediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.10
 * JD-Core Version:    0.7.0.1
 */