package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import arni;
import baet;
import bbnr;
import bcjc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferManager$6$1
  implements Runnable
{
  public TroopFileTransferManager$6$1(bcjc parambcjc, String paramString, bbnr parambbnr) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbnr.b)) {
      str = this.jdField_a_of_type_Bbnr.b;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)this.jdField_a_of_type_Bcjc.a.a.a().a(String.valueOf(this.jdField_a_of_type_Bcjc.a.e), 1, str);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Bcjc.a.a;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = arni.a(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((baet)this.jdField_a_of_type_Bcjc.a.a.getManager(272)).a(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bcjc.a.e + "], id:" + this.jdField_a_of_type_Bbnr.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.6.1
 * JD-Core Version:    0.7.0.1
 */