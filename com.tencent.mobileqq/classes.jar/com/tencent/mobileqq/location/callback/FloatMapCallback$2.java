package com.tencent.mobileqq.location.callback;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenReporter;

final class FloatMapCallback$2
  implements DialogInterface.OnClickListener
{
  FloatMapCallback$2(QBaseActivity paramQBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FloatingScreenReporter.c();
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.FloatMapCallback.2
 * JD-Core Version:    0.7.0.1
 */