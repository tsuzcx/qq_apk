package com.tencent.mobileqq.vas.widget.lottie;

import java.lang.ref.WeakReference;

class LottieLoader$DecoderRunnable
  implements Runnable
{
  private boolean mAutoPlay;
  private String mLocalFilePath;
  private WeakReference<LottieLoader> mLottieAnimRef;
  private String mZipUrl;
  
  public void run()
  {
    if ((this.mLottieAnimRef != null) && (this.mLottieAnimRef.get() != null)) {
      LottieLoader.access$200((LottieLoader)this.mLottieAnimRef.get(), this.mZipUrl, this.mLocalFilePath, this.mAutoPlay);
    }
  }
  
  public void setZipData(LottieLoader paramLottieLoader, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mZipUrl = paramString1;
    this.mLocalFilePath = paramString2;
    this.mAutoPlay = paramBoolean;
    this.mLottieAnimRef = new WeakReference(paramLottieLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.widget.lottie.LottieLoader.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */