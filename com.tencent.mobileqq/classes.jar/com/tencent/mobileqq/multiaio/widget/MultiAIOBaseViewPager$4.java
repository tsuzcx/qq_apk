package com.tencent.mobileqq.multiaio.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class MultiAIOBaseViewPager$4
  implements OnApplyWindowInsetsListener
{
  private final Rect b = new Rect();
  
  MultiAIOBaseViewPager$4(MultiAIOBaseViewPager paramMultiAIOBaseViewPager) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramView = ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
    if (paramView.isConsumed()) {
      return paramView;
    }
    paramWindowInsetsCompat = this.b;
    paramWindowInsetsCompat.left = paramView.getSystemWindowInsetLeft();
    paramWindowInsetsCompat.top = paramView.getSystemWindowInsetTop();
    paramWindowInsetsCompat.right = paramView.getSystemWindowInsetRight();
    paramWindowInsetsCompat.bottom = paramView.getSystemWindowInsetBottom();
    int i = 0;
    int j = this.a.getChildCount();
    while (i < j)
    {
      WindowInsetsCompat localWindowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(this.a.getChildAt(i), paramView);
      paramWindowInsetsCompat.left = Math.min(localWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.left);
      paramWindowInsetsCompat.top = Math.min(localWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.top);
      paramWindowInsetsCompat.right = Math.min(localWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.right);
      paramWindowInsetsCompat.bottom = Math.min(localWindowInsetsCompat.getSystemWindowInsetBottom(), paramWindowInsetsCompat.bottom);
      i += 1;
    }
    return paramView.replaceSystemWindowInsets(paramWindowInsetsCompat.left, paramWindowInsetsCompat.top, paramWindowInsetsCompat.right, paramWindowInsetsCompat.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.4
 * JD-Core Version:    0.7.0.1
 */