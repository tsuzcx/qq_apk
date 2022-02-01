package com.tencent.qcircle.tavcut.session;

import android.graphics.PointF;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.tavsticker.core.TAVStickerContext.InterceptTouchDelegate;
import java.lang.ref.WeakReference;

class TAVCutImageSession$34
  implements TAVStickerContext.InterceptTouchDelegate
{
  TAVCutImageSession$34(TAVCutImageSession paramTAVCutImageSession) {}
  
  public boolean checkInterceptArea(PointF paramPointF)
  {
    return ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.this$0).get(this.this$0.currentIndex)).get()).checkInside(paramPointF, true);
  }
  
  public boolean shouldInterceptTouch()
  {
    return true;
  }
  
  public void touchInterceptArea(PointF paramPointF)
  {
    ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.this$0).get(this.this$0.currentIndex)).get()).setBasePicActive(true);
    if (this.this$0.renderChainManagers.get(this.this$0.currentIndex) != null) {
      ((VideoRenderChainManager)this.this$0.renderChainManagers.get(this.this$0.currentIndex)).setBasePicActive(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.34
 * JD-Core Version:    0.7.0.1
 */