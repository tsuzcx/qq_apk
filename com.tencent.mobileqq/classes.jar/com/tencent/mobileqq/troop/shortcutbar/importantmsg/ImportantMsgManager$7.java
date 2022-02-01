package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class ImportantMsgManager$7
  implements ImportantMsgManager.callbackInMainThread
{
  ImportantMsgManager$7(ImportantMsgManager paramImportantMsgManager, ArrayList paramArrayList) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    paramImportantMsgItem.addMsgInfos(this.jdField_a_of_type_JavaUtilArrayList);
    if ((ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager).containsKey(Long.valueOf(paramLong))) && (paramImportantMsgItem.maxImportantMsgSeq >= ((Integer)ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager).get(Long.valueOf(paramLong))).intValue()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:");
        localStringBuilder.append(paramImportantMsgItem.maxImportantMsgSeq);
        localStringBuilder.append(" registerProxy lastSeq:");
        localStringBuilder.append(ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager).get(Long.valueOf(paramLong)));
        QLog.i("ImportantMsgManager", 2, localStringBuilder.toString());
      }
      paramImportantMsgItem.updateMaxMsgSeq();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager.a(paramImportantMsgItem.clone());
    ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.7
 * JD-Core Version:    0.7.0.1
 */