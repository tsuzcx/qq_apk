package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import aygx;
import azpi;
import azsr;
import azst;
import azut;
import azuu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(azuu paramazuu, String paramString, azpi paramazpi) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Azpi.b)) {
      localObject = this.jdField_a_of_type_Azpi.b;
    }
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileUploadFeedsSender", azst.a, "[" + this.jdField_a_of_type_Azuu.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Azuu.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((aygx)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    azst.a("TroopFileUploadFeedsSender", azst.a, "[" + this.jdField_a_of_type_Azuu.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Azuu.a.d + "], id:" + this.jdField_a_of_type_Azpi.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */