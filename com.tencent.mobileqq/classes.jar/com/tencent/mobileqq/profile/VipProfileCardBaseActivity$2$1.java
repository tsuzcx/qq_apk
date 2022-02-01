package com.tencent.mobileqq.profile;

import android.os.Handler;
import android.os.Message;
import azyq;
import bdmc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import java.util.HashMap;

public class VipProfileCardBaseActivity$2$1
  implements Runnable
{
  public VipProfileCardBaseActivity$2$1(azyq paramazyq, Card paramCard, HashMap paramHashMap, String paramString) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Azyq.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet);
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (bool) {}
    for (Object localObject = "0";; localObject = "-102")
    {
      localHashMap.put("param_FailCode", localObject);
      if (bool != true) {
        break;
      }
      bdmc.a(this.jdField_a_of_type_Azyq.a.app.getApp()).a(this.jdField_a_of_type_JavaLangString, "profileCardSet", true, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", false);
      localObject = this.jdField_a_of_type_Azyq.a.a.obtainMessage(5);
      this.jdField_a_of_type_Azyq.a.a.sendMessage((Message)localObject);
      return;
    }
    bdmc.a(this.jdField_a_of_type_Azyq.a.app.getApp()).a(this.jdField_a_of_type_JavaLangString, "profileCardSet", false, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", false);
    localObject = this.jdField_a_of_type_Azyq.a.a.obtainMessage(6);
    this.jdField_a_of_type_Azyq.a.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.2.1
 * JD-Core Version:    0.7.0.1
 */