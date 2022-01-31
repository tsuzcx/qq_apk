package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import apue;
import aygv;
import azpg;
import bakb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferManager$6$1
  implements Runnable
{
  public TroopFileTransferManager$6$1(bakb parambakb, String paramString, azpg paramazpg) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Azpg.b)) {
      str = this.jdField_a_of_type_Azpg.b;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)this.jdField_a_of_type_Bakb.a.a.a().a(String.valueOf(this.jdField_a_of_type_Bakb.a.e), 1, str);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Bakb.a.a;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = apue.a(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((aygv)this.jdField_a_of_type_Bakb.a.a.getManager(272)).a(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bakb.a.e + "], id:" + this.jdField_a_of_type_Azpg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.6.1
 * JD-Core Version:    0.7.0.1
 */