package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;

class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  TroopFileUploadFeedsSender$1$1(TroopFileUploadFeedsSender.1 param1, String paramString, TroopFileInfo paramTroopFileInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b;
    }
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadFeedsSender$1.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)FileOperaterUtils.a(localQQAppInterface.getMessageFacade(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadFeedsSender$1.a.e), 1, (String)localObject);
    if (localObject != null)
    {
      ((AIOMessageSpreadManager)localQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a((MessageRecord)localObject);
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadFeedsSender$1.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadFeedsSender$1.a.e + "], id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */