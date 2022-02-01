package com.tencent.mobileqq.nearby;

import axpo;
import axqc;

public final class NearbyProcessMonitor$1
  implements Runnable
{
  public NearbyProcessMonitor$1(String paramString) {}
  
  public void run()
  {
    axpo.b(this.a);
    axpo.a(this.a);
    axpo.a += 1;
    axqc.b(this.a);
    axpo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProcessMonitor.1
 * JD-Core Version:    0.7.0.1
 */