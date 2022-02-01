package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class PhoneNumQuickLoginManager$2
  implements View.OnClickListener
{
  PhoneNumQuickLoginManager$2(Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "createBottomDialog content view onClick");
    PhoneNumQuickLoginManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppDialog);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.2
 * JD-Core Version:    0.7.0.1
 */