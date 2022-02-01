package com.tencent.mobileqq.vas.widget.lottie;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.lang.ref.WeakReference;

class LottieLoader$3
  implements Runnable
{
  LottieLoader$3(LottieLoader paramLottieLoader) {}
  
  public void run()
  {
    if ((LottieLoader.access$300(this.this$0) != null) && (LottieLoader.access$300(this.this$0).get() != null)) {
      ((DiniFlyAnimationView)LottieLoader.access$300(this.this$0).get()).endAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.widget.lottie.LottieLoader.3
 * JD-Core Version:    0.7.0.1
 */