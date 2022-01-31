package com.tencent.mobileqq.search.mostused;

import aypg;
import aypl;
import com.tencent.qphone.base.util.QLog;

public class MostUsedSearchResultManager$1
  implements Runnable
{
  public MostUsedSearchResultManager$1(aypl paramaypl, MostUsedSearchItem paramMostUsedSearchItem) {}
  
  public void run()
  {
    if (aypl.a(this.this$0) != null)
    {
      aypl.a(this.this$0).a(aypl.a(this.this$0), this.a);
      aypl.a(this.this$0).a(aypl.a(this.this$0));
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
 * JD-Core Version:    0.7.0.1
 */