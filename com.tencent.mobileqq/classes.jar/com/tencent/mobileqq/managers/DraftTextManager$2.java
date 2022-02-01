package com.tencent.mobileqq.managers;

import awzu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

public class DraftTextManager$2
  implements Runnable
{
  public DraftTextManager$2(awzu paramawzu, DraftTextInfo paramDraftTextInfo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      ((EntityManager)localObject3).remove((Entity)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityManager)localObject3).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.2
 * JD-Core Version:    0.7.0.1
 */