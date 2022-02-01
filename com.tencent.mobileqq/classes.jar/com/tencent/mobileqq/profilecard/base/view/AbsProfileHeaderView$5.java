package com.tencent.mobileqq.profilecard.base.view;

import android.widget.TextView;
import anzj;
import azyk;
import bdll;
import bhkx;
import bhuk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

class AbsProfileHeaderView$5
  implements Runnable
{
  AbsProfileHeaderView$5(AbsProfileHeaderView paramAbsProfileHeaderView, RichStatus paramRichStatus, TextView paramTextView, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText == null) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.size() <= 0)) {
        break label172;
      }
      localObject = (String)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.get(0);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.sortTopicPos();
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos == null) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.size() <= 0)) {
        break label177;
      }
    }
    label172:
    label177:
    for (int i = ((Integer)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.get(0)).second).intValue();; i = 0)
    {
      i = azyk.a().a(this.jdField_a_of_type_AndroidWidgetTextView, (String)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.get(0)).second, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, this.jdField_a_of_type_Int, (String)localObject, i);
      if (i != -2147483648) {
        break label182;
      }
      return;
      localObject = null;
      break;
    }
    label182:
    Object localObject = new bhuk();
    ((bhuk)localObject).a(0, anzj.a(2131707371), 0);
    bhkx.a(this.jdField_a_of_type_AndroidWidgetTextView, 0 - i, 0, (bhuk)localObject);
    azyk.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bdll.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.5
 * JD-Core Version:    0.7.0.1
 */