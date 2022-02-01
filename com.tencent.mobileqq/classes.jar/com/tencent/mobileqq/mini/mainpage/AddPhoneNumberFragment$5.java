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
    if (!AddPhoneNumberFragment.access$700(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      AddPhoneNumberFragment.access$702(paramView, bool);
      AddPhoneNumberFragment.access$800(this.this$0).setChecked(AddPhoneNumberFragment.access$700(this.this$0));
      QLog.d("AddPhoneNumberFragment", 1, "isSave : " + AddPhoneNumberFragment.access$700(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.5
 * JD-Core Version:    0.7.0.1
 */