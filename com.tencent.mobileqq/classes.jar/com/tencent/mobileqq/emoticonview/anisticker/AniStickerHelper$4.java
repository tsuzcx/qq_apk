package com.tencent.mobileqq.emoticonview.anisticker;

import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticonview.download.LoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;

final class AniStickerHelper$4
  implements LoadListener
{
  AniStickerHelper$4(AniStickerLottieView paramAniStickerLottieView, AniStickerInfo paramAniStickerInfo) {}
  
  public void onFail(Throwable paramThrowable)
  {
    QLog.e("AniStickerHelper", 2, paramThrowable, new Object[0]);
    if ((AniStickerHelper.isChangeAniSticker(this.val$lottieView, this.val$stickerInfo)) && (QLog.isColorLevel())) {
      QLog.d("AniStickerHelper", 2, "sec onFail lottieView is used.");
    }
  }
  
  public void onLottieResLoading(String paramString)
  {
    if (AniStickerHelper.isChangeAniSticker(this.val$lottieView, this.val$stickerInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "sec onLottieResLoading lottieView is used.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sec lottie res downloading : ");
      localStringBuilder.append(paramString);
      QLog.d("AniStickerHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void onSuccess(AXrLottieDrawable paramAXrLottieDrawable)
  {
    if (AniStickerHelper.isChangeAniSticker(this.val$lottieView, this.val$stickerInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "sec onSuccess lottieView is used.");
      }
      return;
    }
    long l = System.currentTimeMillis();
    this.val$lottieView.setSecondLottieDrawable(this.val$stickerInfo, paramAXrLottieDrawable, 1);
    if (QLog.isColorLevel())
    {
      paramAXrLottieDrawable = new StringBuilder();
      paramAXrLottieDrawable.append("sec lottie view playAnimation. cost: ");
      paramAXrLottieDrawable.append(System.currentTimeMillis() - l);
      QLog.d("AniStickerHelper", 2, paramAXrLottieDrawable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.4
 * JD-Core Version:    0.7.0.1
 */