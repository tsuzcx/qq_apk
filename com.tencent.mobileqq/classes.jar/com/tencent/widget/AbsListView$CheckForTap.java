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
    if (this.this$0.mTouchMode == 0)
    {
      Object localObject = this.this$0;
      ((AbsListView)localObject).mTouchMode = 1;
      localObject = ((AbsListView)localObject).getChildAt(((AbsListView)localObject).mMotionPosition - this.this$0.mFirstPosition);
      if ((localObject != null) && (!((View)localObject).hasFocusable()))
      {
        AbsListView localAbsListView = this.this$0;
        localAbsListView.mLayoutMode = 0;
        if (!localAbsListView.mDataChanged)
        {
          ((View)localObject).setPressed(true);
          this.this$0.setPressed(true);
          this.this$0.layoutChildren();
          localAbsListView = this.this$0;
          localAbsListView.positionSelector(localAbsListView.mMotionPosition, (View)localObject);
          this.this$0.refreshDrawableState();
          int i = ViewConfiguration.getLongPressTimeout();
          boolean bool = this.this$0.isLongClickable();
          if (this.this$0.mSelector != null)
          {
            localObject = this.this$0.mSelector.getCurrent();
            if ((localObject != null) && ((localObject instanceof TransitionDrawable))) {
              if (bool) {
                ((TransitionDrawable)localObject).startTransition(i);
              } else {
                ((TransitionDrawable)localObject).resetTransition();
              }
            }
          }
          if (bool)
          {
            if (AbsListView.access$700(this.this$0) == null)
            {
              localObject = this.this$0;
              AbsListView.access$702((AbsListView)localObject, new AbsListView.CheckForLongPress((AbsListView)localObject, null));
            }
            AbsListView.access$700(this.this$0).rememberWindowAttachCount();
            localObject = this.this$0;
            ((AbsListView)localObject).postDelayed(AbsListView.access$700((AbsListView)localObject), i);
            return;
          }
          this.this$0.mTouchMode = 2;
          return;
        }
        this.this$0.mTouchMode = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.CheckForTap
 * JD-Core Version:    0.7.0.1
 */