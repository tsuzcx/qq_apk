package com.tencent.viola.ui.baseComponent;

import android.os.SystemClock;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.util.Set;

class VComponent$MyGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  VComponent$MyGestureListener(VComponent paramVComponent) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.this$0.mAppendEvents.contains("doubleClick")) {
      VComponent.access$600(this.this$0, "click", paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (this.this$0.mAppendEvents.contains("doubleClick"))
      {
        VComponent.access$502(this.this$0, SystemClock.uptimeMillis());
        VComponent.access$600(this.this$0, "doubleClick", paramMotionEvent);
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    VComponent.access$600(this.this$0, "longPress", paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((this.this$0.mAppendEvents.contains("doubleClick")) && (SystemClock.uptimeMillis() - VComponent.access$500(this.this$0) > 500L)) {
      VComponent.access$600(this.this$0, "click", paramMotionEvent);
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (!this.this$0.mAppendEvents.contains("doubleClick")) {
      VComponent.access$600(this.this$0, "click", paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */