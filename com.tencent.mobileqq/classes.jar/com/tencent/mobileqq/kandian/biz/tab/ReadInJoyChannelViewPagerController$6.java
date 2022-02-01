package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.ViewGroup;

class ReadInJoyChannelViewPagerController$6
  implements Runnable
{
  ReadInJoyChannelViewPagerController$6(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, float paramFloat, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2) {}
  
  public void run()
  {
    if (this.a >= 1.0F - ReadInJoyChannelViewPagerController.h(this.this$0))
    {
      ReadInJoyChannelViewPagerController.c(this.this$0, this.b);
      ReadInJoyChannelViewPagerController.a(this.this$0, this.c, this.d);
      return;
    }
    ReadInJoyChannelViewPagerController.c(this.this$0, this.e);
    ReadInJoyChannelViewPagerController.a(this.this$0, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.6
 * JD-Core Version:    0.7.0.1
 */