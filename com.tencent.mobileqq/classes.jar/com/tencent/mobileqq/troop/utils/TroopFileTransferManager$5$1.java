package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.qphone.base.util.QLog;

class TroopFileTransferManager$5$1
  implements Runnable
{
  TroopFileTransferManager$5$1(TroopFileTransferManager.5 param5, String paramString, TroopFileInfo paramTroopFileInfo) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b)) {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$5.a.a.getMessageFacade(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$5.a.e), 1, str);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$5.a.a;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = FileManagerUtil.a(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$5.a.a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$5.a.e + "], id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.5.1
 * JD-Core Version:    0.7.0.1
 */