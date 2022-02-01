package com.tencent.mobileqq.leba.business.mainbiz;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.widget.CustomWidgetUtil;

class LebaQzoneAndPluginPart$8$1
  implements Runnable
{
  LebaQzoneAndPluginPart$8$1(LebaQzoneAndPluginPart.8 param8, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b.setVisibility(0);
      }
      CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b, 9, this.jdField_a_of_type_Int, 0);
      if (AppSetting.d) {
        AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a, HardCodeUtil.a(2131706036), Button.class.getName());
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b.setVisibility(8);
      }
    } while (!AppSetting.d);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a, HardCodeUtil.a(2131719716), Button.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.1
 * JD-Core Version:    0.7.0.1
 */