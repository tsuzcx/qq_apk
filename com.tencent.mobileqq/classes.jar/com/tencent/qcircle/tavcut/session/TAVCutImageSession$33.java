package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$33
  implements Runnable
{
  TAVCutImageSession$33(TAVCutImageSession paramTAVCutImageSession, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    ((MediaModel)this.this$0.getMediaModels().get(this.val$index)).getMediaEffectModel().getGestureModel().postRotate(this.val$degree, this.val$focusX, this.val$focusY);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.33
 * JD-Core Version:    0.7.0.1
 */