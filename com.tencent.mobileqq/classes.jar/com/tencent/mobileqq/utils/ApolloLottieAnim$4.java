package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.lang.ref.WeakReference;

class ApolloLottieAnim$4
  implements Runnable
{
  ApolloLottieAnim$4(ApolloLottieAnim paramApolloLottieAnim) {}
  
  public void run()
  {
    if ((ApolloLottieAnim.b(this.this$0) != null) && (ApolloLottieAnim.b(this.this$0).get() != null)) {
      ((DiniFlyAnimationView)ApolloLottieAnim.b(this.this$0).get()).endAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.4
 * JD-Core Version:    0.7.0.1
 */