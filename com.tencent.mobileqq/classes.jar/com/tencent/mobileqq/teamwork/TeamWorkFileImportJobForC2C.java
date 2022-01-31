package com.tencent.mobileqq.teamwork;

import aimk;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class TeamWorkFileImportJobForC2C
  extends TeamWorkFileImportJob
{
  private FileTransferObserver a;
  public FileManagerEntity a;
  
  public TeamWorkFileImportJobForC2C(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new aimk(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (paramQQAppInterface != null))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString))) {
        break label189;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long);
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForFile))) {
        break label168;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid))) {
        break label189;
      }
      i = 1;
      paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.f(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      return;
      label168:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
      break;
      label189:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForC2C
 * JD-Core Version:    0.7.0.1
 */