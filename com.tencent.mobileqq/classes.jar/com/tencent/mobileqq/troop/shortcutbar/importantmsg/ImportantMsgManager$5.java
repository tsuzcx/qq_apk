package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ImportantMsgManager$5
  implements ImportantMsgManager.callbackInMainThread
{
  ImportantMsgManager$5(ImportantMsgManager paramImportantMsgManager, ArrayList paramArrayList, int paramInt) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    ArrayList localArrayList = paramImportantMsgItem.getMsgInfoList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      int j = localArrayList.indexOf(ImportantMsgUtil.a(localLong.longValue()));
      if (-1 != j)
      {
        ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgNeedShow = false;
        ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgSummary = "";
        i = this.jdField_a_of_type_Int;
        if (i == 1) {
          ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgNotShowType = 1;
        } else if (i == 2) {
          ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgNotShowType = 2;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("delImportantMsg msgSeq:");
        localStringBuilder.append(localLong);
        localStringBuilder.append(" from:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.i("ImportantMsgManager", 2, localStringBuilder.toString());
        i = 1;
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager.a(paramImportantMsgItem.clone());
    }
    if ((this.jdField_a_of_type_Int == 1) || (i != 0)) {
      ImportantMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMsgManager, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.5
 * JD-Core Version:    0.7.0.1
 */