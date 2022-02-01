package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class TeamWorkFileImportJobForGroup
  extends TeamWorkFileImportJob
{
  private TroopFileReqDownloadFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TeamWorkFileImportJobForGroup.1(this);
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public TeamWorkFileImportJobForGroup(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private FileManagerEntity a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return null;
      }
      paramQQAppInterface = paramQQAppInterface.getFileManagerProxy();
      Object localObject = paramQQAppInterface.c();
      if (localObject == null) {
        paramQQAppInterface.init();
      }
      if (localObject == null) {
        return null;
      }
      paramQQAppInterface = ((List)localObject).iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (FileManagerEntity)paramQQAppInterface.next();
        if ((((FileManagerEntity)localObject).peerUin != null) && (TextUtils.equals(paramString1, ((FileManagerEntity)localObject).strTroopFileID)) && (((FileManagerEntity)localObject).peerUin.equals(paramString2)))
        {
          if ((((FileManagerEntity)localObject).cloudType == 1) && (FileManagerUtil.b((FileManagerEntity)localObject))) {
            ((FileManagerEntity)localObject).status = 16;
          }
          return localObject;
        }
      }
    }
    return null;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramJSONObject.optString("groupuin")))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramJSONObject.optString("businesstype"))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Boolean;
      int j = 1;
      int i;
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Int != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new TroopFileInfo();
        ((TroopFileInfo)localObject).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d.getBytes());
        ((TroopFileInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d;
        ((TroopFileInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString;
        ((TroopFileInfo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Int;
        localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
        ((TroopFileTransferManager.Item)localObject).FileName = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString;
        TroopFileProtocol.a(paramAppInterface, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue(), (TroopFileTransferManager.Item)localObject, 0, false, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
        localObject = paramAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Long);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramAppInterface.getFileManagerDataCenter().b(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Long);
          }
          FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          if ((localFileManagerEntity != null) && (TextUtils.isEmpty(localFileManagerEntity.strFileMd5))) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = a(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileID, ((MessageRecord)localObject).frienduin);
          }
          localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          if (localFileManagerEntity != null)
          {
            i = j;
            if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramAppInterface.getFileManagerDataCenter().a(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Long);
            i = j;
          }
        }
        else
        {
          QLog.w("TeamWorkFileImportJobForGroup", 2, "can not find message");
          i = j;
        }
      }
      else
      {
        i = 0;
      }
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.fileImportFromLocalFile(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.addToFileImportingMap(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForGroup
 * JD-Core Version:    0.7.0.1
 */