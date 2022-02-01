package com.tencent.mobileqq.search.mostused;

import bbok;
import bbop;
import com.tencent.qphone.base.util.QLog;

public class MostUsedSearchResultManager$1
  implements Runnable
{
  public MostUsedSearchResultManager$1(bbop parambbop, MostUsedSearchItem paramMostUsedSearchItem) {}
  
  public void run()
  {
    if (bbop.a(this.this$0) != null)
    {
      bbop.a(this.this$0).a(bbop.a(this.this$0), this.a);
      bbop.a(this.this$0).a(bbop.a(this.this$0));
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
 * JD-Core Version:    0.7.0.1
 */