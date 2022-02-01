package com.tencent.mobileqq.model;

import awyr;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$17
  implements Runnable
{
  public EmoticonManager$17(awyr paramawyr) {}
  
  public void run()
  {
    String str;
    synchronized (this.this$0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(EmoticonTab.class.getSimpleName());
      EntityTransaction localEntityTransaction = this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          awyr.a(this.this$0, str, true, false);
          continue;
          localObject1 = finally;
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
    Iterator localIterator2 = this.this$0.b.iterator();
    while (localIterator2.hasNext())
    {
      str = (String)localIterator2.next();
      awyr.a(this.this$0, str, false, true);
    }
    localObject1.commit();
    localObject1.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.17
 * JD-Core Version:    0.7.0.1
 */