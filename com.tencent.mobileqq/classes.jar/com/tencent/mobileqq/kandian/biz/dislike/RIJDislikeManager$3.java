package com.tencent.mobileqq.kandian.biz.dislike;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.widget.KandianNegativeWindowForAd;

class RIJDislikeManager$3
  implements PopupWindow.OnDismissListener
{
  RIJDislikeManager$3(RIJDislikeManager paramRIJDislikeManager, RIJDataManager paramRIJDataManager) {}
  
  public void onDismiss()
  {
    RIJDislikeManager.a(this.b).a(1.0F);
    if (this.a.a().f())
    {
      this.a.a().z().v();
      this.a.a().f(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.3
 * JD-Core Version:    0.7.0.1
 */