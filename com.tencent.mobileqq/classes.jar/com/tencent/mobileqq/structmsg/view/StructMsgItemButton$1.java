package com.tencent.mobileqq.structmsg.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import java.lang.ref.WeakReference;

class StructMsgItemButton$1
  implements View.OnLongClickListener
{
  StructMsgItemButton$1(StructMsgItemButton paramStructMsgItemButton) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      OnLongClickAndTouchListener localOnLongClickAndTouchListener = (OnLongClickAndTouchListener)this.a.a.get();
      if (localOnLongClickAndTouchListener != null) {
        return localOnLongClickAndTouchListener.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton.1
 * JD-Core Version:    0.7.0.1
 */