package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportJobForUrl2Doc
  extends TeamWorkFileImportJob
{
  public TeamWorkFileImportJobForUrl2Doc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (paramQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.h(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForUrl2Doc
 * JD-Core Version:    0.7.0.1
 */