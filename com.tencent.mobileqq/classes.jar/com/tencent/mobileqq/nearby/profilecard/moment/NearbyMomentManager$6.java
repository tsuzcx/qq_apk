package com.tencent.mobileqq.nearby.profilecard.moment;

import atvq;
import atvx;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$6
  implements Runnable
{
  public NearbyMomentManager$6(atvq paramatvq, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = atvq.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((atvx)localIterator.next()).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.6
 * JD-Core Version:    0.7.0.1
 */