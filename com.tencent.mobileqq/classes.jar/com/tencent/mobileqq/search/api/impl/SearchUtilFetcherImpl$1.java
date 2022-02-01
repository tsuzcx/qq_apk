package com.tencent.mobileqq.search.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.qphone.base.util.QLog;

class SearchUtilFetcherImpl$1
  implements Runnable
{
  SearchUtilFetcherImpl$1(SearchUtilFetcherImpl paramSearchUtilFetcherImpl, String paramString1, int paramInt, String paramString2, String paramString3, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveSearchHistory, displayName:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.uniteSearch.SearchUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new SearchHistory();
    ((SearchHistory)localObject).type = this.b;
    ((SearchHistory)localObject).uin = this.c;
    ((SearchHistory)localObject).troopUin = this.d;
    ((SearchHistory)localObject).displayName = this.a;
    SearchHistoryManager localSearchHistoryManager = (SearchHistoryManager)this.e.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
    if (localSearchHistoryManager == null) {
      return;
    }
    localSearchHistoryManager.b((SearchHistory)localObject);
    com.tencent.mobileqq.search.activity.UniteSearchActivity.n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.SearchUtilFetcherImpl.1
 * JD-Core Version:    0.7.0.1
 */