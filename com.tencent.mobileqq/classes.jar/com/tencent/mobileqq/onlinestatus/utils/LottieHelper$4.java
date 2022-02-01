package com.tencent.mobileqq.onlinestatus.utils;

final class LottieHelper$4
  implements Runnable
{
  LottieHelper$4(LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void run()
  {
    LottieHelper.LottieDrawableLoadedListener localLottieDrawableLoadedListener = this.a;
    if (localLottieDrawableLoadedListener != null) {
      localLottieDrawableLoadedListener.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper.4
 * JD-Core Version:    0.7.0.1
 */