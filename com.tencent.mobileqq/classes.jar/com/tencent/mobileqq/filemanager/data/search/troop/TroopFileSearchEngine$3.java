package com.tencent.mobileqq.filemanager.data.search.troop;

import apfm;
import apge;
import apgi;
import awut;
import azta;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(apge paramapge, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (apge.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (apge.a(this.this$0) == null) {
          apge.b(this.this$0, new ArrayList());
        }
        apge.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = apge.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          azta localazta = (azta)localIterator.next();
          ((List)localObject).add(new apgi(apge.a(this.this$0), apge.a(this.this$0), apge.a(this.this$0), localazta));
        }
      }
      apge.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - apge.a(this.this$0);
      localObject = apge.a(this.this$0).b();
      if ((!((String)localObject).equals(apge.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + apge.a(this.this$0) + "] timeInterval[" + l + "]");
        apge.a(this.this$0);
        apge.a(this.this$0, (String)localObject);
        apge.a(this.this$0, apge.a(this.this$0));
      }
      return;
      apge.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */