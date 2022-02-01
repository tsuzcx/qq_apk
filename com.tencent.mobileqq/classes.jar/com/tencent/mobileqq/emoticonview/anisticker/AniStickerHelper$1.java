package com.tencent.mobileqq.emoticonview.anisticker;

import com.tencent.mobileqq.app.ThreadManagerV2;

final class AniStickerHelper$1
  implements Runnable
{
  AniStickerHelper$1(AniStickerHelper.Builder paramBuilder) {}
  
  public void run()
  {
    AniStickerLottieView localAniStickerLottieView = this.val$builder.lottieView;
    int i = this.val$builder.placeholderDrawable;
    if (this.val$builder.showLoading) {
      AniStickerHelper.access$000(localAniStickerLottieView, this.val$builder.svgLocalPath, i);
    }
    localAniStickerLottieView.postInvalidate();
    ThreadManagerV2.excute(new AniStickerHelper.1.1(this), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.1
 * JD-Core Version:    0.7.0.1
 */