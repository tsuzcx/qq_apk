package com.tencent.mobileqq.structmsg.view;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class StructMsgItemLayout30$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  StructMsgItemLayout30$1(StructMsgItemLayout30 paramStructMsgItemLayout30, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    StructMsgItemLayout30.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout30.1
 * JD-Core Version:    0.7.0.1
 */