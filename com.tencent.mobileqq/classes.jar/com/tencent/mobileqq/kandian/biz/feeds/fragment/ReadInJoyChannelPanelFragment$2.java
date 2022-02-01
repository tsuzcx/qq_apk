package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;

class ReadInJoyChannelPanelFragment$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyChannelPanelFragment$2(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, ReadInJoyStaticGridView paramReadInJoyStaticGridView, View paramView) {}
  
  public void onGlobalLayout()
  {
    if (this.a.getHeight() > 0)
    {
      if (this.b.getVisibility() == 8) {
        this.b.setVisibility(0);
      }
    }
    else if (this.b.getVisibility() == 0)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setDuration(400L);
      localAlphaAnimation.setAnimationListener(new ReadInJoyChannelPanelFragment.2.1(this));
      this.b.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.2
 * JD-Core Version:    0.7.0.1
 */