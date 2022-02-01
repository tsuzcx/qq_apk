package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class TeamWorkFileImportJobForUrl2Doc
  extends TeamWorkFileImportJob
{
  public TeamWorkFileImportJobForUrl2Doc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AppInterface paramAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramAppInterface);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null) && (paramAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.fileImportFromUrl2Doc(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForUrl2Doc
 * JD-Core Version:    0.7.0.1
 */