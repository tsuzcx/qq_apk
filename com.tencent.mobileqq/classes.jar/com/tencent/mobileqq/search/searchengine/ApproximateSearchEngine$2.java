package com.tencent.mobileqq.search.searchengine;

import bbse;
import bbtk;
import bbtx;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(bbse parambbse, bbtx parambbtx) {}
  
  public void run()
  {
    List localList = bbse.a(this.this$0, this.a);
    bbtk localbbtk = bbse.a(this.this$0);
    if ((localbbtk != null) && (localList != null)) {
      localbbtk.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */