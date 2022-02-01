package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import bcws;
import bebc;
import befa;
import befc;
import behb;
import behc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(behc parambehc, String paramString, bebc parambebc) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bebc.b)) {
      localObject = this.jdField_a_of_type_Bebc.b;
    }
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFileUploadFeedsSender", befc.a, "[" + this.jdField_a_of_type_Behc.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.getMessageFacade().queryMsgItemByFilePath(String.valueOf(this.jdField_a_of_type_Behc.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((bcws)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    befc.a("TroopFileUploadFeedsSender", befc.a, "[" + this.jdField_a_of_type_Behc.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Behc.a.d + "], id:" + this.jdField_a_of_type_Bebc.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */