package com.tencent.mobileqq.emoticonview.download;

import com.tencent.rlottie.AXrLottieDrawable;

class BaseLottieResDownloader$1
  implements Runnable
{
  BaseLottieResDownloader$1(BaseLottieResDownloader paramBaseLottieResDownloader, LoadListener paramLoadListener, AXrLottieDrawable paramAXrLottieDrawable) {}
  
  public void run()
  {
    this.val$listener.onSuccess(this.val$drawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader.1
 * JD-Core Version:    0.7.0.1
 */