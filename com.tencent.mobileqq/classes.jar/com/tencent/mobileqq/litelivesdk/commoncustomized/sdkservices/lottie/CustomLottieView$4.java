package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import java.io.InputStream;

class CustomLottieView$4
  implements Runnable
{
  CustomLottieView$4(CustomLottieView paramCustomLottieView) {}
  
  public void run()
  {
    InputStream localInputStream = CustomLottieView.a(CustomLottieView.d(this.this$0));
    if (localInputStream != null)
    {
      CustomLottieView localCustomLottieView = this.this$0;
      CustomLottieView.a(localCustomLottieView, LottieComposition.Factory.fromInputStream(CustomLottieView.e(localCustomLottieView), localInputStream, new CustomLottieView.4.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.4
 * JD-Core Version:    0.7.0.1
 */