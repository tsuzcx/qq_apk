package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;

class LebaQzoneAndPluginPart$8$7
  implements Runnable
{
  LebaQzoneAndPluginPart$8$7(LebaQzoneAndPluginPart.8 param8, int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int != -1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a != null) {
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a.setVisibility(0);
          }
          CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a, this.jdField_a_of_type_Int, this.b, 0);
          CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.a, this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b());
          if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c != null) {
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c.setVisibility(8);
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.setText(this.jdField_a_of_type_JavaLangString);
            if (!this.jdField_a_of_type_Boolean) {
              break;
            }
            CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.e, 8, this.b, 0);
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.e.setVisibility(0);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.a.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.setVisibility(8);
      }
      catch (Exception localException)
      {
        QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.7
 * JD-Core Version:    0.7.0.1
 */