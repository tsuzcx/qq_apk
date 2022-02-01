package com.tencent.mobileqq.filemanager.data.search.troop;

import atih;
import atiz;
import atjd;
import bbtk;
import bewg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(atiz paramatiz, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (atiz.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (atiz.a(this.this$0) == null) {
          atiz.b(this.this$0, new ArrayList());
        }
        atiz.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = atiz.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          bewg localbewg = (bewg)localIterator.next();
          ((List)localObject).add(new atjd(atiz.a(this.this$0), atiz.a(this.this$0), atiz.a(this.this$0), localbewg));
        }
      }
      atiz.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - atiz.a(this.this$0);
      localObject = atiz.a(this.this$0).b();
      if ((!((String)localObject).equals(atiz.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + atiz.a(this.this$0) + "] timeInterval[" + l + "]");
        atiz.a(this.this$0);
        atiz.a(this.this$0, (String)localObject);
        atiz.a(this.this$0, atiz.a(this.this$0));
      }
      return;
      atiz.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */