package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

class PageSwitchObserver$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PageSwitchObserver$1(PageSwitchObserver paramPageSwitchObserver, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void onGlobalLayout()
  {
    PageSwitchObserver.access$200(this.this$0, (Activity)this.val$weakRefActivity.get());
    View localView = (View)this.val$weakRefView.get();
    if (localView != null) {
      localView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.1
 * JD-Core Version:    0.7.0.1
 */