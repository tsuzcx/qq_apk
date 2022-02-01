package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import com.tencent.mobileqq.emoticon.StickerFrameLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class StickerGestureDetector$2
  extends D8SafeAnimatorListener
{
  StickerGestureDetector$2(StickerGestureDetector paramStickerGestureDetector) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.this$0.popupEmo != null)
    {
      float f = this.this$0.popupEmo.getTranslationX();
      this.this$0.popupEmo.setTranslationX(0.0F);
      paramAnimator = this.this$0;
      paramAnimator.stickerLayout((int)(paramAnimator.popupEmo.getLeft() + f), this.this$0.popupEmo.getTop(), (int)(this.this$0.popupEmo.getLeft() + f + this.this$0.popupEmo.getWidth()), this.this$0.popupEmo.getBottom());
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector.2
 * JD-Core Version:    0.7.0.1
 */