package com.tencent.mobileqq.model;

import agyv;
import aufn;
import awgf;
import awgh;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonTab;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$18
  implements Runnable
{
  public EmoticonManager$18(aufn paramaufn, String paramString) {}
  
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
        Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          aufn.a(this.this$0, str, true, false);
          continue;
          localObject2 = finally;
        }
      }
      finally
      {
        localawgh.b();
      }
    }
    Object localObject5 = this.this$0.b.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      str = (String)((Iterator)localObject5).next();
      aufn.a(this.this$0, str, false, true);
    }
    localObject2.c();
    localObject2.b();
    Object localObject3 = this.this$0.a(this.a);
    if (localObject3 == null) {
      return;
    }
    ??? = new HashSet();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (Emoticon)((Iterator)localObject3).next();
      if (((Emoticon)localObject5).name != null) {
        ((HashSet)???).add(((Emoticon)localObject5).name);
      }
    }
    agyv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((Collection)???);
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.18
 * JD-Core Version:    0.7.0.1
 */