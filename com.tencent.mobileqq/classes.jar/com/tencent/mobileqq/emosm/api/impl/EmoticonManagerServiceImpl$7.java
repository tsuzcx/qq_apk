package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class EmoticonManagerServiceImpl$7
  implements Runnable
{
  EmoticonManagerServiceImpl$7(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, List paramList) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.this$0.em.getTransaction();
    localEntityTransaction.begin();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if ((localEmoticonPackage != null) && (!EmoticonManagerServiceImpl.access$100(this.this$0, localEmoticonPackage)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveEmoticonPackages fail epId = ");
        localStringBuilder.append(localEmoticonPackage.epId);
        QLog.e("EmoticonManager", 1, localStringBuilder.toString());
      }
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */