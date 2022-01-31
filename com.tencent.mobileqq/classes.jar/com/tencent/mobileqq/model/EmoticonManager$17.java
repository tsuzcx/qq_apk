package com.tencent.mobileqq.model;

import aufn;
import awgf;
import awgh;
import com.tencent.mobileqq.data.EmoticonTab;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$17
  implements Runnable
{
  public EmoticonManager$17(aufn paramaufn) {}
  
  public void run()
  {
    String str;
    synchronized (this.this$0)
    {
      this.this$0.jdField_a_of_type_Awgf.a(EmoticonTab.class.getSimpleName());
      awgh localawgh = this.this$0.jdField_a_of_type_Awgf.a();
      try
      {
        localawgh.a();
        Iterator localIterator1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          aufn.a(this.this$0, str, true, false);
          continue;
          localObject1 = finally;
        }
      }
      finally
      {
        localawgh.b();
      }
    }
    Iterator localIterator2 = this.this$0.b.iterator();
    while (localIterator2.hasNext())
    {
      str = (String)localIterator2.next();
      aufn.a(this.this$0, str, false, true);
    }
    localObject1.c();
    localObject1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.17
 * JD-Core Version:    0.7.0.1
 */