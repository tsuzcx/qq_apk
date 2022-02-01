package com.tencent.qcircle.tavcut.session;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import com.tencent.qcircle.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.lang.ref.WeakReference;
import java.util.List;

class TAVCutImageSession$27$1$1$1
  implements Runnable
{
  TAVCutImageSession$27$1$1$1(TAVCutImageSession.27.1.1 param1, Bitmap paramBitmap, List paramList) {}
  
  public void run()
  {
    Object localObject = (WeakReference)TAVCutImageSession.access$400(this.this$3.this$2.this$1.this$0).get(this.this$3.this$2.this$1.val$index);
    if (localObject != null)
    {
      localObject = (TAVCutImageView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (!BitmapUtil.isValidBitmap(this.val$bitmap))
        {
          if (this.this$3.this$2.this$1.val$onRenderFinishListener != null) {
            this.this$3.this$2.this$1.val$onRenderFinishListener.onRenderFinish();
          }
          return;
        }
        ((MediaModel)this.this$3.this$2.this$1.this$0.getMediaModels().get(this.this$3.this$2.this$1.val$index)).getMediaEffectModel().getGestureModel().setCorner(this.val$pointFList);
        ((TAVCutImageView)localObject).setImageBitmap(this.val$bitmap, this.val$pointFList);
        TAVCutImageSession.access$1100(this.this$3.this$2.this$1.this$0, this.this$3.this$2.this$1.val$index, this.val$bitmap, this.val$pointFList);
        this.this$3.this$2.this$1.this$0.resizeUI(this.this$3.this$2.this$1.val$index);
        TAVCutImageSession.access$1300(this.this$3.this$2.this$1.this$0, this.this$3.this$2.this$1.val$index);
        localObject = (VideoRenderChainManager)this.this$3.this$2.this$1.this$0.renderChainManagers.get(this.this$3.this$2.this$1.this$0.currentIndex);
        if (localObject != null) {
          ((VideoRenderChainManager)localObject).setNeedRenderOverlayStickerMergedEffectNode(true);
        }
        if (this.this$3.this$2.this$1.val$onRenderFinishListener != null) {
          this.this$3.this$2.this$1.val$onRenderFinishListener.onRenderFinish();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.27.1.1.1
 * JD-Core Version:    0.7.0.1
 */