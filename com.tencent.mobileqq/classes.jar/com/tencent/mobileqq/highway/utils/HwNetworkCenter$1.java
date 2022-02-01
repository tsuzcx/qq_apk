package com.tencent.mobileqq.highway.utils;

import android.os.Handler;

class HwNetworkCenter$1
  implements Runnable
{
  HwNetworkCenter$1(HwNetworkCenter paramHwNetworkCenter) {}
  
  public void run()
  {
    HwNetworkCenter localHwNetworkCenter = this.this$0;
    localHwNetworkCenter.onNetChange(HwNetworkCenter.access$000(localHwNetworkCenter));
    HwNetworkCenter.access$100(this.this$0).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkCenter.1
 * JD-Core Version:    0.7.0.1
 */