package com.tencent.mobileqq.wink.pick.album;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class WinkAlbumLinearLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  WinkAlbumLinearLayout$1(WinkAlbumLinearLayout paramWinkAlbumLinearLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getAnimatedValue() instanceof Integer))
    {
      if (WinkAlbumLinearLayout.a(this.a) != null) {
        WinkAlbumLinearLayout.a(this.a).a(((Integer)paramValueAnimator.getAnimatedValue()).intValue() / (WinkAlbumLinearLayout.b(this.a) * 1.0F));
      }
      this.a.scrollTo(0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.WinkAlbumLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */