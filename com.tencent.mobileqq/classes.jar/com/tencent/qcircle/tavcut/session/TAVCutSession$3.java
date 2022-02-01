package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;

class TAVCutSession$3
  implements Runnable
{
  TAVCutSession$3(TAVCutSession paramTAVCutSession, CropConfig paramCropConfig, MediaModel paramMediaModel, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    CropModel localCropModel = new CropModel();
    localCropModel.setCropConfig(this.val$cropConfig);
    this.val$mediaModel.getMediaEffectModel().setCropModel(localCropModel);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.3
 * JD-Core Version:    0.7.0.1
 */