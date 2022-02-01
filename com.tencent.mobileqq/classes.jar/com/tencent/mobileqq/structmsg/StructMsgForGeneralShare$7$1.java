package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class StructMsgForGeneralShare$7$1
  implements PopupWindow.OnDismissListener
{
  StructMsgForGeneralShare$7$1(StructMsgForGeneralShare.7 param7) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.a).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.a).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.7.1
 * JD-Core Version:    0.7.0.1
 */