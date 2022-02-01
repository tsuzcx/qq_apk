package com.tencent.mobileqq.filemanager.data.search.selector;

import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.ArrayList;
import java.util.List;

class FileSelectorSearchEngine$SearchRunnable
  implements Runnable
{
  ISearchListener<FileSelectorSearchResultModel> jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  SearchRequest jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
  
  private FileSelectorSearchEngine$SearchRunnable(FileSelectorSearchEngine paramFileSelectorSearchEngine) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(new ArrayList(), 6);
        return;
      }
      SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
      String str = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a;
      List localList = this.this$0.a(localSearchRequest);
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (localSearchRequest == this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a))) {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */