package dov.com.qq.im.ae.gif;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEGifTipsPopupPart$4
  implements Animation.AnimationListener
{
  AEGifTipsPopupPart$4(AEGifTipsPopupPart paramAEGifTipsPopupPart) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEGifTipsPopupPart.a(this.a).setVisibility(8);
    AEGifTipsPopupPart.a(this.a).setAlpha(1.0F);
    AEGifTipsPopupPart.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGifTipsPopupPart.4
 * JD-Core Version:    0.7.0.1
 */