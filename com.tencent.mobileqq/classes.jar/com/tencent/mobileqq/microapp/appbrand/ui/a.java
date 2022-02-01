package com.tencent.mobileqq.microapp.appbrand.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import bcnn;
import com.tencent.mobileqq.microapp.app.b;

final class a
  implements bcnn
{
  a(AppBrandUI paramAppBrandUI) {}
  
  public void onSoftKeyboardClosed()
  {
    b.a().a("hideInput");
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    paramInt = (int)(paramInt / localDisplayMetrics.density);
    b.a().a(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */