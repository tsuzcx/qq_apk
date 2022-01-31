package com.tencent.mobileqq.search.searchengine;

import awtp;
import awuv;
import awvi;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(awtp paramawtp, awvi paramawvi) {}
  
  public void run()
  {
    List localList = awtp.a(this.this$0, this.a);
    awuv localawuv = awtp.a(this.this$0);
    if ((localawuv != null) && (localList != null)) {
      localawuv.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */