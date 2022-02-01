package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$32
  implements Runnable
{
  TAVCutImageSession$32(TAVCutImageSession paramTAVCutImageSession, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    ((MediaModel)this.this$0.getMediaModels().get(this.jdField_a_of_type_Int)).getMediaEffectModel().getGestureModel().postScale(this.jdField_a_of_type_Float, this.b, this.c);
    this.this$0.render(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.32
 * JD-Core Version:    0.7.0.1
 */