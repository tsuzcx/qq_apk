package com.tencent.rlottie;

import java.util.concurrent.ThreadPoolExecutor;

class AXrLottieDrawable$4
  implements Runnable
{
  AXrLottieDrawable$4(AXrLottieDrawable paramAXrLottieDrawable) {}
  
  public void run()
  {
    if ((!AXrLottieDrawable.c(this.this$0)) && (!AXrLottieDrawable.d(this.this$0)) && (AXrLottieDrawable.e(this.this$0) != 0L)) {
      AXrLottieDrawable.m().execute(AXrLottieDrawable.b(this.this$0, new AXrLottieDrawable.4.1(this)));
    }
    AXrLottieDrawable.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieDrawable.4
 * JD-Core Version:    0.7.0.1
 */