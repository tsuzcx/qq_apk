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
      this.this$0.fireClickAction("click", paramMotionEvent);
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
        this.this$0.fireClickAction("doubleClick", paramMotionEvent);
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.this$0.fireClickAction("longPress", paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((this.this$0.mAppendEvents.contains("doubleClick")) && (SystemClock.uptimeMillis() - VComponent.access$500(this.this$0) > 500L)) {
      this.this$0.fireClickAction("click", paramMotionEvent);
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (!this.this$0.mAppendEvents.contains("doubleClick")) {
      this.this$0.fireClickAction("click", paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */