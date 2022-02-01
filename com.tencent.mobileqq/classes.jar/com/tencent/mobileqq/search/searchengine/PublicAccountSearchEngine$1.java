package com.tencent.mobileqq.search.searchengine;

import java.util.List;

class PublicAccountSearchEngine$1
  implements Runnable
{
  PublicAccountSearchEngine$1(PublicAccountSearchEngine paramPublicAccountSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */