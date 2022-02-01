package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

class ImportantMsgManager$1
  extends TroopShortcutBarObserver
{
  ImportantMsgManager$1(ImportantMsgManager paramImportantMsgManager, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(long paramLong, boolean paramBoolean, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1)
  {
    ImportantMsgManager.a(this.a, paramLong, paramBoolean, paramList, paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.1
 * JD-Core Version:    0.7.0.1
 */