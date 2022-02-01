package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

class StickerGestureDetector$StickerAnimationListener
  implements Animator.AnimatorListener
{
  private StickerGestureDetector$StickerAnimationListener(StickerGestureDetector paramStickerGestureDetector) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.this$0.mBaseChatPie != null) && (this.this$0.mRootView != null))
    {
      this.this$0.mRootView.post(new StickerGestureDetector.StickerAnimationListener.1(this));
      this.this$0.removeStickerMaskLayout();
      this.this$0.mBaseChatPie.aS();
      this.this$0.scale = 1.0D;
      this.this$0.angle = 0.0D;
      if (this.this$0.lastIntersectView != null)
      {
        this.this$0.changeBubbleBg(this.this$0.lastIntersectView, false);
        this.this$0.currentChooseLayout = null;
      }
      if ((this.this$0.lastIntersectChatLayout != null) && ((this.this$0.lastIntersectChatLayout instanceof BaseChatItemLayout)))
      {
        ((BaseChatItemLayout)this.this$0.lastIntersectChatLayout).setStickerPressStatus(false);
        this.this$0.lastIntersectChatLayout = null;
      }
      com.tencent.mobileqq.emoticon.EmojiStickerManager.b = false;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector.StickerAnimationListener
 * JD-Core Version:    0.7.0.1
 */