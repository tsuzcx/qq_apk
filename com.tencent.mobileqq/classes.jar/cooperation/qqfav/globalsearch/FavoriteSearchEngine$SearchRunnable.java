package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  SearchRequest a;
  ISearchListener<FavoriteSearchResultModel> b;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    SearchRequest localSearchRequest = this.a;
    String str = localSearchRequest.a;
    List localList = this.this$0.a(localSearchRequest);
    try
    {
      if ((this.b != null) && (localSearchRequest == this.a) && (str.equals(this.a.a))) {
        this.b.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */