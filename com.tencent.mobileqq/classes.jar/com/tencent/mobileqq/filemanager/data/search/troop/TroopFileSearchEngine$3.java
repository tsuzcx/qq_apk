package com.tencent.mobileqq.filemanager.data.search.troop;

import aoor;
import aoov;
import aooz;
import avva;
import aysk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(aoov paramaoov, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (aoov.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (aoov.a(this.this$0) == null) {
          aoov.b(this.this$0, new ArrayList());
        }
        aoov.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = aoov.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          aysk localaysk = (aysk)localIterator.next();
          ((List)localObject).add(new aooz(aoov.a(this.this$0), aoov.a(this.this$0), aoov.a(this.this$0), localaysk));
        }
      }
      aoov.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - aoov.a(this.this$0);
      localObject = aoov.a(this.this$0).a_();
      if ((!((String)localObject).equals(aoov.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + aoov.a(this.this$0) + "] timeInterval[" + l + "]");
        aoov.a(this.this$0);
        aoov.a(this.this$0, (String)localObject);
        aoov.a(this.this$0, aoov.a(this.this$0));
      }
      return;
      aoov.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */