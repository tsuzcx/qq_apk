package com.tencent.open.agent;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SwitchAccountActivity$5$1
  extends GestureDetector.SimpleOnGestureListener
{
  SwitchAccountActivity$5$1(SwitchAccountActivity.5 param5) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!SwitchAccountActivity.access$500(this.a.e)))
    {
      SwitchAccountActivity.access$502(this.a.e, true);
      if (this.a.a != null) {
        this.a.a.setPressed(false);
      }
      if ((paramFloat1 < -20.0F) && (this.a.b != null))
      {
        paramMotionEvent1 = (View)this.a.b.get();
        if (paramMotionEvent1 != null)
        {
          paramMotionEvent1 = paramMotionEvent1.findViewById(2131445741);
          if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
            ((ShaderAnimLayout)paramMotionEvent1).e();
          }
        }
        this.a.b = null;
      }
      if (paramFloat1 > 20.0F)
      {
        if ((this.a.b != null) && (this.a.b.get() != null))
        {
          paramMotionEvent1 = (View)this.a.b.get();
          if (paramMotionEvent1 != this.a.a)
          {
            paramMotionEvent1 = paramMotionEvent1.findViewById(2131445741);
            if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
              ((ShaderAnimLayout)paramMotionEvent1).e();
            }
          }
          this.a.b = null;
          return true;
        }
        if (this.a.a != null)
        {
          paramMotionEvent1 = this.a.a.findViewById(2131445741);
          if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("AccountManage", 2, "show current selectedAccountView");
            }
            ((ShaderAnimLayout)paramMotionEvent1).a();
            paramMotionEvent1 = this.a;
            paramMotionEvent1.b = new WeakReference(paramMotionEvent1.a);
            this.a.a = null;
          }
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.5.1
 * JD-Core Version:    0.7.0.1
 */