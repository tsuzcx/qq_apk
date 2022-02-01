package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import auea;
import bedr;
import bfif;
import bgju;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferManager$5$1
  implements Runnable
{
  public TroopFileTransferManager$5$1(bgju parambgju, String paramString, bfif parambfif) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfif.b)) {
      str = this.jdField_a_of_type_Bfif.b;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)this.jdField_a_of_type_Bgju.a.a.getMessageFacade().queryMsgItemByFilePath(String.valueOf(this.jdField_a_of_type_Bgju.a.e), 1, str);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Bgju.a.a;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = auea.a(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((bedr)this.jdField_a_of_type_Bgju.a.a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bgju.a.e + "], id:" + this.jdField_a_of_type_Bfif.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.5.1
 * JD-Core Version:    0.7.0.1
 */