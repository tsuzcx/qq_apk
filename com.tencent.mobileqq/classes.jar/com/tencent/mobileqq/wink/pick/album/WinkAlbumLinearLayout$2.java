package com.tencent.mobileqq.wink.pick.album;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class WinkAlbumLinearLayout$2
  extends D8SafeAnimatorListener
{
  WinkAlbumLinearLayout$2(WinkAlbumLinearLayout paramWinkAlbumLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    WinkAlbumLinearLayout.b(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (WinkAlbumLinearLayout.a(this.a) != null)
    {
      paramAnimator = WinkAlbumLinearLayout.a(this.a);
      int i = WinkAlbumLinearLayout.c(this.a);
      WinkAlbumLinearLayout localWinkAlbumLinearLayout = this.a;
      paramAnimator.a(i, WinkAlbumLinearLayout.a(localWinkAlbumLinearLayout, WinkAlbumLinearLayout.c(localWinkAlbumLinearLayout)));
    }
    WinkAlbumLinearLayout.b(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (WinkAlbumLinearLayout.a(this.a) != null) {
      WinkAlbumLinearLayout.a(this.a).a(WinkAlbumLinearLayout.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.WinkAlbumLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */