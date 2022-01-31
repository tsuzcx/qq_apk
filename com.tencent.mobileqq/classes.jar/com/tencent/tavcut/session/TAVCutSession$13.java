package com.tencent.tavcut.session;

import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;

class TAVCutSession$13
  implements Runnable
{
  TAVCutSession$13(TAVCutSession paramTAVCutSession, CropConfig paramCropConfig, MediaModel paramMediaModel, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    CropModel localCropModel = new CropModel();
    localCropModel.setCropConfig(this.val$cropConfig);
    this.val$mediaModel.getMediaEffectModel().setCropModel(localCropModel);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.13
 * JD-Core Version:    0.7.0.1
 */