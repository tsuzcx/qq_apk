package com.tencent.tavcut.session;

import android.graphics.PointF;
import android.util.SparseArray;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.tavsticker.core.TAVStickerContext.InterceptTouchDelegate;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import java.lang.ref.WeakReference;

class TAVCutImageSession$34
  implements TAVStickerContext.InterceptTouchDelegate
{
  TAVCutImageSession$34(TAVCutImageSession paramTAVCutImageSession) {}
  
  public void a(PointF paramPointF)
  {
    ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.a).get(this.a.currentIndex)).get()).setBasePicActive(true);
    if (this.a.renderChainManagers.get(this.a.currentIndex) != null) {
      ((VideoRenderChainManager)this.a.renderChainManagers.get(this.a.currentIndex)).setBasePicActive(true);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(PointF paramPointF)
  {
    return ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.a).get(this.a.currentIndex)).get()).checkInside(paramPointF, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.34
 * JD-Core Version:    0.7.0.1
 */