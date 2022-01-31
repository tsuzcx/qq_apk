package com.tencent.mobileqq.filemanager.data.search.troop;

import arcx;
import ardp;
import ardt;
import ayuh;
import bbvu;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(ardp paramardp, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (ardp.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (ardp.a(this.this$0) == null) {
          ardp.b(this.this$0, new ArrayList());
        }
        ardp.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = ardp.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          bbvu localbbvu = (bbvu)localIterator.next();
          ((List)localObject).add(new ardt(ardp.a(this.this$0), ardp.a(this.this$0), ardp.a(this.this$0), localbbvu));
        }
      }
      ardp.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - ardp.a(this.this$0);
      localObject = ardp.a(this.this$0).b();
      if ((!((String)localObject).equals(ardp.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + ardp.a(this.this$0) + "] timeInterval[" + l + "]");
        ardp.a(this.this$0);
        ardp.a(this.this$0, (String)localObject);
        ardp.a(this.this$0, ardp.a(this.this$0));
      }
      return;
      ardp.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */