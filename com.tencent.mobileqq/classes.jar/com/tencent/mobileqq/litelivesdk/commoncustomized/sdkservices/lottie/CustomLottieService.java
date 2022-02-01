package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.content.Context;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieServiceInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

public class CustomLottieService
  implements LottieServiceInterface
{
  private LottieViewInterface a;
  
  public void clearEventOutput() {}
  
  public LottieViewInterface getLottieView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    if (this.a == null) {
      this.a = new CustomLottieView(paramContext, paramLuxuryGiftAdapter);
    }
    return this.a;
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieService
 * JD-Core Version:    0.7.0.1
 */