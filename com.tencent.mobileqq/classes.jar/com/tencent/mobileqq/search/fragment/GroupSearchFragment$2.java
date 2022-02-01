package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager;
import com.tencent.mobileqq.search.util.SearchCostStat;

class GroupSearchFragment$2
  implements Runnable
{
  GroupSearchFragment$2(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void run()
  {
    SearchCostStat.a("InitSearchEngine");
    this.this$0.g();
    SearchCostStat.b("InitSearchEngine");
    if (!GroupSearchFragment.a(this.this$0))
    {
      MostUsedSearchResultManager localMostUsedSearchResultManager = (MostUsedSearchResultManager)GroupSearchFragment.a(this.this$0).getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER);
      if (localMostUsedSearchResultManager != null) {
        localMostUsedSearchResultManager.a();
      }
      GroupSearchFragment.a(this.this$0, true);
    }
    this.this$0.b.removeMessages(100);
    this.this$0.b.sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */