package com.tencent.mobileqq.managers;

import arig;
import atmp;
import atmq;
import atmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

public class DraftTextManager$1
  implements Runnable
{
  public DraftTextManager$1(arig paramarig, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localatmr = localatmp.a();
    try
    {
      localatmr.a();
      localatmp.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localatmr.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localatmr.b();
      }
    }
    finally
    {
      localatmr.b();
    }
    localatmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */