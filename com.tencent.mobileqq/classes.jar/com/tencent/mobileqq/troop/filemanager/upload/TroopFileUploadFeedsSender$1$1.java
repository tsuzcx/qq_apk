package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import axgr;
import ayoq;
import ayrz;
import aysb;
import ayub;
import ayuc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(ayuc paramayuc, String paramString, ayoq paramayoq) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoq.b)) {
      localObject = this.jdField_a_of_type_Ayoq.b;
    }
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileUploadFeedsSender", aysb.a, "[" + this.jdField_a_of_type_Ayuc.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Ayuc.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((axgr)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    aysb.a("TroopFileUploadFeedsSender", aysb.a, "[" + this.jdField_a_of_type_Ayuc.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Ayuc.a.d + "], id:" + this.jdField_a_of_type_Ayoq.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */