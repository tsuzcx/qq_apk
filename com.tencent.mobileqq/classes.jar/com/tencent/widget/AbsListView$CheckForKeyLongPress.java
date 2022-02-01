package com.tencent.widget;

import android.view.View;

class AbsListView$CheckForKeyLongPress
  extends AbsListView.WindowRunnnable
  implements Runnable
{
  private AbsListView$CheckForKeyLongPress(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    if ((this.this$0.isPressed()) && (this.this$0.mSelectedPosition >= 0))
    {
      int i = this.this$0.mSelectedPosition;
      int j = this.this$0.mFirstPosition;
      View localView = this.this$0.getChildAt(i - j);
      if (!this.this$0.mDataChanged)
      {
        boolean bool;
        if (sameWindow())
        {
          AbsListView localAbsListView = this.this$0;
          bool = localAbsListView.performLongPress(localView, localAbsListView.mSelectedPosition, this.this$0.mSelectedRowId);
        }
        else
        {
          bool = false;
        }
        if (bool)
        {
          this.this$0.setPressed(false);
          localView.setPressed(false);
        }
      }
      else
      {
        this.this$0.setPressed(false);
        if (localView != null) {
          localView.setPressed(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.CheckForKeyLongPress
 * JD-Core Version:    0.7.0.1
 */