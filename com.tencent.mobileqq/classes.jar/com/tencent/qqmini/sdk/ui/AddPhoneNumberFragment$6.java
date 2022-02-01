package com.tencent.qqmini.sdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.widget.Switch;

class AddPhoneNumberFragment$6
  implements View.OnClickListener
{
  AddPhoneNumberFragment$6(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    AddPhoneNumberFragment.access$602((AddPhoneNumberFragment)localObject, AddPhoneNumberFragment.access$600((AddPhoneNumberFragment)localObject) ^ true);
    AddPhoneNumberFragment.access$700(this.this$0).setChecked(AddPhoneNumberFragment.access$600(this.this$0));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isSave : ");
    ((StringBuilder)localObject).append(AddPhoneNumberFragment.access$600(this.this$0));
    QMLog.d("AddPhoneNumberFragment", ((StringBuilder)localObject).toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.6
 * JD-Core Version:    0.7.0.1
 */