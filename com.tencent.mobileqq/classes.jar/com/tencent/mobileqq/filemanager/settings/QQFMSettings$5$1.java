package com.tencent.mobileqq.filemanager.settings;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.lang.reflect.Field;

class QQFMSettings$5$1
  implements DialogInterface.OnClickListener
{
  QQFMSettings$5$1(QQFMSettings.5 param5, TextView paramTextView, ProgressBar paramProgressBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.c.this$0.h().a(this.c.a);
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
    this.a.setText(HardCodeUtil.a(2131902666));
    paramDialogInterface = this.c.a.getResources().getColorStateList(2131168045);
    this.c.this$0.a.getBtnight().setEnabled(false);
    this.c.this$0.a.getBtnight().setTextColor(paramDialogInterface);
    this.c.this$0.a.getBtnLeft().setTextColor(paramDialogInterface);
    this.c.this$0.a.getBtnLeft().setEnabled(false);
    QQFMSettings.a(this.c.this$0, this.c.b, new QQFMSettings.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.5.1
 * JD-Core Version:    0.7.0.1
 */