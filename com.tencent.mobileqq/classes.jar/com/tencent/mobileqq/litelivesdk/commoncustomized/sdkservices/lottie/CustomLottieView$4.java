package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import java.io.InputStream;

class CustomLottieView$4
  implements Runnable
{
  CustomLottieView$4(CustomLottieView paramCustomLottieView) {}
  
  public void run()
  {
    InputStream localInputStream = CustomLottieView.a(CustomLottieView.b(this.this$0));
    if (localInputStream != null) {
      CustomLottieView.a(this.this$0, LottieComposition.Factory.fromInputStream(CustomLottieView.a(this.this$0), localInputStream, new CustomLottieView.4.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.4
 * JD-Core Version:    0.7.0.1
 */