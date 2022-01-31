package com.tencent.mobileqq.filemanager.data.search.troop;

import apfq;
import apgi;
import apgm;
import awuv;
import aztc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(apgi paramapgi, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (apgi.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (apgi.a(this.this$0) == null) {
          apgi.b(this.this$0, new ArrayList());
        }
        apgi.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = apgi.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          aztc localaztc = (aztc)localIterator.next();
          ((List)localObject).add(new apgm(apgi.a(this.this$0), apgi.a(this.this$0), apgi.a(this.this$0), localaztc));
        }
      }
      apgi.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - apgi.a(this.this$0);
      localObject = apgi.a(this.this$0).b();
      if ((!((String)localObject).equals(apgi.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + apgi.a(this.this$0) + "] timeInterval[" + l + "]");
        apgi.a(this.this$0);
        apgi.a(this.this$0, (String)localObject);
        apgi.a(this.this$0, apgi.a(this.this$0));
      }
      return;
      apgi.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */