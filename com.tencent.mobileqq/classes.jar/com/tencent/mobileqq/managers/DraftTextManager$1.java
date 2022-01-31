package com.tencent.mobileqq.managers;

import atvk;
import awbw;
import awbx;
import awby;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

public class DraftTextManager$1
  implements Runnable
{
  public DraftTextManager$1(atvk paramatvk, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localawby = localawbw.a();
    try
    {
      localawby.a();
      localawbw.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localawby.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localawby.b();
      }
    }
    finally
    {
      localawby.b();
    }
    localawbw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */