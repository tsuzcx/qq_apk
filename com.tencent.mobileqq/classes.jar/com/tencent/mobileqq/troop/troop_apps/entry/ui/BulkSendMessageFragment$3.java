package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.widget.ClearableEditText;

class BulkSendMessageFragment$3
  implements View.OnTouchListener
{
  BulkSendMessageFragment$3(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.a.a.canScrollVertically(-1);
    boolean bool2 = this.a.a.canScrollVertically(1);
    if ((paramView.isFocused()) && ((bool1) || (bool2)))
    {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      if ((paramMotionEvent.getAction() & 0xFF) != 1) {
        return false;
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment.3
 * JD-Core Version:    0.7.0.1
 */