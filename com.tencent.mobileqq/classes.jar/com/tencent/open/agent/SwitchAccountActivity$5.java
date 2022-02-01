package com.tencent.open.agent;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SwitchAccountActivity$5
  implements View.OnTouchListener
{
  View a;
  WeakReference<View> b;
  protected GestureDetector.SimpleOnGestureListener c = new SwitchAccountActivity.5.1(this);
  protected GestureDetector d = new GestureDetector(this.c);
  
  SwitchAccountActivity$5(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(i);
      QLog.i("AccountManage", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      this.a = paramView;
      if (SwitchAccountActivity.access$500(this.e)) {
        SwitchAccountActivity.access$502(this.e, false);
      }
    }
    this.d.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.5
 * JD-Core Version:    0.7.0.1
 */