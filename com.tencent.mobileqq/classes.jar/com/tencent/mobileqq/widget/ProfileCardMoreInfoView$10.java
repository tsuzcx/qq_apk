package com.tencent.mobileqq.widget;

import alpo;
import android.widget.TextView;
import awne;
import azmj;
import bdbk;
import bdkz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.List;

class ProfileCardMoreInfoView$10
  implements Runnable
{
  ProfileCardMoreInfoView$10(ProfileCardMoreInfoView paramProfileCardMoreInfoView, TextView paramTextView, RichStatus paramRichStatus) {}
  
  public void run()
  {
    int i;
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      i = awne.a().a(this.jdField_a_of_type_AndroidWidgetTextView, (String)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.get(0)).second, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.b(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    bdkz localbdkz = new bdkz();
    localbdkz.a(0, alpo.a(2131708854), 0);
    bdbk.a(this.jdField_a_of_type_AndroidWidgetTextView, 0 - i, 0, localbdkz);
    awne.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    azmj.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.10
 * JD-Core Version:    0.7.0.1
 */