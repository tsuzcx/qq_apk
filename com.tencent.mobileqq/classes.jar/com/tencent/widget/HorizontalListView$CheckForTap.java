package com.tencent.widget;

import android.view.View;
import android.view.ViewConfiguration;

final class HorizontalListView$CheckForTap
  implements Runnable
{
  HorizontalListView$CheckForTap(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    if (this.this$0.mTouchMode == 0)
    {
      Object localObject = this.this$0;
      ((HorizontalListView)localObject).mTouchMode = 1;
      if (((HorizontalListView)localObject).needTtransTouchStateToParen())
      {
        localObject = (View)this.this$0.getParent();
      }
      else
      {
        localObject = this.this$0;
        localObject = ((HorizontalListView)localObject).getChildAt(HorizontalListView.access$500((HorizontalListView)localObject) - this.this$0.getFirstVisiblePosition());
      }
      if ((this.this$0.needTtransTouchStateToParen()) || ((localObject != null) && (!((View)localObject).hasFocusable())))
      {
        if ((this.this$0.mDataChanged) && (!this.this$0.needTtransTouchStateToParen()))
        {
          this.this$0.mTouchMode = 2;
          return;
        }
        HorizontalListView.access$600(this.this$0, (View)localObject);
        int i = ViewConfiguration.getLongPressTimeout();
        boolean bool;
        if (this.this$0.needTtransTouchStateToParen()) {
          bool = ((View)localObject).isLongClickable();
        } else {
          bool = this.this$0.isLongClickable();
        }
        if (bool)
        {
          if (HorizontalListView.access$700(this.this$0) == null)
          {
            localObject = this.this$0;
            HorizontalListView.access$702((HorizontalListView)localObject, new HorizontalListView.CheckForLongPress((HorizontalListView)localObject, null));
          }
          HorizontalListView.access$700(this.this$0).rememberWindowAttachCount();
          localObject = this.this$0;
          ((HorizontalListView)localObject).postDelayed(HorizontalListView.access$700((HorizontalListView)localObject), i);
          return;
        }
        this.this$0.mTouchMode = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.CheckForTap
 * JD-Core Version:    0.7.0.1
 */