package com.tencent.qqmini.sdk.runtime;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class AppUIProxy$DebugLayout
  extends FrameLayout
{
  public AppUIProxy$DebugLayout(AppUIProxy paramAppUIProxy, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.DebugLayout
 * JD-Core Version:    0.7.0.1
 */