package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class PhoneNumQuickLoginManager$15
  implements View.OnClickListener
{
  PhoneNumQuickLoginManager$15(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "setBoundPhoneNumView ok btn click");
    PhoneNumQuickLoginManager.a(paramView.getContext(), this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.15
 * JD-Core Version:    0.7.0.1
 */