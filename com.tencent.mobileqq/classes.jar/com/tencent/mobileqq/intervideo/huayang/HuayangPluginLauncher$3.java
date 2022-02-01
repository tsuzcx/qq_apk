package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;

class HuayangPluginLauncher$3
  implements Runnable
{
  private int a = 0;
  
  HuayangPluginLauncher$3(HuayangPluginLauncher paramHuayangPluginLauncher) {}
  
  public void run()
  {
    HuayangPluginLauncher.a(this.this$0, this.a);
    this.a += 20;
    if (this.a < 80) {
      HuayangPluginLauncher.a(this.this$0).postDelayed(this, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.3
 * JD-Core Version:    0.7.0.1
 */