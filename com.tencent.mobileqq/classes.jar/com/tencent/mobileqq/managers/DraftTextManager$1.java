package com.tencent.mobileqq.managers;

import asek;
import aukp;
import aukq;
import aukr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

public class DraftTextManager$1
  implements Runnable
{
  public DraftTextManager$1(asek paramasek, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukr = localaukp.a();
    try
    {
      localaukr.a();
      localaukp.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localaukr.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localaukr.b();
      }
    }
    finally
    {
      localaukr.b();
    }
    localaukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */