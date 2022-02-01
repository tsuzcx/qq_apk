package com.tencent.mobileqq.kandian.biz.dislike;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.widget.KandianNegativeWindow;

class RIJDislikeManager$4
  implements PopupWindow.OnDismissListener
{
  RIJDislikeManager$4(RIJDislikeManager paramRIJDislikeManager, RIJDataManager paramRIJDataManager) {}
  
  public void onDismiss()
  {
    RIJDislikeManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager).a(1.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().c();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().f(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.4
 * JD-Core Version:    0.7.0.1
 */