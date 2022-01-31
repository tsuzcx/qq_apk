package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import aygv;
import azpg;
import azsp;
import azsr;
import azur;
import azus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(azus paramazus, String paramString, azpg paramazpg) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Azpg.b)) {
      localObject = this.jdField_a_of_type_Azpg.b;
    }
    QQAppInterface localQQAppInterface = azsp.a();
    if (localQQAppInterface == null)
    {
      azsr.a("TroopFileUploadFeedsSender", azsr.a, "[" + this.jdField_a_of_type_Azus.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Azus.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((aygv)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    azsr.a("TroopFileUploadFeedsSender", azsr.a, "[" + this.jdField_a_of_type_Azus.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Azus.a.d + "], id:" + this.jdField_a_of_type_Azpg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */