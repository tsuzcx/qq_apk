package com.tencent.mobileqq.widget;

import ajya;
import android.widget.TextView;
import auvs;
import axqy;
import bbcq;
import bbmf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.List;

class ProfileCardMoreInfoView$7
  implements Runnable
{
  ProfileCardMoreInfoView$7(ProfileCardMoreInfoView paramProfileCardMoreInfoView, TextView paramTextView, RichStatus paramRichStatus) {}
  
  public void run()
  {
    int i;
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      i = auvs.a().a(this.jdField_a_of_type_AndroidWidgetTextView, (String)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.get(0)).second, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.b(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    bbmf localbbmf = new bbmf();
    localbbmf.a(0, ajya.a(2131708482), 0);
    bbcq.a(this.jdField_a_of_type_AndroidWidgetTextView, 0 - i, 0, localbbmf);
    auvs.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    axqy.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.7
 * JD-Core Version:    0.7.0.1
 */