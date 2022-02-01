package com.tencent.mobileqq.search.searchengine;

import bbee;
import bbel;
import bbff;
import bbfs;
import bbft;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(bbee parambbee, bbfs parambbfs) {}
  
  public void run()
  {
    List localList1 = bbee.a(this.this$0, this.a);
    bbff localbbff = bbee.a(this.this$0);
    bbft localbbft;
    if ((localbbff != null) && (localList1 != null))
    {
      localbbft = new bbft(this.a.a, 1);
      if (bbee.a(this.this$0) == null) {
        localbbff.a(localList1, localbbft);
      }
    }
    else
    {
      return;
    }
    localbbff.a(localList1);
    List localList2 = bbee.a(this.this$0).a(this.a);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localbbff.a(localList1, localbbft);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */