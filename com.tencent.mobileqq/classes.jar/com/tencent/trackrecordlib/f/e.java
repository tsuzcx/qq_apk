package com.tencent.trackrecordlib.f;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class e
  implements View.OnTouchListener
{
  private View.OnTouchListener a;
  private b.b b;
  
  public e(View.OnTouchListener paramOnTouchListener, b.b paramb)
  {
    this.a = paramOnTouchListener;
    this.b = paramb;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((b.b)localObject).a(paramView, paramMotionEvent);
    }
    localObject = this.a;
    return (localObject != null) && (((View.OnTouchListener)localObject).onTouch(paramView, paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.f.e
 * JD-Core Version:    0.7.0.1
 */