package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.content.Context;
import com.tencent.falco.base.libapi.lottie.LottieAnimationViewInterface;
import com.tencent.falco.base.libapi.lottie.LottieCompositionInterface;
import com.tencent.falco.base.libapi.lottie.LottieServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieViewInterface;

public class CustomLottieService
  implements LottieServiceInterface
{
  private LottieViewInterface a;
  
  public LottieAnimationViewInterface a(Context paramContext)
  {
    return null;
  }
  
  public LottieCompositionInterface a()
  {
    return null;
  }
  
  public LottieViewInterface a(Context paramContext)
  {
    if (this.a == null) {
      this.a = new CustomLottieView(paramContext);
    }
    return this.a;
  }
  
  public void clearEventOutput() {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieService
 * JD-Core Version:    0.7.0.1
 */