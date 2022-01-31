package com.tencent.mobileqq.highway.utils;

import android.os.Handler;

class HwNetworkCenter$1
  implements Runnable
{
  HwNetworkCenter$1(HwNetworkCenter paramHwNetworkCenter) {}
  
  public void run()
  {
    this.this$0.onNetChange(HwNetworkCenter.access$000(this.this$0));
    HwNetworkCenter.access$100(this.this$0).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkCenter.1
 * JD-Core Version:    0.7.0.1
 */