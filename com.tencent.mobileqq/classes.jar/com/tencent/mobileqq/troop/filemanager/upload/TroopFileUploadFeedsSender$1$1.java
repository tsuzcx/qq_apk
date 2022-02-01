package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import bdkg;
import besl;
import bevv;
import bevx;
import bexw;
import bexx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(bexx parambexx, String paramString, besl parambesl) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Besl.b)) {
      localObject = this.jdField_a_of_type_Besl.b;
    }
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopFileUploadFeedsSender", bevx.a, "[" + this.jdField_a_of_type_Bexx.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Bexx.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((bdkg)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    bevx.a("TroopFileUploadFeedsSender", bevx.a, "[" + this.jdField_a_of_type_Bexx.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bexx.a.d + "], id:" + this.jdField_a_of_type_Besl.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */