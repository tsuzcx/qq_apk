package com.tencent.mobileqq.search.searchengine;

import avtu;
import avva;
import avvn;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(avtu paramavtu, avvn paramavvn) {}
  
  public void run()
  {
    List localList = avtu.a(this.this$0, this.a);
    avva localavva = avtu.a(this.this$0);
    if ((localavva != null) && (localList != null)) {
      localavva.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */