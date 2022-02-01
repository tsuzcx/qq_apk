package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;

class ReadInJoyListViewGroup$9
  implements Runnable
{
  ReadInJoyListViewGroup$9(ReadInJoyListViewGroup paramReadInJoyListViewGroup, Runnable paramRunnable) {}
  
  public void run()
  {
    if ((UserReadUnReadInfoManager.a().b()) && (!this.this$0.r.a().h()))
    {
      this.this$0.a(false, 8);
      return;
    }
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup.9
 * JD-Core Version:    0.7.0.1
 */