package com.tencent.mobileqq.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;

class QQCustomDialogWtihEmoticonInput$2
  implements View.OnTouchListener
{
  QQCustomDialogWtihEmoticonInput$2(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.p.setImageResource(2130840446);
    this.a.p.setTag(Integer.valueOf(2130840446));
    if (this.a.w)
    {
      QQCustomDialogWtihEmoticonInput.b(this.a);
      if (this.a.m) {
        this.a.u.removeView(this.a.r.getView());
      } else {
        this.a.u.removeView(this.a.q);
      }
      paramView = this.a;
      paramView.w = false;
      paramView = paramView.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.2
 * JD-Core Version:    0.7.0.1
 */