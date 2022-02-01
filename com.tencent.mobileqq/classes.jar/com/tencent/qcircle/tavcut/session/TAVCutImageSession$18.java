package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.WSTemplateManager;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$18
  implements Runnable
{
  TAVCutImageSession$18(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    MediaModel localMediaModel = (MediaModel)this.this$0.mediaModels.get(this.val$index);
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "0");
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_COLOR", null);
    localMediaModel.getMediaEffectModel().getGestureModel().reset();
    WSTemplateManager.clearMediaTemplateModel(localMediaModel);
    TAVCutImageSession.access$600(this.this$0, this.val$index, true);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.18
 * JD-Core Version:    0.7.0.1
 */