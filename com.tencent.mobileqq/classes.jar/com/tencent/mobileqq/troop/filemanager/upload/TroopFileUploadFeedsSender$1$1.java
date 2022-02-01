package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import bedb;
import bfrs;
import bfvp;
import bfvr;
import bfxq;
import bfxr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(bfxr parambfxr, String paramString, bfrs parambfrs) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfrs.b)) {
      localObject = this.jdField_a_of_type_Bfrs.b;
    }
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "[" + this.jdField_a_of_type_Bfxr.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Bfxr.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((bedb)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "[" + this.jdField_a_of_type_Bfxr.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bfxr.a.d + "], id:" + this.jdField_a_of_type_Bfrs.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */