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
    Object localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doDownload : file info is null. uniseq[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq);
      ((StringBuilder)localObject1).append("]");
      QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doDownload: uniseq[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq);
    ((StringBuilder)localObject2).append("] fileId[");
    ((StringBuilder)localObject2).append(((TroopFileStatusInfo)localObject1).e);
    ((StringBuilder)localObject2).append("]");
    QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject2).toString());
    localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    ((TroopFileTransferManager)localObject2).a(((TroopFileStatusInfo)localObject1).e, ((TroopFileStatusInfo)localObject1).g, ((TroopFileStatusInfo)localObject1).c, ((TroopFileStatusInfo)localObject1).h);
    if ((((TroopFileStatusInfo)localObject1).b != 10) && (((TroopFileStatusInfo)localObject1).b != 9))
    {
      if (((TroopFileStatusInfo)localObject1).b == 7)
      {
        ((TroopFileTransferManager)localObject2).a(((TroopFileStatusInfo)localObject1).e, ((TroopFileStatusInfo)localObject1).g, ((TroopFileStatusInfo)localObject1).c, ((TroopFileStatusInfo)localObject1).h);
        return true;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDownload : can not handle file info status[");
      ((StringBuilder)localObject2).append(((TroopFileStatusInfo)localObject1).b);
      ((StringBuilder)localObject2).append(",download error");
      QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null)
    {
      ((TroopFileTransferManager)localObject2).c(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
      return true;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
    return false;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    Object localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopDownload : file info is null. uniseq[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.uniseq);
      ((StringBuilder)localObject).append("]");
      QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    if ((((TroopFileStatusInfo)localObject).b != 8) && (((TroopFileStatusInfo)localObject).b != 9) && (((TroopFileStatusInfo)localObject).b != 10)) {
      return false;
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).d(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  public boolean c()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return (localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.b == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.TroopFileSaveModel
 * JD-Core Version:    0.7.0.1
 */