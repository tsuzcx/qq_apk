package com.tencent.mobileqq.profile.view;

import ajyc;
import android.widget.TextView;
import auvq;
import axqw;
import bbcc;
import bblr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

class ProfileHeaderView$5
  implements Runnable
{
  ProfileHeaderView$5(ProfileHeaderView paramProfileHeaderView, RichStatus paramRichStatus, TextView paramTextView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText == null) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.size() <= 0)) {
        break label175;
      }
      localObject = (String)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.get(0);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.sortTopicPos();
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos == null) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.size() <= 0)) {
        break label180;
      }
    }
    label175:
    label180:
    for (int i = ((Integer)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.get(0)).second).intValue();; i = 0)
    {
      i = auvq.a().a(this.jdField_a_of_type_AndroidWidgetTextView, (String)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.get(0)).second, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, this.this$0.f, (String)localObject, i);
      if (i != -2147483648) {
        break label185;
      }
      return;
      localObject = null;
      break;
    }
    label185:
    Object localObject = new bblr();
    ((bblr)localObject).a(0, ajyc.a(2131708491), 0);
    bbcc.a(this.jdField_a_of_type_AndroidWidgetTextView, 0 - i, 0, (bblr)localObject);
    auvq.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    axqw.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.5
 * JD-Core Version:    0.7.0.1
 */