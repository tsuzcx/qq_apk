package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView;

class ProteusItemView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ProteusItemView$3(ProteusItemView paramProteusItemView) {}
  
  public void onGlobalLayout()
  {
    if (this.a.getParent() == null)
    {
      ReadInJoyVideoView localReadInJoyVideoView = ProteusItemView.b(ProteusItemView.b(this.a));
      if ((localReadInJoyVideoView != null) && (localReadInJoyVideoView.isVisible()) && (ProteusItemView.a(this.a, localReadInJoyVideoView.a()))) {
        localReadInJoyVideoView.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView.3
 * JD-Core Version:    0.7.0.1
 */