package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class PhoneNumQuickLoginManager$5
  implements View.OnClickListener
{
  PhoneNumQuickLoginManager$5(Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "setQuickLoginView arrow down view click");
    PhoneNumQuickLoginManager.a(this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.5
 * JD-Core Version:    0.7.0.1
 */