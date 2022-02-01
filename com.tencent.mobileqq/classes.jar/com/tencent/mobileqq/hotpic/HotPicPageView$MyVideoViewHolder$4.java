package com.tencent.mobileqq.hotpic;

import android.widget.ImageView;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class HotPicPageView$MyVideoViewHolder$4
  implements ValueAnimator.AnimatorUpdateListener
{
  HotPicPageView$MyVideoViewHolder$4(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    if (this.a.a.getVisibility() == 0) {
      this.a.a.setAlpha(f);
    }
    HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = this.a.a();
    if (localHotVideoMongoliaRelativeLayout != null) {
      localHotVideoMongoliaRelativeLayout.a(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder.4
 * JD-Core Version:    0.7.0.1
 */