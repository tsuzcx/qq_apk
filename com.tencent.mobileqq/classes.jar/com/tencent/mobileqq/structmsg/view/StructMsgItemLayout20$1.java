package com.tencent.mobileqq.structmsg.view;

import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.SingleLineTextView;

class StructMsgItemLayout20$1
  implements Runnable
{
  StructMsgItemLayout20$1(StructMsgItemLayout20 paramStructMsgItemLayout20, int paramInt, StructMsgItemLayout20.Holder paramHolder) {}
  
  public void run()
  {
    int i = this.a;
    int j = this.b.c.getWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.a.getLayoutParams();
    localLayoutParams.rightMargin = (i + j);
    this.b.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1
 * JD-Core Version:    0.7.0.1
 */