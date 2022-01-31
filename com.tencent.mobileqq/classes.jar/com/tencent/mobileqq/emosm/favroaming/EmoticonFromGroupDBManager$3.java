package com.tencent.mobileqq.emosm.favroaming;

import apob;
import awgf;
import awgh;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonFromGroupDBManager$3
  implements Runnable
{
  public EmoticonFromGroupDBManager$3(apob paramapob, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_DBManager", 2, "db operation start. opType: " + this.jdField_a_of_type_Int);
    }
    Object localObject3;
    Object localObject1;
    if (this.this$0.a != null)
    {
      localObject3 = null;
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        localawgh = this.this$0.a.a();
        localObject1 = localawgh;
        localObject3 = localawgh;
        localawgh.a();
        localObject1 = localawgh;
        localObject3 = localawgh;
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      catch (Exception localException)
      {
        awgh localawgh;
        localObject3 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localObject1;
        QLog.e("EmoticonFromGroup_DBManager", 2, "write2DB ex=", localException);
        if (localObject1 == null) {
          continue;
        }
        localObject1.b();
        continue;
        localObject1 = localException;
        localObject3 = localException;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        localObject1 = localException;
        localObject3 = localException;
        if (!localIterator.hasNext()) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localIterator.next();
        localObject1 = localException;
        localObject3 = localException;
        if (this.this$0.a.b(localEmoticonFromGroupEntity)) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        if (localEmoticonFromGroupEntity.getStatus() == 1000) {
          continue;
        }
        localObject1 = localException;
        localObject3 = localException;
        QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "remove error, e.md5=" + localEmoticonFromGroupEntity.md5);
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        localObject3.b();
      }
      localObject1 = localawgh;
      localObject3 = localawgh;
      localawgh.c();
      if (localawgh != null) {
        localawgh.b();
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end.");
      }
      return;
      localObject1 = localawgh;
      localObject3 = localawgh;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = localawgh;
      localObject3 = localawgh;
      if (localIterator.hasNext())
      {
        localObject1 = localawgh;
        localObject3 = localawgh;
        localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localIterator.next();
        localObject1 = localawgh;
        localObject3 = localawgh;
        if (!this.this$0.a(localEmoticonFromGroupEntity))
        {
          localObject1 = localawgh;
          localObject3 = localawgh;
          if (QLog.isColorLevel())
          {
            localObject1 = localawgh;
            localObject3 = localawgh;
            QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "updateEntity error, e.md5=" + localEmoticonFromGroupEntity.md5);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager.3
 * JD-Core Version:    0.7.0.1
 */