package com.tencent.mtt.hippy.views.hippylist;

import android.view.ViewTreeObserver.OnPreDrawListener;

class RecyclerViewEventHelper$1
  implements ViewTreeObserver.OnPreDrawListener
{
  RecyclerViewEventHelper$1(RecyclerViewEventHelper paramRecyclerViewEventHelper) {}
  
  public boolean onPreDraw()
  {
    this.this$0.notifyInitialListReady();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper.1
 * JD-Core Version:    0.7.0.1
 */