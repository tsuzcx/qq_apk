package com.tencent.mobileqq.managers;

import arig;
import atmo;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

public class DraftTextManager$2
  implements Runnable
{
  public DraftTextManager$2(arig paramarig, DraftTextInfo paramDraftTextInfo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      ((atmp)localObject3).b((atmo)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((atmp)localObject3).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.2
 * JD-Core Version:    0.7.0.1
 */