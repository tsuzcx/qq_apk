package com.tencent.mobileqq.forward;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;

class ForwardNewVersionDialog$2
  implements View.OnTouchListener
{
  ForwardNewVersionDialog$2(ForwardNewVersionDialog paramForwardNewVersionDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ForwardNewVersionDialog.c(this.a).setImageResource(2130840446);
    ForwardNewVersionDialog.c(this.a).setTag(Integer.valueOf(2130840446));
    if (ForwardNewVersionDialog.d(this.a))
    {
      ForwardNewVersionDialog.e(this.a);
      ForwardNewVersionDialog.g(this.a).removeView(ForwardNewVersionDialog.f(this.a).getView());
      ForwardNewVersionDialog.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.2
 * JD-Core Version:    0.7.0.1
 */