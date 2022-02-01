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
    boolean bool;
    Object localObject;
    if (this.this$0.needTtransTouchStateToParen())
    {
      bool = ((View)this.this$0.getParent()).performLongClick();
    }
    else
    {
      int i = HorizontalListView.access$500(this.this$0);
      localObject = this.this$0;
      localObject = ((HorizontalListView)localObject).getChildAt(i - ((HorizontalListView)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        i = HorizontalListView.access$500(this.this$0);
        long l = this.this$0.mAdapter.getItemId(HorizontalListView.access$500(this.this$0));
        if ((sameWindow()) && (!this.this$0.mDataChanged))
        {
          bool = this.this$0.performLongPress((View)localObject, i, l);
          break label122;
        }
      }
      bool = false;
    }
    label122:
    if (bool)
    {
      localObject = this.this$0;
      ((HorizontalListView)localObject).mTouchMode = -1;
      HorizontalListView.access$100((HorizontalListView)localObject);
      return;
    }
    this.this$0.mTouchMode = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */