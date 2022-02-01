package com.tencent.mobileqq.search.searchengine;

import bckx;
import bcmd;
import bcmq;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(bckx parambckx, bcmq parambcmq) {}
  
  public void run()
  {
    List localList = bckx.a(this.this$0, this.a);
    bcmd localbcmd = bckx.a(this.this$0);
    if ((localbcmd != null) && (localList != null)) {
      localbcmd.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */