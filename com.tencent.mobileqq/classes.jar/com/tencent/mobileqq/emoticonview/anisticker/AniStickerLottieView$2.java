package com.tencent.mobileqq.emoticonview.anisticker;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.rlottie.OnLottieFrameListener;
import java.util.concurrent.ConcurrentHashMap;

class AniStickerLottieView$2
  extends OnLottieFrameListener
{
  AniStickerLottieView$2(AniStickerLottieView paramAniStickerLottieView, AXrLottieDrawable paramAXrLottieDrawable) {}
  
  public void onRepeatOnUi(int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.this$0.surpriseId)) {
      return;
    }
    if ((this.this$0.randomKey != null) && (AniStickerLottieView.access$000().containsKey(this.this$0.randomKey)) && (AniStickerLottieView.access$100(this.this$0) != null))
    {
      this.val$lottieDrawable.stop();
      AniStickerLottieView.access$000().remove(this.this$0.randomKey);
      AniStickerLottieView localAniStickerLottieView = this.this$0;
      AniStickerLottieView.access$200(localAniStickerLottieView, AniStickerLottieView.access$100(localAniStickerLottieView));
      localAniStickerLottieView = this.this$0;
      localAniStickerLottieView.playLottieAnimation(AniStickerLottieView.access$100(localAniStickerLottieView));
    }
  }
  
  public void onStartOnUi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AniStickerLottieView", 2, "def onAnimationStart. ");
    }
    if (this.this$0.defRandomResultPlayListener != null) {
      this.this$0.defRandomResultPlayListener.onAnimationStart(this.this$0.localId, this.this$0.resutId);
    }
  }
  
  public void onStopOnUi(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AniStickerLottieView", 2, "def onAnimationEnd. ");
    }
    if (this.this$0.defRandomResultPlayListener != null) {
      this.this$0.defRandomResultPlayListener.onAnimationEnd(this.this$0.localId, this.this$0.resutId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView.2
 * JD-Core Version:    0.7.0.1
 */