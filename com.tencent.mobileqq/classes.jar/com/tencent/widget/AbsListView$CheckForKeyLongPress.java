package com.tencent.widget;

import android.view.View;
import bfog;

class AbsListView$CheckForKeyLongPress
  extends bfog
  implements Runnable
{
  private AbsListView$CheckForKeyLongPress(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    View localView;
    if ((this.this$0.isPressed()) && (this.this$0.mSelectedPosition >= 0))
    {
      int i = this.this$0.mSelectedPosition;
      int j = this.this$0.mFirstPosition;
      localView = this.this$0.getChildAt(i - j);
      if (this.this$0.mDataChanged) {
        break label108;
      }
      if (!a()) {
        break label128;
      }
    }
    label128:
    for (boolean bool = this.this$0.performLongPress(localView, this.this$0.mSelectedPosition, this.this$0.mSelectedRowId);; bool = false)
    {
      if (bool)
      {
        this.this$0.setPressed(false);
        localView.setPressed(false);
      }
      label108:
      do
      {
        return;
        this.this$0.setPressed(false);
      } while (localView == null);
      localView.setPressed(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.CheckForKeyLongPress
 * JD-Core Version:    0.7.0.1
 */