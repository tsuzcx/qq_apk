package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;

@TargetApi(16)
class ViewCompat$SDK16
{
  public static void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.ViewCompat.SDK16
 * JD-Core Version:    0.7.0.1
 */