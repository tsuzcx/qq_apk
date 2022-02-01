package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.utils.ViewUtils;
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
          if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Int, this.b, 0);
          CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.a, this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.b());
          if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c != null) {
            this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.c.setVisibility(8);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.setText(this.jdField_a_of_type_JavaLangString);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.getLayoutParams();
          if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper == null) {
            break label403;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a();
          if (i > 1) {
            localMarginLayoutParams.rightMargin = ViewUtils.b(80.0F);
          } else if (i == 1) {
            localMarginLayoutParams.rightMargin = ViewUtils.b(48.0F);
          } else {
            localMarginLayoutParams.rightMargin = ViewUtils.b(8.0F);
          }
          this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.d.setVisibility(8);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.e, 8, this.b, 0);
          this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.e.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMainbizLebaQzoneAndPluginPart$8.this$0.e.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateQZoneRedFlag");
        localStringBuilder.append(localException);
        QLog.e("Leba", 1, localStringBuilder.toString());
        return;
      }
      label403:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.8.7
 * JD-Core Version:    0.7.0.1
 */