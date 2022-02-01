package com.tencent.rlottie;

import android.os.Handler;

class AXrLottieDrawable$4$1
  implements Runnable
{
  AXrLottieDrawable$4$1(AXrLottieDrawable.4 param4) {}
  
  public void run()
  {
    if (AXrLottieDrawable.f(this.a.this$0) == null) {
      return;
    }
    AXrLottieNative.createCache(AXrLottieDrawable.e(this.a.this$0), AXrLottieDrawable.g(this.a.this$0), AXrLottieDrawable.h(this.a.this$0));
    AXrLottieDrawable.l().post(AXrLottieDrawable.i(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieDrawable.4.1
 * JD-Core Version:    0.7.0.1
 */