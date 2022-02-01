package com.tencent.mobileqq.mini.mainpage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

class AddPhoneNumberFragment$5
  implements View.OnClickListener
{
  AddPhoneNumberFragment$5(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.this$0;
    AddPhoneNumberFragment.access$702(paramView, AddPhoneNumberFragment.access$700(paramView) ^ true);
    AddPhoneNumberFragment.access$800(this.this$0).setChecked(AddPhoneNumberFragment.access$700(this.this$0));
    paramView = new StringBuilder();
    paramView.append("isSave : ");
    paramView.append(AddPhoneNumberFragment.access$700(this.this$0));
    QLog.d("AddPhoneNumberFragment", 1, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.5
 * JD-Core Version:    0.7.0.1
 */