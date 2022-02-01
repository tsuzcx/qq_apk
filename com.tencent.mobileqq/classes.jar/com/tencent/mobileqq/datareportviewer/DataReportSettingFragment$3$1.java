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
    EditText localEditText = (EditText)((QQCustomDialog)paramDialogInterface).findViewById(2131372122);
    paramDialogInterface = (EditText)((QQCustomDialog)paramDialogInterface).findViewById(2131361955);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, HardCodeUtil.a(2131702809), 0).a();
      return;
    }
    ReportDataConfig localReportDataConfig = new ReportDataConfig();
    localReportDataConfig.a = localEditText.getText().toString();
    localReportDataConfig.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localReportDataConfig.jdField_b_of_type_Boolean = true;
    DataReportViewerFloatViewHelper.a().a(localReportDataConfig);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */