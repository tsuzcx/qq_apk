package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import bedr;
import bfif;
import bfmd;
import bfmf;
import bfoe;
import bfof;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(bfof parambfof, String paramString, bfif parambfif) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfif.b)) {
      localObject = this.jdField_a_of_type_Bfif.b;
    }
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface == null)
    {
      bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "[" + this.jdField_a_of_type_Bfof.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.getMessageFacade().queryMsgItemByFilePath(String.valueOf(this.jdField_a_of_type_Bfof.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((bedr)localQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a((MessageRecord)localObject);
      return;
    }
    bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "[" + this.jdField_a_of_type_Bfof.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bfof.a.d + "], id:" + this.jdField_a_of_type_Bfif.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */