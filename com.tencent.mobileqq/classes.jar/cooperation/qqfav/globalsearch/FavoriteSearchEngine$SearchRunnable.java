package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  ISearchListener<FavoriteSearchResultModel> jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
  SearchRequest jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest;
    String str = localSearchRequest.a;
    List localList = this.this$0.a(localSearchRequest);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null) && (localSearchRequest == this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.a))) {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */