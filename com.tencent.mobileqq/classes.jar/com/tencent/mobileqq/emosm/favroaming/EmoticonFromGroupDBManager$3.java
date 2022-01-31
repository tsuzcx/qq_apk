package com.tencent.mobileqq.emosm.favroaming;

import ansk;
import aukp;
import aukr;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonFromGroupDBManager$3
  implements Runnable
{
  public EmoticonFromGroupDBManager$3(ansk paramansk, int paramInt, List paramList) {}
  
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
        localaukr = this.this$0.a.a();
        localObject1 = localaukr;
        localObject3 = localaukr;
        localaukr.a();
        localObject1 = localaukr;
        localObject3 = localaukr;
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      catch (Exception localException)
      {
        aukr localaukr;
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
      localObject1 = localaukr;
      localObject3 = localaukr;
      localaukr.c();
      if (localaukr != null) {
        localaukr.b();
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end.");
      }
      return;
      localObject1 = localaukr;
      localObject3 = localaukr;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = localaukr;
      localObject3 = localaukr;
      if (localIterator.hasNext())
      {
        localObject1 = localaukr;
        localObject3 = localaukr;
        localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localIterator.next();
        localObject1 = localaukr;
        localObject3 = localaukr;
        if (!this.this$0.a(localEmoticonFromGroupEntity))
        {
          localObject1 = localaukr;
          localObject3 = localaukr;
          if (QLog.isColorLevel())
          {
            localObject1 = localaukr;
            localObject3 = localaukr;
            QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "updateEntity error, e.md5=" + localEmoticonFromGroupEntity.md5);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager.3
 * JD-Core Version:    0.7.0.1
 */