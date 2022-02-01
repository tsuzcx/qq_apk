package com.tencent.mobileqq.filemanager.data.search.troop;

import asml;
import asnd;
import asnh;
import bbff;
import befl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(asnd paramasnd, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (asnd.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (asnd.a(this.this$0) == null) {
          asnd.b(this.this$0, new ArrayList());
        }
        asnd.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = asnd.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          befl localbefl = (befl)localIterator.next();
          ((List)localObject).add(new asnh(asnd.a(this.this$0), asnd.a(this.this$0), asnd.a(this.this$0), localbefl));
        }
      }
      asnd.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - asnd.a(this.this$0);
      localObject = asnd.a(this.this$0).b();
      if ((!((String)localObject).equals(asnd.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + asnd.a(this.this$0) + "] timeInterval[" + l + "]");
        asnd.a(this.this$0);
        asnd.a(this.this$0, (String)localObject);
        asnd.a(this.this$0, asnd.a(this.this$0));
      }
      return;
      asnd.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */