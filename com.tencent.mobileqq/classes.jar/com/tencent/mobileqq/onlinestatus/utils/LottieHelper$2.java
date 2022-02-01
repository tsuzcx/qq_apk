package com.tencent.mobileqq.onlinestatus.utils;

final class LottieHelper$2
  implements Runnable
{
  LottieHelper$2(LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void run()
  {
    LottieHelper.LottieDrawableLoadedListener localLottieDrawableLoadedListener = this.a;
    if (localLottieDrawableLoadedListener != null) {
      localLottieDrawableLoadedListener.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper.2
 * JD-Core Version:    0.7.0.1
 */