package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class PhoneNumQuickLoginManager$7
  implements View.OnClickListener
{
  PhoneNumQuickLoginManager$7(View.OnClickListener paramOnClickListener, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "setQuickLoginView self btn click");
    View.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    this.b.setOnDismissListener(null);
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.7
 * JD-Core Version:    0.7.0.1
 */