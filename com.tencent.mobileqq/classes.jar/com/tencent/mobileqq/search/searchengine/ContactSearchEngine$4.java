package com.tencent.mobileqq.search.searchengine;

import ayox;
import aype;
import aypy;
import ayql;
import ayqm;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(ayox paramayox, ayql paramayql) {}
  
  public void run()
  {
    List localList1 = ayox.a(this.this$0, this.a);
    aypy localaypy = ayox.a(this.this$0);
    ayqm localayqm;
    if ((localaypy != null) && (localList1 != null))
    {
      localayqm = new ayqm(this.a.a, 1);
      if (ayox.a(this.this$0) == null) {
        localaypy.a(localList1, localayqm);
      }
    }
    else
    {
      return;
    }
    localaypy.a(localList1);
    List localList2 = ayox.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localaypy.a(localList1, localayqm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */