package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;

class HorizontalListView$CheckForLongPress
  extends HorizontalListView.WindowRunnnable
  implements Runnable
{
  private HorizontalListView$CheckForLongPress(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.this$0.needTtransTouchStateToParen()) {
      bool1 = ((View)this.this$0.getParent()).performLongClick();
    }
    while (bool1)
    {
      this.this$0.mTouchMode = -1;
      HorizontalListView.access$100(this.this$0);
      return;
      int i = HorizontalListView.access$500(this.this$0);
      View localView = this.this$0.getChildAt(i - this.this$0.getFirstVisiblePosition());
      bool1 = bool2;
      if (localView != null)
      {
        i = HorizontalListView.access$500(this.this$0);
        long l = this.this$0.mAdapter.getItemId(HorizontalListView.access$500(this.this$0));
        bool1 = bool2;
        if (sameWindow())
        {
          bool1 = bool2;
          if (!this.this$0.mDataChanged) {
            bool1 = this.this$0.performLongPress(localView, i, l);
          }
        }
      }
    }
    this.this$0.mTouchMode = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */