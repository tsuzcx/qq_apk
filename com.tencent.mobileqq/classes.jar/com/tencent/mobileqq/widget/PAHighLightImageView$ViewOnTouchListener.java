package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

public class PAHighLightImageView$ViewOnTouchListener
  implements View.OnTouchListener
{
  PAHighLightImageView a;
  Context b;
  
  public PAHighLightImageView$ViewOnTouchListener(PAHighLightImageView paramPAHighLightImageView, Context paramContext)
  {
    this.a = paramPAHighLightImageView;
    this.b = paramContext;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onTouch is called,action is:");
      paramView.append(paramMotionEvent.getAction());
      QLog.d("PAHighLightImageView", 2, paramView.toString());
    }
    paramView = this.a.getTag(2131440836);
    if (paramView == null) {
      return false;
    }
    boolean bool;
    if (paramView.equals(Integer.valueOf(1)))
    {
      bool = true;
    }
    else
    {
      if (!paramView.equals(Integer.valueOf(2))) {
        break label129;
      }
      bool = false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.a(this.b, bool);
      return false;
    }
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      this.a.a();
    }
    label129:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAHighLightImageView.ViewOnTouchListener
 * JD-Core Version:    0.7.0.1
 */