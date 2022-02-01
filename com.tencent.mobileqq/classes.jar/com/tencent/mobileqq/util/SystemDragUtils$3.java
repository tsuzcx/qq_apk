package com.tencent.mobileqq.util;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class SystemDragUtils$3
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        if (SystemDragUtils.c()) {
          return false;
        }
        if ((Math.abs(SystemDragUtils.a - f1) > 20.0F) || (Math.abs(SystemDragUtils.b - f2) > 20.0F))
        {
          SystemDragUtils.b(true);
          SystemDragUtils.b().removeMessages(SystemDragUtils.TouchHandler.a);
          return false;
        }
      }
      else
      {
        SystemDragUtils.b().removeMessages(SystemDragUtils.TouchHandler.a);
        return false;
      }
    }
    else
    {
      SystemDragUtils.b(false);
      SystemDragUtils.a = f1;
      SystemDragUtils.b = f2;
      paramMotionEvent = Message.obtain();
      paramMotionEvent.what = SystemDragUtils.TouchHandler.a;
      paramMotionEvent.obj = paramView;
      SystemDragUtils.b().sendMessageDelayed(paramMotionEvent, 1000L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.3
 * JD-Core Version:    0.7.0.1
 */