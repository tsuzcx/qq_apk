package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

import acju;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public class ViewCompat
{
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      acju.a(paramView, paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      acju.a(paramView, paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.ViewCompat
 * JD-Core Version:    0.7.0.1
 */