package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class CustomEmotionRoamingDBManagerBase$2
  implements Runnable
{
  CustomEmotionRoamingDBManagerBase$2(CustomEmotionRoamingDBManagerBase paramCustomEmotionRoamingDBManagerBase, int paramInt, CustomEmotionBase paramCustomEmotionBase) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    Object localObject = this.this$0.app.getEntityManagerFactory().createEntityManager();
    if (localObject == null) {
      return;
    }
    boolean bool2 = false;
    int i = this.jdField_a_of_type_Int;
    boolean bool1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("can not save fav emoticon data, type:");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            QLog.d("CustomEmotionRoamingDBManagerBase", 2, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = ((EntityManager)localObject).remove(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase);
        }
      }
      else {
        bool1 = ((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase.setStatus(1000);
      ((EntityManager)localObject).persist(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionBase);
      bool1 = bool2;
    }
    ((EntityManager)localObject).close();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCustomEmotionDataListInDB type:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("save result: ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("CustomEmotionRoamingDBManagerBase", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.2
 * JD-Core Version:    0.7.0.1
 */