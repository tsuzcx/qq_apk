package com.tencent.mobileqq.structmsg.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import java.lang.ref.WeakReference;

class StructMsgItemButton$2
  implements View.OnTouchListener
{
  StructMsgItemButton$2(StructMsgItemButton paramStructMsgItemButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      OnLongClickAndTouchListener localOnLongClickAndTouchListener = (OnLongClickAndTouchListener)this.a.a.get();
      if (localOnLongClickAndTouchListener != null) {
        return localOnLongClickAndTouchListener.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton.2
 * JD-Core Version:    0.7.0.1
 */