package com.tencent.viola.ui.baseComponent;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VComponent$1
  implements View.OnTouchListener
{
  VComponent$1(VComponent paramVComponent) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    VComponent.access$000(this.this$0, paramView, paramMotionEvent);
    VComponent.access$100(this.this$0).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent.1
 * JD-Core Version:    0.7.0.1
 */