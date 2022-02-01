package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.qphone.base.util.QLog;

class CustomLottieView$4$1$1
  implements Runnable
{
  CustomLottieView$4$1$1(CustomLottieView.4.1 param1, LottieComposition paramLottieComposition) {}
  
  public void run()
  {
    try
    {
      this.b.a.this$0.setComposition(this.a);
      if (!this.b.a.this$0.isShown())
      {
        String str = CustomLottieView.a(this.b.a.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play CustomLottieView.this.isShown() ");
        localStringBuilder.append(this.b.a.this$0.isShown());
        QLog.i(str, 1, localStringBuilder.toString());
        str = CustomLottieView.a(this.b.a.this$0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play CustomLottieView.this.getParent() ");
        localStringBuilder.append(this.b.a.this$0.getParent());
        QLog.i(str, 1, localStringBuilder.toString());
        this.b.a.this$0.setVisibility(0);
        str = CustomLottieView.a(this.b.a.this$0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play after visible CustomLottieView.this.isShown() ");
        localStringBuilder.append(this.b.a.this$0.isShown());
        QLog.i(str, 1, localStringBuilder.toString());
        str = CustomLottieView.a(this.b.a.this$0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play CustomLottieView.this.getParent() ");
        localStringBuilder.append(this.b.a.this$0.getParent());
        QLog.i(str, 1, localStringBuilder.toString());
      }
      this.b.a.this$0.playAnimation();
      return;
    }
    catch (Exception localException)
    {
      Log.getStackTraceString(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.4.1.1
 * JD-Core Version:    0.7.0.1
 */