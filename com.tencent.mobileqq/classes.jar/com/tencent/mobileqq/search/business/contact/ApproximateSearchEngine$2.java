package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;

class ApproximateSearchEngine$2
  implements Runnable
{
  ApproximateSearchEngine$2(ApproximateSearchEngine paramApproximateSearchEngine, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    List localList = ApproximateSearchEngine.a(this.this$0, this.a);
    ISearchListener localISearchListener = ApproximateSearchEngine.a(this.this$0);
    if ((localISearchListener != null) && (localList != null)) {
      localISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */