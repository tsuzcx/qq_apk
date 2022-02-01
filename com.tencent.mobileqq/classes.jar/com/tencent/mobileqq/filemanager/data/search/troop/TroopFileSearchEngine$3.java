package com.tencent.mobileqq.filemanager.data.search.troop;

import auab;
import auat;
import auax;
import bcmd;
import bfwa;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileSearchEngine$3
  implements Runnable
{
  public TroopFileSearchEngine$3(auat paramauat, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (auat.a(this.this$0) == null) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (auat.a(this.this$0) == null) {
          auat.b(this.this$0, new ArrayList());
        }
        auat.a(this.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
        Iterator localIterator = auat.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          bfwa localbfwa = (bfwa)localIterator.next();
          ((List)localObject).add(new auax(auat.a(this.this$0), auat.a(this.this$0), auat.a(this.this$0), localbfwa));
        }
      }
      auat.a(this.this$0).a((List)localObject, 1);
    }
    for (;;)
    {
      long l = System.currentTimeMillis() - auat.a(this.this$0);
      localObject = auat.a(this.this$0).b();
      if ((!((String)localObject).equals(auat.a(this.this$0))) && (l >= 800L))
      {
        QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + (String)localObject + "] mLastKeyWord[" + auat.a(this.this$0) + "] timeInterval[" + l + "]");
        auat.a(this.this$0);
        auat.a(this.this$0, (String)localObject);
        auat.a(this.this$0, auat.a(this.this$0));
      }
      return;
      auat.a(this.this$0).a(new ArrayList(), 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */