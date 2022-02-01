package com.tencent.mobileqq.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class PhoneNumQuickLoginManager$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "createBottomDialog content child onClick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.3
 * JD-Core Version:    0.7.0.1
 */