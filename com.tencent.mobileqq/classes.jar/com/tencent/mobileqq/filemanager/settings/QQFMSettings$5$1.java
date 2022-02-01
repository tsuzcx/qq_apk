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

class QQFMSettings$5$1
  implements DialogInterface.OnClickListener
{
  QQFMSettings$5$1(QQFMSettings.5 param5, TextView paramTextView, ProgressBar paramProgressBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.this$0.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.jdField_a_of_type_AndroidAppActivity);
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704764));
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131167093);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.this$0.a.getBtnight().setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.this$0.a.getBtnight().setTextColor(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.this$0.a.getBtnLeft().setTextColor(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.this$0.a.getBtnLeft().setEnabled(false);
    QQFMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.this$0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings$5.jdField_a_of_type_JavaUtilList, new QQFMSettings.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.5.1
 * JD-Core Version:    0.7.0.1
 */