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
    if (SQLiteFTSUtils.e(FTSMessageSearchEngine.a(this.this$0)) == 1) {
      localList = this.this$0.b(this.a, false);
    } else {
      localList = this.this$0.a(this.a, false);
    }
    ISearchListener localISearchListener = this.b;
    if (localISearchListener != null) {
      localISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */