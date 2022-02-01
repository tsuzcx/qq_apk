package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportJob;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class TeamWorkFileImportJob
  implements ITeamWorkFileImportJob
{
  protected ITeamWorkFileImportHandler a;
  public TeamWorkFileImportInfo a;
  
  public TeamWorkFileImportJob(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    if (paramAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler = ((ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName()));
    }
  }
  
  public void a(AppInterface paramAppInterface) {}
  
  protected void a(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.c)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("---notifyUIFailed try local fileName: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
        QLog.i("TeamWorkFileImportJob", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.removeFileImporting(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
      ((TeamWorkFileImportInfo)localObject).a = false;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap((TeamWorkFileImportInfo)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.fileImportFromLocalFile(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.notifyUIError(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJob
 * JD-Core Version:    0.7.0.1
 */