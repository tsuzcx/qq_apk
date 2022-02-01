package com.tencent.mobileqq.leba.business.mainbiz;

import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class LebaQzoneAndPluginPart$8$3
  implements Runnable
{
  LebaQzoneAndPluginPart$8$3(LebaQzoneAndPluginPart.8 param8, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c.setText(this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetImageSwitcher != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null)) {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a(localArrayList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidViewView != null) {
        AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidViewView, HardCodeUtil.a(2131706034));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.3
 * JD-Core Version:    0.7.0.1
 */