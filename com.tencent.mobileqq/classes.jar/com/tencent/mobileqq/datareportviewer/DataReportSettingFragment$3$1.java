package com.tencent.mobileqq.datareportviewer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class DataReportSettingFragment$3$1
  implements DialogInterface.OnClickListener
{
  DataReportSettingFragment$3$1(DataReportSettingFragment.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = (QQCustomDialog)paramDialogInterface;
    paramDialogInterface = (EditText)((QQCustomDialog)localObject).findViewById(2131371704);
    localObject = (EditText)((QQCustomDialog)localObject).findViewById(2131361968);
    if ((!TextUtils.isEmpty(paramDialogInterface.getText().toString())) && (!TextUtils.isEmpty(((EditText)localObject).getText().toString())))
    {
      ReportDataConfig localReportDataConfig = new ReportDataConfig();
      localReportDataConfig.a = paramDialogInterface.getText().toString();
      localReportDataConfig.jdField_b_of_type_JavaLangString = ((EditText)localObject).getText().toString();
      localReportDataConfig.jdField_b_of_type_Boolean = true;
      DataReportViewerFloatViewHelper.a().a(localReportDataConfig);
      this.a.a.a.notifyDataSetChanged();
      return;
    }
    QQToast.a(this.a.a.getBaseActivity(), 1, HardCodeUtil.a(2131702941), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */