package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;
import bhpt;

class AbsListView$CheckForLongPress
  extends bhpt
  implements Runnable
{
  private AbsListView$CheckForLongPress(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    int i = this.this$0.mMotionPosition;
    View localView = this.this$0.getChildAt(i - this.this$0.mFirstPosition);
    long l;
    if (localView != null)
    {
      i = this.this$0.mMotionPosition;
      l = this.this$0.mAdapter.getItemId(this.this$0.mMotionPosition);
      if ((!a()) || (this.this$0.mDataChanged)) {
        break label126;
      }
    }
    label126:
    for (boolean bool = this.this$0.performLongPress(localView, i, l);; bool = false)
    {
      if (bool)
      {
        this.this$0.mTouchMode = -1;
        this.this$0.setPressed(false);
        localView.setPressed(false);
        return;
      }
      this.this$0.mTouchMode = 2;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */