package com.tencent.mobileqq.search.searchengine;

import awtu;
import awub;
import awuv;
import awvi;
import awvj;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(awtu paramawtu, awvi paramawvi) {}
  
  public void run()
  {
    List localList1 = awtu.a(this.this$0, this.a);
    awuv localawuv = awtu.a(this.this$0);
    awvj localawvj;
    if ((localawuv != null) && (localList1 != null))
    {
      localawvj = new awvj(this.a.a, 1);
      if (awtu.a(this.this$0) == null) {
        localawuv.a(localList1, localawvj);
      }
    }
    else
    {
      return;
    }
    localawuv.a(localList1);
    List localList2 = awtu.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localawuv.a(localList1, localawvj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */