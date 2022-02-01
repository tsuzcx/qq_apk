package com.tencent.mobileqq.emoticonview.anisticker;

import com.tencent.rlottie.OnLottieFrameListener;

class AniStickerLottieView$3
  extends OnLottieFrameListener
{
  AniStickerLottieView$3(AniStickerLottieView paramAniStickerLottieView) {}
  
  public void onStartOnUi()
  {
    if (this.this$0.secRandomResultPlayListener != null) {
      this.this$0.secRandomResultPlayListener.onAnimationStart(this.this$0.localId, this.this$0.resutId);
    }
  }
  
  public void onStopOnUi(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AniStickerLottieView localAniStickerLottieView = this.this$0;
      localAniStickerLottieView.playFrameFinish = true;
      if (localAniStickerLottieView.secRandomResultPlayListener != null) {
        this.this$0.secRandomResultPlayListener.onAnimationEnd(this.this$0.localId, this.this$0.resutId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView.3
 * JD-Core Version:    0.7.0.1
 */