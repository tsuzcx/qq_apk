package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

final class PhoneNumQuickLoginManager$8
  implements View.OnClickListener
{
  PhoneNumQuickLoginManager$8(Dialog paramDialog, Map paramMap) {}
  
  public void onClick(View paramView)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "setQuickLoginView other btn click");
    PhoneNumQuickLoginManager.a(this.a.getContext(), this.b);
    PhoneNumQuickLoginManager.b("0X800B8CE");
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.8
 * JD-Core Version:    0.7.0.1
 */