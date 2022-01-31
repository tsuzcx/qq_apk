package com.tencent.mobileqq.search.searchengine;

import awts;
import awtz;
import awut;
import awvg;
import awvh;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(awts paramawts, awvg paramawvg) {}
  
  public void run()
  {
    List localList1 = awts.a(this.this$0, this.a);
    awut localawut = awts.a(this.this$0);
    awvh localawvh;
    if ((localawut != null) && (localList1 != null))
    {
      localawvh = new awvh(this.a.a, 1);
      if (awts.a(this.this$0) == null) {
        localawut.a(localList1, localawvh);
      }
    }
    else
    {
      return;
    }
    localawut.a(localList1);
    List localList2 = awts.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localawut.a(localList1, localawvh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */