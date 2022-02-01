package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;

class StickerGestureDetector$2
  implements Animator.AnimatorListener
{
  StickerGestureDetector$2(StickerGestureDetector paramStickerGestureDetector) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.this$0.popupEmo != null)
    {
      float f = this.this$0.popupEmo.getTranslationX();
      this.this$0.popupEmo.setTranslationX(0.0F);
      this.this$0.stickerLayout((int)(this.this$0.popupEmo.getLeft() + f), this.this$0.popupEmo.getTop(), (int)(f + this.this$0.popupEmo.getLeft() + this.this$0.popupEmo.getWidth()), this.this$0.popupEmo.getBottom());
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector.2
 * JD-Core Version:    0.7.0.1
 */