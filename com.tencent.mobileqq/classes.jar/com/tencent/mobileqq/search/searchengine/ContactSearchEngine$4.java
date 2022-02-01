package com.tencent.mobileqq.search.searchengine;

import bbsj;
import bbsq;
import bbtk;
import bbtx;
import bbty;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(bbsj parambbsj, bbtx parambbtx) {}
  
  public void run()
  {
    List localList1 = bbsj.a(this.this$0, this.a);
    bbtk localbbtk = bbsj.a(this.this$0);
    bbty localbbty;
    if ((localbbtk != null) && (localList1 != null))
    {
      localbbty = new bbty(this.a.a, 1);
      if (bbsj.a(this.this$0) == null) {
        localbbtk.a(localList1, localbbty);
      }
    }
    else
    {
      return;
    }
    localbbtk.a(localList1);
    List localList2 = bbsj.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localbbtk.a(localList1, localbbty);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */