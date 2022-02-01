package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

class FTSMessageSearchEngine$1
  implements Runnable
{
  FTSMessageSearchEngine$1(FTSMessageSearchEngine paramFTSMessageSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    if (SQLiteFTSUtils.g(FTSMessageSearchEngine.a(this.this$0)) == 1) {}
    for (List localList = this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, false);; localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, false))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */