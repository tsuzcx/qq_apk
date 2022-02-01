package com.tencent.mobileqq.model;

import avsq;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$7
  implements Runnable
{
  public EmoticonManager$7(avsq paramavsq, List paramList) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.this$0.a.getTransaction();
    localEntityTransaction.begin();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if ((localEmoticonPackage != null) && (!avsq.a(this.this$0, localEmoticonPackage))) {
        QLog.e("EmoticonManager", 1, "saveEmoticonPackages fail epId = " + localEmoticonPackage.epId);
      }
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.7
 * JD-Core Version:    0.7.0.1
 */