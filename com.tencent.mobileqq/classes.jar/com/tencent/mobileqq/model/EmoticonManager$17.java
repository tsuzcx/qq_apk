package com.tencent.mobileqq.model;

import arnz;
import atmp;
import atmr;
import com.tencent.mobileqq.data.EmoticonTab;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$17
  implements Runnable
{
  public EmoticonManager$17(arnz paramarnz) {}
  
  public void run()
  {
    String str;
    synchronized (this.this$0)
    {
      this.this$0.jdField_a_of_type_Atmp.a(EmoticonTab.class.getSimpleName());
      atmr localatmr = this.this$0.jdField_a_of_type_Atmp.a();
      try
      {
        localatmr.a();
        Iterator localIterator1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          arnz.a(this.this$0, str, true, false);
          continue;
          localObject1 = finally;
        }
      }
      finally
      {
        localatmr.b();
      }
    }
    Iterator localIterator2 = this.this$0.b.iterator();
    while (localIterator2.hasNext())
    {
      str = (String)localIterator2.next();
      arnz.a(this.this$0, str, false, true);
    }
    localObject1.c();
    localObject1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.17
 * JD-Core Version:    0.7.0.1
 */