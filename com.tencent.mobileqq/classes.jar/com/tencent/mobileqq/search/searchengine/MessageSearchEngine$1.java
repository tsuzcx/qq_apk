package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;
import java.util.Observer;

class MessageSearchEngine$1
  implements Runnable
{
  MessageSearchEngine$1(MessageSearchEngine paramMessageSearchEngine, ISearchListener paramISearchListener, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null)
    {
      localObject = new MessageSearchEngine.1.1(this);
      this.this$0.a.addObserver((Observer)localObject);
    }
    else
    {
      localObject = null;
    }
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest);
    if (localObject != null) {
      this.this$0.a.deleteObserver((Observer)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
    if (localObject != null) {
      ((ISearchListener)localObject).a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */