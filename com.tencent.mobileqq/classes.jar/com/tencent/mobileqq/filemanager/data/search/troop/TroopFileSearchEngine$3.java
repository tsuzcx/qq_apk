package com.tencent.mobileqq.filemanager.data.search.troop;

import aqyo;
import aqzg;
import aqzk;
import aypy;
import bbrl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(aqzg paramaqzg, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (aqzg.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (aqzg.a(this.this$0) == null) {
          aqzg.b(this.this$0, new ArrayList());
        }
        aqzg.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = aqzg.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          bbrl localbbrl = (bbrl)localIterator.next();
          ((List)localObject).add(new aqzk(aqzg.a(this.this$0), aqzg.a(this.this$0), aqzg.a(this.this$0), localbbrl));
        }
      }
      aqzg.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - aqzg.a(this.this$0);
      localObject = aqzg.a(this.this$0).b();
      if ((!((String)localObject).equals(aqzg.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + aqzg.a(this.this$0) + "] timeInterval[" + l + "]");
        aqzg.a(this.this$0);
        aqzg.a(this.this$0, (String)localObject);
        aqzg.a(this.this$0, aqzg.a(this.this$0));
      }
      return;
      aqzg.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */