package com.tencent.mobileqq.model;

import aube;
import awbw;
import awby;
import com.tencent.mobileqq.data.EmoticonTab;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$17
  implements Runnable
{
  public EmoticonManager$17(aube paramaube) {}
  
  public void run()
  {
    String str;
    synchronized (this.this$0)
    {
      this.this$0.jdField_a_of_type_Awbw.a(EmoticonTab.class.getSimpleName());
      awby localawby = this.this$0.jdField_a_of_type_Awbw.a();
      try
      {
        localawby.a();
        Iterator localIterator1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          aube.a(this.this$0, str, true, false);
          continue;
          localObject1 = finally;
        }
      }
      finally
      {
        localawby.b();
      }
    }
    Iterator localIterator2 = this.this$0.b.iterator();
    while (localIterator2.hasNext())
    {
      str = (String)localIterator2.next();
      aube.a(this.this$0, str, false, true);
    }
    localObject1.c();
    localObject1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.17
 * JD-Core Version:    0.7.0.1
 */