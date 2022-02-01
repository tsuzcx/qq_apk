package com.tencent.mobileqq.qcall;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QCallDetailActivity$9
  implements ActionSheet.OnButtonClickListener
{
  QCallDetailActivity$9(QCallDetailActivity paramQCallDetailActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) != null)
    {
      if (paramInt >= QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).length) {
        return;
      }
      if (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity)[paramInt] != 2) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF9", "0X8005AF9", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.9
 * JD-Core Version:    0.7.0.1
 */