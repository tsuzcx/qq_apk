package com.tencent.mobileqq.splashad;

import axnt;
import axnv;
import com.tencent.qphone.base.util.QLog;

public class SplashADView$1$1
  implements Runnable
{
  public SplashADView$1$1(axnt paramaxnt) {}
  
  public void run()
  {
    if (SplashADView.a(this.a.a) != null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "mVideoPlayer is prepare");
      SplashADView.a(this.a.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView.1.1
 * JD-Core Version:    0.7.0.1
 */