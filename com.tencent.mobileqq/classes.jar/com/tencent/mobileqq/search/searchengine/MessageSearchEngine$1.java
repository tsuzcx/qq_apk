package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import java.util.List;

class MessageSearchEngine$1
  implements Runnable
{
  MessageSearchEngine$1(MessageSearchEngine paramMessageSearchEngine, ISearchListener paramISearchListener, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    MessageSearchEngine.1.1 local1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null)
    {
      local1 = new MessageSearchEngine.1.1(this);
      this.this$0.a.addObserver(local1);
    }
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (local1 != null) {
      this.this$0.a.deleteObserver(local1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */