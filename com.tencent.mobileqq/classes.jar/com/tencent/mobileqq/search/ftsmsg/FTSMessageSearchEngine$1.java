package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

class FTSMessageSearchEngine$1
  implements Runnable
{
  FTSMessageSearchEngine$1(FTSMessageSearchEngine paramFTSMessageSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    List localList;
    if (SQLiteFTSUtils.b(FTSMessageSearchEngine.a(this.this$0)) == 1) {
      localList = this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest, false);
    } else {
      localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest, false);
    }
    ISearchListener localISearchListener = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
    if (localISearchListener != null) {
      localISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */