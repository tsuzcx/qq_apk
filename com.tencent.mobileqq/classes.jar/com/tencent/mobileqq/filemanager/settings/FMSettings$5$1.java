package com.tencent.mobileqq.filemanager.settings;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.lang.reflect.Field;

class FMSettings$5$1
  implements DialogInterface.OnClickListener
{
  FMSettings$5$1(FMSettings.5 param5, TextView paramTextView, ProgressBar paramProgressBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.this$0.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.jdField_a_of_type_AndroidAppActivity);
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704684));
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131167070);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.this$0.a.getBtnight().setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.this$0.a.getBtnight().setTextColor(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.this$0.a.getBtnLeft().setTextColor(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.this$0.a.getBtnLeft().setEnabled(false);
      FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.this$0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings$5.jdField_a_of_type_JavaUtilList, new FMSettings.5.1.1(this));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.5.1
 * JD-Core Version:    0.7.0.1
 */