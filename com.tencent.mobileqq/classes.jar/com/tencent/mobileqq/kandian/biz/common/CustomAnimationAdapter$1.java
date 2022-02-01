package com.tencent.mobileqq.kandian.biz.common;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class CustomAnimationAdapter$1
  implements ViewTreeObserver.OnPreDrawListener
{
  CustomAnimationAdapter$1(CustomAnimationAdapter paramCustomAnimationAdapter, View paramView) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    CustomAnimationAdapter.a(this.b, this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.CustomAnimationAdapter.1
 * JD-Core Version:    0.7.0.1
 */