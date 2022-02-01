package com.tencent.mobileqq.filemanager.data.search.selector;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

class FileSelectorSearchEngine$SearchRunnable
  implements Runnable
{
  ISearchListener<FileSelectorSearchResultModel> jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
  SearchRequest jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest;
  
  private FileSelectorSearchEngine$SearchRunnable(FileSelectorSearchEngine paramFileSelectorSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(new ArrayList(), 6);
        return;
      }
      SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest;
      String str = this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.a;
      List localList = this.this$0.a(localSearchRequest);
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null) && (localSearchRequest == this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.a))) {
          this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localList, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */