package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;

class PublicAccountSearchEngine$1
  implements Runnable
{
  PublicAccountSearchEngine$1(PublicAccountSearchEngine paramPublicAccountSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.a);
    ISearchListener localISearchListener = this.b;
    if (localISearchListener != null) {
      localISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */