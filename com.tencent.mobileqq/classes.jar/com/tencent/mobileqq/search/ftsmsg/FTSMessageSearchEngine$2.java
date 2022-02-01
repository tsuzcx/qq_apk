package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import java.util.List;

class FTSMessageSearchEngine$2
  implements Runnable
{
  FTSMessageSearchEngine$2(FTSMessageSearchEngine paramFTSMessageSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    List localList = this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest);
    ISearchListener localISearchListener = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
    if (localISearchListener != null) {
      localISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */