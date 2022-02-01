package com.tencent.tavcut.session;

import android.graphics.RectF;
import android.util.SparseArray;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.lang.ref.WeakReference;
import java.util.List;

class TAVCutImageSession$31
  implements Runnable
{
  TAVCutImageSession$31(TAVCutImageSession paramTAVCutImageSession, int paramInt, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    RectF localRectF = ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.this$0).get(this.jdField_a_of_type_Int)).get()).getBitmapBound();
    ((MediaModel)this.this$0.getMediaModels().get(this.jdField_a_of_type_Int)).getMediaEffectModel().getGestureModel().postTranslate(this.jdField_a_of_type_Float, this.b, localRectF);
    this.this$0.render(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.31
 * JD-Core Version:    0.7.0.1
 */