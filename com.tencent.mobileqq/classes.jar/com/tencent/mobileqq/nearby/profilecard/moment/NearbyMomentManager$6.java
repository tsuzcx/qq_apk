package com.tencent.mobileqq.nearby.profilecard.moment;

import axyl;
import axys;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$6
  implements Runnable
{
  public NearbyMomentManager$6(axyl paramaxyl, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = axyl.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((axys)localIterator.next()).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.6
 * JD-Core Version:    0.7.0.1
 */