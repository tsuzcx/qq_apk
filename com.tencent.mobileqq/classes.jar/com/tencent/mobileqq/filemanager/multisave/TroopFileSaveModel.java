package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSaveModel
  extends QFileSaveModel
{
  private MessageForTroopFile a;
  
  public TroopFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  public long a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {
      return 0L;
    }
    return localTroopFileStatusInfo.c;
  }
  
  public QFileControlReq a()
  {
    TroopFileControlReq localTroopFileControlReq = new TroopFileControlReq(TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
    localTroopFileControlReq.a(new TroopFileSaveModel.1(this));
    return localTroopFileControlReq;
  }
  
  public String a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    if (localTroopFileStatusInfo == null)
    {
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
      return false;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload: uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "] fileId[" + localTroopFileStatusInfo.e + "]");
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    localTroopFileTransferManager.a(localTroopFileStatusInfo.e, localTroopFileStatusInfo.g, localTroopFileStatusInfo.c, localTroopFileStatusInfo.h);
    if ((localTroopFileStatusInfo.b == 10) || (localTroopFileStatusInfo.b == 9)) {
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localTroopFileTransferManager.c(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      }
    }
    for (;;)
    {
      return true;
      QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
      return false;
      if (localTroopFileStatusInfo.b != 7) {
        break;
      }
      localTroopFileTransferManager.a(localTroopFileStatusInfo.e, localTroopFileStatusInfo.g, localTroopFileStatusInfo.c, localTroopFileStatusInfo.h);
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : can not handle file info status[" + localTroopFileStatusInfo.b + ",download error");
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq;
  }
  
  public boolean b()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {
      QLog.i("TroopFileSaveModel<QFile>", 1, "stopDownload : file info is null. uniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq + "]");
    }
    while ((localTroopFileStatusInfo.b != 8) && (localTroopFileStatusInfo.b != 9) && (localTroopFileStatusInfo.b != 10)) {
      return false;
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).d(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  public boolean c()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return (localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.b == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.TroopFileSaveModel
 * JD-Core Version:    0.7.0.1
 */