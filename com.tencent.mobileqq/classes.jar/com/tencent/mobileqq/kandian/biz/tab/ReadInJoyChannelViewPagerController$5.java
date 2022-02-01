package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.ViewGroup;

class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  ReadInJoyChannelViewPagerController$5(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.a >= ReadInJoyChannelViewPagerController.h(this.this$0))
    {
      ReadInJoyChannelViewPagerController.c(this.this$0, this.b);
      ReadInJoyChannelViewPagerController.a(this.this$0, this.c, this.d);
      return;
    }
    ReadInJoyChannelViewPagerController.c(this.this$0, this.b - 1);
    ReadInJoyChannelViewPagerController.a(this.this$0, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */