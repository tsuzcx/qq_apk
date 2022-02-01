package com.tencent.mobileqq.tianshu.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class RedTouch$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  RedTouch$1(RedTouch paramRedTouch, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.b.O.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    RedTouch.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.ui.RedTouch.1
 * JD-Core Version:    0.7.0.1
 */