package com.tencent.mobileqq.forward;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class ForwardNewVersionDialog$2
  implements View.OnTouchListener
{
  ForwardNewVersionDialog$2(ForwardNewVersionDialog paramForwardNewVersionDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ForwardNewVersionDialog.a(this.a).setImageResource(2130840282);
    ForwardNewVersionDialog.a(this.a).setTag(Integer.valueOf(2130840282));
    if (ForwardNewVersionDialog.a(this.a))
    {
      ForwardNewVersionDialog.a(this.a);
      ForwardNewVersionDialog.a(this.a).removeView(ForwardNewVersionDialog.a(this.a));
      ForwardNewVersionDialog.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.2
 * JD-Core Version:    0.7.0.1
 */