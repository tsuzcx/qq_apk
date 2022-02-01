package com.tencent.mobileqq.nearby.profilecard.moment;

import java.util.Iterator;
import java.util.List;

class NearbyMomentManager$5
  implements Runnable
{
  NearbyMomentManager$5(NearbyMomentManager paramNearbyMomentManager, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = NearbyMomentManager.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ((NearbyMomentManager.MomentDataChangeObserver)localIterator.next()).a(this.a);
      NearbyMomentManager.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
 * JD-Core Version:    0.7.0.1
 */