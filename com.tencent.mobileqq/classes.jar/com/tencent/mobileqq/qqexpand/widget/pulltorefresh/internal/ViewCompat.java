package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public class ViewCompat
{
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ViewCompat.SDK16.a(paramView, paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ViewCompat.SDK16.a(paramView, paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.ViewCompat
 * JD-Core Version:    0.7.0.1
 */