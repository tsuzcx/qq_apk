package com.tencent.mobileqq.search.searchengine;

import bbdz;
import bbff;
import bbfs;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(bbdz parambbdz, bbfs parambbfs) {}
  
  public void run()
  {
    List localList = bbdz.a(this.this$0, this.a);
    bbff localbbff = bbdz.a(this.this$0);
    if ((localbbff != null) && (localList != null)) {
      localbbff.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */