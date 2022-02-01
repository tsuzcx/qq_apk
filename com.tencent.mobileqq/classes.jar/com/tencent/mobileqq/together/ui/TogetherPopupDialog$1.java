package com.tencent.mobileqq.together.ui;

import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.clockin.ClockInViewHelper;

class TogetherPopupDialog$1
  extends TogetherObserver
{
  TogetherPopupDialog$1(TogetherPopupDialog paramTogetherPopupDialog) {}
  
  protected void a()
  {
    if (this.a.h == null) {
      return;
    }
    if (this.a.h.c())
    {
      if (TogetherPopupDialog.a(this.a) != null) {
        TogetherPopupDialog.a(this.a).postDelayed(new TogetherPopupDialog.1.1(this), 5000L);
      }
    }
    else if ((this.a.c != null) && (this.a.g != null))
    {
      this.a.c.b();
      this.a.g.bringToFront();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.1
 * JD-Core Version:    0.7.0.1
 */