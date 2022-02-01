package com.tencent.mobileqq.filemanager.data.search.selector;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

class FileSelectorSearchEngine$SearchRunnable
  implements Runnable
{
  SearchRequest a;
  ISearchListener<FileSelectorSearchResultModel> b;
  
  private FileSelectorSearchEngine$SearchRunnable(FileSelectorSearchEngine paramFileSelectorSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.a == null)
      {
        this.b.a(new ArrayList(), 6);
        return;
      }
      SearchRequest localSearchRequest = this.a;
      String str = this.a.a;
      List localList = this.this$0.a(localSearchRequest);
      try
      {
        if ((this.b != null) && (localSearchRequest == this.a) && (str.equals(this.a.a))) {
          this.b.a(localList, 1);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */