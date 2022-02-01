package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.mobileqq.activity.SplashActivity;

class ReadInJoyListViewGroup$5
  implements Runnable
{
  ReadInJoyListViewGroup$5(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if ((this.this$0.a == 0) && ((this.this$0.getCurrentActivity() instanceof SplashActivity))) {
      com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager.j = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup.5
 * JD-Core Version:    0.7.0.1
 */