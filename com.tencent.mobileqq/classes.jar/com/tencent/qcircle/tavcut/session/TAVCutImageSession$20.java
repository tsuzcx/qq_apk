package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$20
  implements Runnable
{
  TAVCutImageSession$20(TAVCutImageSession paramTAVCutImageSession, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    MediaModel localMediaModel = (MediaModel)this.this$0.mediaModels.get(this.val$index);
    localMediaModel.getMediaEffectModel().getGestureModel().reset();
    ModelExtKt.updateFrameFillMode(localMediaModel, this.val$fillMode);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.20
 * JD-Core Version:    0.7.0.1
 */