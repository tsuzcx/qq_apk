package com.tencent.mobileqq.nearby.profilecard.moment;

import java.util.Iterator;
import java.util.List;

class NearbyMomentManager$6
  implements Runnable
{
  NearbyMomentManager$6(NearbyMomentManager paramNearbyMomentManager, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = NearbyMomentManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((NearbyMomentManager.MomentDataChangeObserver)localIterator.next()).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.6
 * JD-Core Version:    0.7.0.1
 */