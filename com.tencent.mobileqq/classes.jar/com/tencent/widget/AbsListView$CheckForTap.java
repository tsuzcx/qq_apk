package com.tencent.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

final class AbsListView$CheckForTap
  implements Runnable
{
  AbsListView$CheckForTap(AbsListView paramAbsListView) {}
  
  public void run()
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.this$0.mTouchMode == 0)
    {
      this.this$0.mTouchMode = 1;
      localObject = this.this$0.getChildAt(this.this$0.mMotionPosition - this.this$0.mFirstPosition);
      if ((localObject != null) && (!((View)localObject).hasFocusable()))
      {
        this.this$0.mLayoutMode = 0;
        if (this.this$0.mDataChanged) {
          break label249;
        }
        ((View)localObject).setPressed(true);
        this.this$0.setPressed(true);
        this.this$0.layoutChildren();
        this.this$0.positionSelector(this.this$0.mMotionPosition, (View)localObject);
        this.this$0.refreshDrawableState();
        i = ViewConfiguration.getLongPressTimeout();
        bool = this.this$0.isLongClickable();
        if (this.this$0.mSelector != null)
        {
          localObject = this.this$0.mSelector.getCurrent();
          if ((localObject != null) && ((localObject instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label230;
            }
            ((TransitionDrawable)localObject).startTransition(i);
          }
        }
      }
    }
    while (bool)
    {
      if (AbsListView.access$700(this.this$0) == null) {
        AbsListView.access$702(this.this$0, new AbsListView.CheckForLongPress(this.this$0, null));
      }
      AbsListView.access$700(this.this$0).a();
      this.this$0.postDelayed(AbsListView.access$700(this.this$0), i);
      return;
      label230:
      ((TransitionDrawable)localObject).resetTransition();
    }
    this.this$0.mTouchMode = 2;
    return;
    label249:
    this.this$0.mTouchMode = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.CheckForTap
 * JD-Core Version:    0.7.0.1
 */