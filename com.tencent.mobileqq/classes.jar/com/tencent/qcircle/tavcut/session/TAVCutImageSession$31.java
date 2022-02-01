package com.tencent.qcircle.tavcut.session;

import android.graphics.RectF;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.lang.ref.WeakReference;
import java.util.List;

class TAVCutImageSession$31
  implements Runnable
{
  TAVCutImageSession$31(TAVCutImageSession paramTAVCutImageSession, int paramInt, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    RectF localRectF = ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.this$0).get(this.val$index)).get()).getBitmapBound();
    ((MediaModel)this.this$0.getMediaModels().get(this.val$index)).getMediaEffectModel().getGestureModel().postTranslate(this.val$dx, this.val$dy, localRectF);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.31
 * JD-Core Version:    0.7.0.1
 */