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
    if (this.a.getBaseActivity() != null)
    {
      if ((NetworkUtil.isNetSupport(this.a.getBaseActivity())) && (SignTextEditFragment.a(this.a) != null))
      {
        if (AppSetting.d) {
          this.a.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131707927));
        }
        SignTextEditFragment.a(this.a).a(paramBoolean);
      }
      else
      {
        Object localObject = this.a.getBaseActivity();
        int i;
        if (SignTextEditFragment.a(this.a) != null) {
          i = 2131694473;
        } else {
          i = 2131718834;
        }
        QQToast.a((Context)localObject, i, 1).a();
        localObject = this.a;
        SignTextEditFragment.a((SignTextEditFragment)localObject, ((SignTextEditFragment)localObject).jdField_a_of_type_AndroidWidgetCheckBox, paramBoolean ^ true);
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.11
 * JD-Core Version:    0.7.0.1
 */