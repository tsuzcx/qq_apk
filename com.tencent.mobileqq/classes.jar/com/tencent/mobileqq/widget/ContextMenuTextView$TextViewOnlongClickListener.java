package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow;

class ContextMenuTextView$TextViewOnlongClickListener
  implements View.OnLongClickListener, View.OnTouchListener
{
  private PointF b = new PointF();
  
  private ContextMenuTextView$TextViewOnlongClickListener(ContextMenuTextView paramContextMenuTextView) {}
  
  protected void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.a.setBackgroundColor(-1);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.a.setBackgroundColor(-7829368);
    if ((this.a.a != null) && (this.a.a.isShowing()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131431492, ContextMenuTextView.a(this.a).getString(2131888244), 2130839057);
    this.a.a = BubbleContextMenu.a(paramView, (int)this.b.x, (int)this.b.y, localQQCustomMenu, this.a.c, null);
    if (this.a.a != null) {
      this.a.a.setOnDismissListener(new ContextMenuTextView.DissmissListener(this.a));
    }
    a(paramView);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.b.x = paramMotionEvent.getRawX();
      this.b.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContextMenuTextView.TextViewOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */