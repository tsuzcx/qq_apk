package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

class PageSwitchObserver$2
  implements View.OnAttachStateChangeListener
{
  PageSwitchObserver$2(PageSwitchObserver paramPageSwitchObserver, WeakReference paramWeakReference, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    paramView = (View)this.val$weakRefView.get();
    if (paramView != null) {
      paramView.getViewTreeObserver().removeGlobalOnLayoutListener(this.val$onGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.2
 * JD-Core Version:    0.7.0.1
 */