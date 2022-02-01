package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.widget.KandianNegativeWindow;

class FeedItemCell$7
  implements PopupWindow.OnDismissListener
{
  FeedItemCell$7(FeedItemCell paramFeedItemCell, KandianNegativeWindow paramKandianNegativeWindow) {}
  
  public void onDismiss()
  {
    this.a.a(1.0F);
    if (this.b.g.A())
    {
      VideoPlayManager localVideoPlayManager = this.b.g.R();
      if (localVideoPlayManager != null)
      {
        localVideoPlayManager.v();
        this.b.g.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.7
 * JD-Core Version:    0.7.0.1
 */