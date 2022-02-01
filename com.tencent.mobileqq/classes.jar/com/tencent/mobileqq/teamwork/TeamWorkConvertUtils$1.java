package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class TeamWorkConvertUtils$1
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkConvertUtils$1(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ActionSheet paramActionSheet, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkConvertUtils.TencentDocGetProgressDialogCallback paramTencentDocGetProgressDialogCallback) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 2;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        paramView = TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext.getString(2131719818), true);
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$TencentDocGetProgressDialogCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$TencentDocGetProgressDialogCallback.a(paramView);
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d());
      TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009ED1");
      return;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
      ((TeamWorkFileImportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER)).e(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      paramView = TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext.getString(2131719818), true);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$TencentDocGetProgressDialogCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$TencentDocGetProgressDialogCallback.a(paramView);
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d());
    TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009ED2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.1
 * JD-Core Version:    0.7.0.1
 */