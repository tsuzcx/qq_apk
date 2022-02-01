package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FloatingScreenPermission$3
  implements DialogInterface.OnClickListener
{
  FloatingScreenPermission$3(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission.3
 * JD-Core Version:    0.7.0.1
 */