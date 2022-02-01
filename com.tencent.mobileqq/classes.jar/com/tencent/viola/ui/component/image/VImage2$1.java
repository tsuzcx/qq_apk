package com.tencent.viola.ui.component.image;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class VImage2$1
  implements ViewTreeObserver.OnPreDrawListener
{
  VImage2$1(VImage2 paramVImage2, View paramView, boolean paramBoolean, String paramString) {}
  
  public boolean onPreDraw()
  {
    this.val$v.getViewTreeObserver().removeOnPreDrawListener(this);
    int k = this.val$v.getWidth();
    int m = this.val$v.getHeight();
    int j;
    int i;
    if (k != 0)
    {
      j = k;
      i = m;
      if (m != 0) {}
    }
    else
    {
      ViewGroup.LayoutParams localLayoutParams = this.val$v.getLayoutParams();
      j = k;
      i = m;
      if (localLayoutParams != null)
      {
        j = localLayoutParams.width;
        i = localLayoutParams.height;
      }
    }
    VImage2.access$000(this.this$0, j, i, this.val$isPlaceHolder, this.val$url);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2.1
 * JD-Core Version:    0.7.0.1
 */