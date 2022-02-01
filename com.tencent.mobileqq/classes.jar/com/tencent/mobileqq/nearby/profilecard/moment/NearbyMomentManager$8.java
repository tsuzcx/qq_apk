package com.tencent.mobileqq.nearby.profilecard.moment;

import java.util.Iterator;
import java.util.List;

class NearbyMomentManager$8
  implements Runnable
{
  NearbyMomentManager$8(NearbyMomentManager paramNearbyMomentManager, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = NearbyMomentManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((NearbyMomentManager.MomentDataChangeObserver)localIterator.next()).b(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.8
 * JD-Core Version:    0.7.0.1
 */