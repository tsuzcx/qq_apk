package com.tencent.mobileqq.search.searchengine;

import bckr;
import bclx;
import bcmk;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(bckr parambckr, bcmk parambcmk) {}
  
  public void run()
  {
    List localList = bckr.a(this.this$0, this.a);
    bclx localbclx = bckr.a(this.this$0);
    if ((localbclx != null) && (localList != null)) {
      localbclx.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */