package com.tencent.mobileqq.search.searchengine;

import awtn;
import awut;
import awvg;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(awtn paramawtn, awvg paramawvg) {}
  
  public void run()
  {
    List localList = awtn.a(this.this$0, this.a);
    awut localawut = awtn.a(this.this$0);
    if ((localawut != null) && (localList != null)) {
      localawut.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */