package com.tencent.tavcut.session;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.lang.ref.WeakReference;
import java.util.List;

class TAVCutImageSession$27$1$1$1
  implements Runnable
{
  TAVCutImageSession$27$1$1$1(TAVCutImageSession.27.1.1 param1, Bitmap paramBitmap, List paramList) {}
  
  public void run()
  {
    Object localObject = (WeakReference)TAVCutImageSession.access$400(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0).get(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_Int);
    if (localObject != null)
    {
      localObject = (TAVCutImageView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (!BitmapUtil.isValidBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap))
        {
          if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_ComTencentTavcutViewExtOnRenderFinishListener != null) {
            this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_ComTencentTavcutViewExtOnRenderFinishListener.a();
          }
          return;
        }
        ((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0.getMediaModels().get(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_Int)).getMediaEffectModel().getGestureModel().setCorner(this.jdField_a_of_type_JavaUtilList);
        ((TAVCutImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaUtilList);
        TAVCutImageSession.access$1100(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0.resizeUI(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_Int);
        TAVCutImageSession.access$1300(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_Int);
        localObject = (VideoRenderChainManager)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0.renderChainManagers.get(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.this$0.currentIndex);
        if (localObject != null) {
          ((VideoRenderChainManager)localObject).setNeedRenderOverlayStickerMergedEffectNode(true);
        }
        if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_ComTencentTavcutViewExtOnRenderFinishListener != null) {
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession$27$1$1.a.a.jdField_a_of_type_ComTencentTavcutViewExtOnRenderFinishListener.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.27.1.1.1
 * JD-Core Version:    0.7.0.1
 */