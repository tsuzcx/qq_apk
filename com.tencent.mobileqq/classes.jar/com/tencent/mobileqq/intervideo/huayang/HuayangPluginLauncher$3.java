package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import arge;

public class HuayangPluginLauncher$3
  implements Runnable
{
  private int a;
  
  public HuayangPluginLauncher$3(arge paramarge) {}
  
  public void run()
  {
    arge.a(this.this$0, this.a);
    this.a += 20;
    if (this.a < 80) {
      arge.a(this.this$0).postDelayed(this, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.3
 * JD-Core Version:    0.7.0.1
 */