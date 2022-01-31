package com.tencent.mobileqq.search.mostused;

import awps;
import awpx;
import com.tencent.qphone.base.util.QLog;

public class MostUsedSearchResultManager$1
  implements Runnable
{
  public MostUsedSearchResultManager$1(awpx paramawpx, MostUsedSearchItem paramMostUsedSearchItem) {}
  
  public void run()
  {
    if (awpx.a(this.this$0) != null)
    {
      awpx.a(this.this$0).a(awpx.a(this.this$0), this.a);
      awpx.a(this.this$0).a(awpx.a(this.this$0));
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
 * JD-Core Version:    0.7.0.1
 */