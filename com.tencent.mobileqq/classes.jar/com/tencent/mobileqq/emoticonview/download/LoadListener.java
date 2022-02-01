package com.tencent.mobileqq.emoticonview.download;

import com.tencent.rlottie.AXrLottieDrawable;

public abstract interface LoadListener
{
  public abstract void onFail(Throwable paramThrowable);
  
  public abstract void onLottieResLoading(String paramString);
  
  public abstract void onSuccess(AXrLottieDrawable paramAXrLottieDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.LoadListener
 * JD-Core Version:    0.7.0.1
 */