package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class DebugLayout
  extends FrameLayout
{
  public DebugLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.DebugLayout
 * JD-Core Version:    0.7.0.1
 */