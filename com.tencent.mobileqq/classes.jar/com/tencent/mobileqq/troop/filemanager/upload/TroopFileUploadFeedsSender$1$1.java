package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import bajc;
import bbsa;
import bbvj;
import bbvl;
import bbxl;
import bbxm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(bbxm parambbxm, String paramString, bbsa parambbsa) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbsa.b)) {
      localObject = this.jdField_a_of_type_Bbsa.b;
    }
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFileUploadFeedsSender", bbvl.a, "[" + this.jdField_a_of_type_Bbxm.a.jdField_a_of_type_JavaLangString + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.a().a(String.valueOf(this.jdField_a_of_type_Bbxm.a.d), 1, (String)localObject);
    if (localObject != null)
    {
      ((bajc)localQQAppInterface.getManager(272)).a((MessageRecord)localObject);
      return;
    }
    bbvl.a("TroopFileUploadFeedsSender", bbvl.a, "[" + this.jdField_a_of_type_Bbxm.a.jdField_a_of_type_JavaLangString + "] addToSendCache can't find troopFile Msg, troop[" + this.jdField_a_of_type_Bbxm.a.d + "], id:" + this.jdField_a_of_type_Bbsa.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */