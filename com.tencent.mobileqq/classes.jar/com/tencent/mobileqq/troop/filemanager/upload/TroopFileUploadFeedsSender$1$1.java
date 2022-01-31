package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import baet;
import bbnr;
import bbra;
import bbrc;
import bbtc;
import bbtd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(bbtd parambbtd, String paramString, bbnr parambbnr) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbnr.b)) {
      localObject = this.jdField_a_of_type_Bbnr.b;
    }
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "[" + this.jdField_a_of_type_Bbtd.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Bbtd.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((baet)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "[" + this.jdField_a_of_type_Bbtd.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bbtd.a.d + "], id:" + this.jdField_a_of_type_Bbnr.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */