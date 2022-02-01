package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import aunj;
import bedb;
import bfrs;
import bgsa;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferManager$5$1
  implements Runnable
{
  public TroopFileTransferManager$5$1(bgsa parambgsa, String paramString, bfrs parambfrs) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfrs.b)) {
      str = this.jdField_a_of_type_Bfrs.b;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)this.jdField_a_of_type_Bgsa.a.a.a().a(String.valueOf(this.jdField_a_of_type_Bgsa.a.e), 1, str);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Bgsa.a.a;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = aunj.a(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((bedb)this.jdField_a_of_type_Bgsa.a.a.getManager(272)).a(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bgsa.a.e + "], id:" + this.jdField_a_of_type_Bfrs.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.5.1
 * JD-Core Version:    0.7.0.1
 */