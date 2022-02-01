package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import atvo;
import bdkg;
import besl;
import bfrz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferManager$5$1
  implements Runnable
{
  public TroopFileTransferManager$5$1(bfrz parambfrz, String paramString, besl parambesl) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Besl.b)) {
      str = this.jdField_a_of_type_Besl.b;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)this.jdField_a_of_type_Bfrz.a.a.a().a(String.valueOf(this.jdField_a_of_type_Bfrz.a.e), 1, str);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Bfrz.a.a;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = atvo.a(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((bdkg)this.jdField_a_of_type_Bfrz.a.a.getManager(272)).a(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bfrz.a.e + "], id:" + this.jdField_a_of_type_Besl.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.5.1
 * JD-Core Version:    0.7.0.1
 */