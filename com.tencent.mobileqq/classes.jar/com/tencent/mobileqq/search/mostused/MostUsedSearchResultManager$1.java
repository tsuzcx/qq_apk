package com.tencent.mobileqq.search.mostused;

import com.tencent.qphone.base.util.QLog;

class MostUsedSearchResultManager$1
  implements Runnable
{
  MostUsedSearchResultManager$1(MostUsedSearchResultManager paramMostUsedSearchResultManager, MostUsedSearchItem paramMostUsedSearchItem) {}
  
  public void run()
  {
    if (MostUsedSearchResultManager.a(this.this$0) != null)
    {
      MostUsedSearchResultManager.a(this.this$0).a(MostUsedSearchResultManager.a(this.this$0), this.a);
      MostUsedSearchResultManager.a(this.this$0).a(MostUsedSearchResultManager.a(this.this$0));
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
 * JD-Core Version:    0.7.0.1
 */