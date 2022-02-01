package com.tencent.mobileqq.nearby.profilecard.moment;

import axen;
import axeu;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$5
  implements Runnable
{
  public NearbyMomentManager$5(axen paramaxen, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = axen.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ((axeu)localIterator.next()).a(this.a);
      axen.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
 * JD-Core Version:    0.7.0.1
 */