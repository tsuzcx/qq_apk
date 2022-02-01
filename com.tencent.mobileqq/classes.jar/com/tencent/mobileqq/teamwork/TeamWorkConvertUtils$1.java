package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class TeamWorkConvertUtils$1
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkConvertUtils$1(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ActionSheet paramActionSheet, AppInterface paramAppInterface, Context paramContext, String paramString, TeamWorkConvertUtils.TencentDocGetProgressDialogCallback paramTencentDocGetProgressDialogCallback) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    Context localContext;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.g = 0;
      ((ITeamWorkFileImportHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).removeFromConvertedMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      paramView = TeamWorkConvertUtils.a(paramView, (TeamWorkFileImportInfo)localObject, localContext, this.jdField_a_of_type_JavaLangString, localContext.getString(2131719542), true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$TencentDocGetProgressDialogCallback;
      if (localObject != null) {
        ((TeamWorkConvertUtils.TencentDocGetProgressDialogCallback)localObject).a(paramView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d()) {
        TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "0X8009ED2");
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.g = 2;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      paramView = TeamWorkConvertUtils.a(paramView, (TeamWorkFileImportInfo)localObject, localContext, this.jdField_a_of_type_JavaLangString, localContext.getString(2131719542), true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$TencentDocGetProgressDialogCallback;
      if (localObject != null) {
        ((TeamWorkConvertUtils.TencentDocGetProgressDialogCallback)localObject).a(paramView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d()) {
        TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "0X8009ED1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.1
 * JD-Core Version:    0.7.0.1
 */