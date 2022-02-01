package com.tencent.mobileqq.search.mostused;

import bbaf;
import bbak;
import com.tencent.qphone.base.util.QLog;

public class MostUsedSearchResultManager$1
  implements Runnable
{
  public MostUsedSearchResultManager$1(bbak parambbak, MostUsedSearchItem paramMostUsedSearchItem) {}
  
  public void run()
  {
    if (bbak.a(this.this$0) != null)
    {
      bbak.a(this.this$0).a(bbak.a(this.this$0), this.a);
      bbak.a(this.this$0).a(bbak.a(this.this$0));
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
 * JD-Core Version:    0.7.0.1
 */