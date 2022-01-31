package com.tencent.mobileqq.search.searchengine;

import ayos;
import aypy;
import ayql;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(ayos paramayos, ayql paramayql) {}
  
  public void run()
  {
    List localList = ayos.a(this.this$0, this.a);
    aypy localaypy = ayos.a(this.this$0);
    if ((localaypy != null) && (localList != null)) {
      localaypy.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */