package com.tencent.mobileqq.teamwork;

import aimm;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TeamWorkFileImportJobForGroup
  extends TeamWorkFileImportJob
{
  private TroopFileProtocol.ReqDownloadFileObserver a;
  
  public TeamWorkFileImportJobForGroup(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver = new aimm(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (paramQQAppInterface != null))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d)) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString))) {
        break label207;
      }
      Object localObject = new TroopFileInfo();
      ((TroopFileInfo)localObject).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d.getBytes());
      ((TroopFileInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d;
      ((TroopFileInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString;
      ((TroopFileInfo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int;
      localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
      ((TroopFileTransferManager.Item)localObject).FileName = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString;
      TroopFileProtocol.a(paramQQAppInterface, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString).longValue(), (TroopFileTransferManager.Item)localObject, 0, false, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver);
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
      label207:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForGroup
 * JD-Core Version:    0.7.0.1
 */