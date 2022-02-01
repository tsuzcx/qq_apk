package com.tencent.mobileqq.emoticonview.anisticker;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticonview.download.LoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;

final class AniStickerHelper$3
  implements LoadListener
{
  AniStickerHelper$3(AniStickerLottieView paramAniStickerLottieView, AniStickerInfo paramAniStickerInfo, int paramInt) {}
  
  public void onFail(Throwable paramThrowable)
  {
    QLog.e("AniStickerHelper", 2, paramThrowable, new Object[0]);
    if (AniStickerHelper.isChangeAniSticker(this.val$lottieView, this.val$stickerInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, " onFail lottieView is used.");
      }
      return;
    }
    paramThrowable = this.val$lottieView;
    paramThrowable.stickerLoadingDrawable = paramThrowable.getContext().getResources().getDrawable(this.val$resDrawable);
    this.val$lottieView.invalidate();
  }
  
  public void onLottieResLoading(String paramString)
  {
    if (AniStickerHelper.isChangeAniSticker(this.val$lottieView, this.val$stickerInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "onLottieResLoading lottieView is used.");
      }
      return;
    }
    Object localObject = this.val$lottieView;
    ((AniStickerLottieView)localObject).cacheKey = paramString;
    ((AniStickerLottieView)localObject).addToPendingActions((AniStickerLottieView)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lottie res downloading : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AniStickerHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (this.val$lottieView.stickerLoadingDrawable == null)
    {
      paramString = this.val$lottieView;
      paramString.stickerLoadingDrawable = paramString.getContext().getResources().getDrawable(this.val$resDrawable);
    }
    this.val$lottieView.invalidate();
  }
  
  public void onSuccess(AXrLottieDrawable paramAXrLottieDrawable)
  {
    if (AniStickerHelper.isChangeAniSticker(this.val$lottieView, this.val$stickerInfo)) {
      return;
    }
    long l = System.currentTimeMillis();
    if ((!this.val$lottieView.showLastFrame) && (this.val$lottieView.surpriseId == null))
    {
      paramAXrLottieDrawable.c(-1);
      paramAXrLottieDrawable.a(true);
    }
    else
    {
      paramAXrLottieDrawable.c(1);
    }
    this.val$lottieView.addPreAnimatorListener(paramAXrLottieDrawable);
    this.val$lottieView.playLottieAnimation(paramAXrLottieDrawable);
    if (QLog.isColorLevel())
    {
      paramAXrLottieDrawable = new StringBuilder();
      paramAXrLottieDrawable.append("lottie view playAnimation. cost: ");
      paramAXrLottieDrawable.append(System.currentTimeMillis() - l);
      QLog.d("AniStickerHelper", 2, paramAXrLottieDrawable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.3
 * JD-Core Version:    0.7.0.1
 */