package com.tencent.mobileqq.search.searchengine;

import avtz;
import avug;
import avva;
import avvn;
import avvo;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(avtz paramavtz, avvn paramavvn) {}
  
  public void run()
  {
    List localList1 = avtz.a(this.this$0, this.a);
    avva localavva = avtz.a(this.this$0);
    avvo localavvo;
    if ((localavva != null) && (localList1 != null))
    {
      localavvo = new avvo(this.a.a, 1);
      if (avtz.a(this.this$0) == null) {
        localavva.a(localList1, localavvo);
      }
    }
    else
    {
      return;
    }
    localavva.a(localList1);
    List localList2 = avtz.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localavva.a(localList1, localavvo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */