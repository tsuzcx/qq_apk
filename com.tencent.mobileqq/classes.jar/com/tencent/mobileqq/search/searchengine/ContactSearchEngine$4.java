package com.tencent.mobileqq.search.searchengine;

import aytg;
import aytn;
import ayuh;
import ayuu;
import ayuv;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(aytg paramaytg, ayuu paramayuu) {}
  
  public void run()
  {
    List localList1 = aytg.a(this.this$0, this.a);
    ayuh localayuh = aytg.a(this.this$0);
    ayuv localayuv;
    if ((localayuh != null) && (localList1 != null))
    {
      localayuv = new ayuv(this.a.a, 1);
      if (aytg.a(this.this$0) == null) {
        localayuh.a(localList1, localayuv);
      }
    }
    else
    {
      return;
    }
    localayuh.a(localList1);
    List localList2 = aytg.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localayuh.a(localList1, localayuv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */