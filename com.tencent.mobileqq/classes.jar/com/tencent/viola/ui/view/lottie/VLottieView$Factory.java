package com.tencent.viola.ui.view.lottie;

import android.content.Context;

public class VLottieView$Factory
{
  private static IVlottieViewCreater vlottieViewCreater;
  
  public static IVLottieViewProxy createVLottieView(Context paramContext)
  {
    IVlottieViewCreater localIVlottieViewCreater = vlottieViewCreater;
    if (localIVlottieViewCreater != null) {
      return localIVlottieViewCreater.createLottieView(paramContext);
    }
    return null;
  }
  
  public static void setVLottieViewCreater(IVlottieViewCreater paramIVlottieViewCreater)
  {
    vlottieViewCreater = paramIVlottieViewCreater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.lottie.VLottieView.Factory
 * JD-Core Version:    0.7.0.1
 */