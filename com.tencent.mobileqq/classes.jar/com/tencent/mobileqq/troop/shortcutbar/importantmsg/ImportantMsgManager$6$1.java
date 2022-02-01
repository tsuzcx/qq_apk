package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import java.util.HashMap;

class ImportantMsgManager$6$1
  implements Runnable
{
  ImportantMsgManager$6$1(ImportantMsgManager.6 param6, ImportantMsgItem paramImportantMsgItem) {}
  
  public void run()
  {
    if (ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.this$0).containsKey(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_Long)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$callbackInMainThread.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_Long, (ImportantMsgItem)ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.this$0).get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_Long)));
      return;
    }
    ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.this$0).put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgItem);
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$callbackInMainThread.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager$6.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.6.1
 * JD-Core Version:    0.7.0.1
 */