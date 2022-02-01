package com.tencent.mobileqq.qqguildsdk.search.selector;

import android.os.Handler;
import com.tencent.mobileqq.qqguildsdk.search.model.SearchRequestModel;
import java.util.List;

class SearchEngine$1
  implements Runnable
{
  SearchEngine$1(SearchEngine paramSearchEngine) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((SearchEngine)localObject).a(new SearchRequestModel(((SearchEngine)localObject).c, this.this$0.d));
    this.this$0.b.post(new SearchEngine.1.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.SearchEngine.1
 * JD-Core Version:    0.7.0.1
 */