package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import auod;

public class HuayangPluginLauncher$3
  implements Runnable
{
  private int a;
  
  public HuayangPluginLauncher$3(auod paramauod) {}
  
  public void run()
  {
    auod.a(this.this$0, this.a);
    this.a += 20;
    if (this.a < 80) {
      auod.a(this.this$0).postDelayed(this, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.3
 * JD-Core Version:    0.7.0.1
 */