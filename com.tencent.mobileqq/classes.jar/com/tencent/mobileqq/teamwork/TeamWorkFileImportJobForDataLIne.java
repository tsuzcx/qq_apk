package com.tencent.mobileqq.teamwork;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class TeamWorkFileImportJobForDataLIne
  extends TeamWorkFileImportJob
{
  public TeamWorkFileImportJobForDataLIne(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AppInterface paramAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramAppInterface);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null) && (paramAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.fileImportFromLocalFileForDataLine(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDataLIne
 * JD-Core Version:    0.7.0.1
 */