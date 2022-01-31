package com.tencent.mobileqq.emosm;

import aphz;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.qphone.base.util.QLog;

public class CustomEmotionRoamingDBManagerBase$2
  implements Runnable
{
  public CustomEmotionRoamingDBManagerBase$2(aphz paramaphz, int paramInt, CustomEmotionBase paramCustomEmotionBase) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    awbw localawbw;
    do
    {
      return;
      localawbw = this.this$0.a.getEntityManagerFactory().createEntityManager();
    } while (localawbw == null);
    boolean bool2 = false;
    boolean bool1;
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not save fav emoticon data, type:" + this.jdField_a_of_type_Int);
        bool1 = bool2;
      }
      break;
    }
    for (;;)
    {
      localawbw.a();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CustomEmotionRoamingDBManagerBase", 2, "updateCustomEmotionDataListInDB type:" + this.jdField_a_of_type_Int + "save result: " + bool1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase.setStatus(1000);
      localawbw.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase);
      bool1 = bool2;
      continue;
      bool1 = localawbw.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase);
      continue;
      bool1 = localawbw.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.2
 * JD-Core Version:    0.7.0.1
 */