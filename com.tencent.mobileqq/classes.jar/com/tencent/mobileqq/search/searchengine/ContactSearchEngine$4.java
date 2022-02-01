package com.tencent.mobileqq.search.searchengine;

import bckw;
import bcld;
import bclx;
import bcmk;
import bcml;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(bckw parambckw, bcmk parambcmk) {}
  
  public void run()
  {
    List localList1 = bckw.a(this.this$0, this.a);
    bclx localbclx = bckw.a(this.this$0);
    bcml localbcml;
    if ((localbclx != null) && (localList1 != null))
    {
      localbcml = new bcml(this.a.a, 1);
      if (bckw.a(this.this$0) == null) {
        localbclx.a(localList1, localbcml);
      }
    }
    else
    {
      return;
    }
    localbclx.a(localList1);
    List localList2 = bckw.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localbclx.a(localList1, localbcml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */