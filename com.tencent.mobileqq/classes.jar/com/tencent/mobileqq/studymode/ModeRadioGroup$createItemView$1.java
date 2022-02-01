package com.tencent.mobileqq.studymode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ModeRadioGroup$createItemView$1
  implements View.OnClickListener
{
  ModeRadioGroup$createItemView$1(ModeRadioGroup paramModeRadioGroup, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.getContext()))
    {
      if (ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup) != this.jdField_a_of_type_Int) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.getContext(), 1, 2131694475, 1).a();
      }
    }
    else if ((this.jdField_a_of_type_Int == 2) && (ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup) != 2))
    {
      ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup, this.jdField_a_of_type_Int);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click item, type= ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", old type= ");
      localStringBuilder.append(ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup));
      localStringBuilder.append(", enableCheck = ");
      localStringBuilder.append(ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup));
      QLog.d("GeneralModeRadioGroup", 2, localStringBuilder.toString());
      if ((ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup)) && (this.jdField_a_of_type_Int != ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup))) {
        ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup, this.jdField_a_of_type_Int, true, false, 4, null);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup.createItemView.1
 * JD-Core Version:    0.7.0.1
 */