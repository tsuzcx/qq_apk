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
    RIJDislikeManager.b(this.b).a(1.0F);
    if (this.a.a().f())
    {
      this.a.a().z().v();
      this.a.a().f(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.4
 * JD-Core Version:    0.7.0.1
 */