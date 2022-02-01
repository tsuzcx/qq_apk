package com.tencent.mobileqq.search.searchengine;

import bclc;
import bclj;
import bcmd;
import bcmq;
import bcmr;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(bclc parambclc, bcmq parambcmq) {}
  
  public void run()
  {
    List localList1 = bclc.a(this.this$0, this.a);
    bcmd localbcmd = bclc.a(this.this$0);
    bcmr localbcmr;
    if ((localbcmd != null) && (localList1 != null))
    {
      localbcmr = new bcmr(this.a.a, 1);
      if (bclc.a(this.this$0) == null) {
        localbcmd.a(localList1, localbcmr);
      }
    }
    else
    {
      return;
    }
    localbcmd.a(localList1);
    List localList2 = bclc.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localbcmd.a(localList1, localbcmr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */