package com.tencent.mobileqq.splashad;

import com.tencent.qphone.base.util.QLog;

class SplashADView$1$1
  implements Runnable
{
  SplashADView$1$1(SplashADView.1 param1) {}
  
  public void run()
  {
    if (SplashADView.a(this.a.a) != null)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "mVideoPlayer is prepare");
      SplashADView.a(this.a.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView.1.1
 * JD-Core Version:    0.7.0.1
 */