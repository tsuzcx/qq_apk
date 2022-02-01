package com.tencent.mobileqq.screendetect;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class ScreenShotFragment$3
  implements OnApplyWindowInsetsListener
{
  ScreenShotFragment$3(ScreenShotFragment paramScreenShotFragment) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onApplyWindowInsets current is liuhai style!");
    }
    ScreenShotFragment.c(this.a);
    return ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.3
 * JD-Core Version:    0.7.0.1
 */