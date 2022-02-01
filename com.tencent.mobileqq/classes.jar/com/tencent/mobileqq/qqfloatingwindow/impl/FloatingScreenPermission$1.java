package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;

final class FloatingScreenPermission$1
  implements DialogInterface.OnClickListener
{
  FloatingScreenPermission$1(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FloatingScreenReporter.c();
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission.1
 * JD-Core Version:    0.7.0.1
 */