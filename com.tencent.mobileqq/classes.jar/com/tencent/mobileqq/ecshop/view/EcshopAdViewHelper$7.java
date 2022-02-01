package com.tencent.mobileqq.ecshop.view;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class EcshopAdViewHelper$7
  implements PopupWindow.OnDismissListener
{
  EcshopAdViewHelper$7(EcshopAdViewHelper paramEcshopAdViewHelper, Context paramContext) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.7
 * JD-Core Version:    0.7.0.1
 */