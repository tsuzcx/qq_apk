package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;

class AbsListView$CheckForLongPress
  extends AbsListView.WindowRunnnable
  implements Runnable
{
  private AbsListView$CheckForLongPress(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    int i = this.this$0.mMotionPosition;
    Object localObject = this.this$0;
    localObject = ((AbsListView)localObject).getChildAt(i - ((AbsListView)localObject).mFirstPosition);
    if (localObject != null)
    {
      i = this.this$0.mMotionPosition;
      long l = this.this$0.mAdapter.getItemId(this.this$0.mMotionPosition);
      boolean bool;
      if ((sameWindow()) && (!this.this$0.mDataChanged)) {
        bool = this.this$0.performLongPress((View)localObject, i, l);
      } else {
        bool = false;
      }
      if (bool)
      {
        AbsListView localAbsListView = this.this$0;
        localAbsListView.mTouchMode = -1;
        localAbsListView.setPressed(false);
        ((View)localObject).setPressed(false);
        return;
      }
      this.this$0.mTouchMode = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AbsListView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */