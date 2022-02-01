package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;

class EmoticonManager$23
  implements Runnable
{
  EmoticonManager$23(EmoticonManager paramEmoticonManager, EmoticonKeywords paramEmoticonKeywords) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    localEntityTransaction = this.this$0.a.getTransaction();
    try
    {
      localEntityTransaction.begin();
      EmoticonManager.a(this.this$0, this.a);
      localEntityTransaction.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EmoticonManager", 1, "saveKeywordReqTimeToDB e = " + localException.getMessage());
        localEntityTransaction.end();
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveKeywordReqTimeToDB cost : " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.23
 * JD-Core Version:    0.7.0.1
 */