package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;

class ReadInJoyChannelViewPagerController$8
  implements Runnable
{
  ReadInJoyChannelViewPagerController$8(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, View paramView1, View paramView2) {}
  
  public void run()
  {
    if (this.this$0.d() != 0)
    {
      View localView = this.a;
      if (localView != null) {
        localView.findViewById(2131436062).setVisibility(4);
      }
      localView = this.b;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.8
 * JD-Core Version:    0.7.0.1
 */