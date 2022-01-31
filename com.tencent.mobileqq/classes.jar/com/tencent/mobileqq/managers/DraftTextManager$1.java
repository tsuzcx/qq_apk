package com.tencent.mobileqq.managers;

import atzt;
import awgf;
import awgg;
import awgh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

public class DraftTextManager$1
  implements Runnable
{
  public DraftTextManager$1(atzt paramatzt, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localawgh = localawgf.a();
    try
    {
      localawgh.a();
      localawgf.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localawgh.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localawgh.b();
      }
    }
    finally
    {
      localawgh.b();
    }
    localawgf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */