package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class PageSwitchObserver$2
  implements View.OnAttachStateChangeListener
{
  PageSwitchObserver$2(PageSwitchObserver paramPageSwitchObserver, View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this.val$onGlobalLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.2
 * JD-Core Version:    0.7.0.1
 */