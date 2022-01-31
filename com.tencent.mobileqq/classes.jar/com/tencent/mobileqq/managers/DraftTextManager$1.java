package com.tencent.mobileqq.managers;

import asei;
import aukn;
import auko;
import aukp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

public class DraftTextManager$1
  implements Runnable
{
  public DraftTextManager$1(asei paramasei, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukp = localaukn.a();
    try
    {
      localaukp.a();
      localaukn.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localaukp.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localaukp.b();
      }
    }
    finally
    {
      localaukp.b();
    }
    localaukn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */