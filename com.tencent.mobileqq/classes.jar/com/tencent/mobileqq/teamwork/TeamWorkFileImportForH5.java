package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class TeamWorkFileImportForH5
  extends TeamWorkFileImportJob
{
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new TeamWorkFileImportForH5.1(this);
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public TeamWorkFileImportForH5(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = paramAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Long);
        if ((localObject != null) && ((localObject instanceof MessageForFile))) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(paramAppInterface, (MessageForFile)localObject);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramAppInterface.getFileManagerDataCenter().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)))
        {
          i = 1;
          paramAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
          break label174;
        }
      }
      int i = 0;
      label174:
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.fileImportFromLocalFileForH5(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportForH5
 * JD-Core Version:    0.7.0.1
 */