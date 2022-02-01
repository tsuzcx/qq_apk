package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SignTextEditFragment$11
  implements CompoundButton.OnCheckedChangeListener
{
  SignTextEditFragment$11(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.a.getActivity() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if ((!NetworkUtil.d(this.a.getActivity())) || (SignTextEditFragment.a(this.a) == null)) {
        break;
      }
      if (AppSetting.d) {
        this.a.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131707904));
      }
      SignTextEditFragment.a(this.a).a(paramBoolean);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
    }
    Object localObject = this.a.getActivity();
    int i;
    label130:
    CheckBox localCheckBox;
    if (SignTextEditFragment.a(this.a) != null)
    {
      i = 2131694507;
      QQToast.a((Context)localObject, i, 1).a();
      localObject = this.a;
      localCheckBox = this.a.jdField_a_of_type_AndroidWidgetCheckBox;
      if (paramBoolean) {
        break label181;
      }
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      SignTextEditFragment.a((SignTextEditFragment)localObject, localCheckBox, bool);
      break;
      i = 2131719116;
      break label130;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.11
 * JD-Core Version:    0.7.0.1
 */