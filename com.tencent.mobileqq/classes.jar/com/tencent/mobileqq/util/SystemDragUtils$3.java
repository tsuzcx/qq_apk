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
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        SystemDragUtils.b(false);
        SystemDragUtils.a = f1;
        SystemDragUtils.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = SystemDragUtils.TouchHandler.a;
        paramMotionEvent.obj = paramView;
        SystemDragUtils.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((SystemDragUtils.a()) || ((Math.abs(SystemDragUtils.a - f1) <= 20.0F) && (Math.abs(SystemDragUtils.b - f2) <= 20.0F)));
      SystemDragUtils.b(true);
      SystemDragUtils.a().removeMessages(SystemDragUtils.TouchHandler.a);
      return false;
    }
    SystemDragUtils.a().removeMessages(SystemDragUtils.TouchHandler.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.3
 * JD-Core Version:    0.7.0.1
 */