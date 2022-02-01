package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.ArrayList;
import java.util.List;

class ChatFileManagerSearchEngine$SearchRunnable
  implements Runnable
{
  ISearchListener<ChatFileEntitySearchResultModel> jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  SearchRequest jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
  
  private ChatFileManagerSearchEngine$SearchRunnable(ChatFileManagerSearchEngine paramChatFileManagerSearchEngine) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */