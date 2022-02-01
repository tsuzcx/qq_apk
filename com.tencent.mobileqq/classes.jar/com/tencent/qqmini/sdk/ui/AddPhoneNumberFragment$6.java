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
    AddPhoneNumberFragment localAddPhoneNumberFragment = this.this$0;
    if (!AddPhoneNumberFragment.access$600(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      AddPhoneNumberFragment.access$602(localAddPhoneNumberFragment, bool);
      AddPhoneNumberFragment.access$700(this.this$0).setChecked(AddPhoneNumberFragment.access$600(this.this$0));
      QMLog.d("AddPhoneNumberFragment", "isSave : " + AddPhoneNumberFragment.access$600(this.this$0));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.6
 * JD-Core Version:    0.7.0.1
 */