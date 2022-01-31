package com.tencent.mobileqq.nearby.profilecard.moment;

import atvq;
import atvx;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$5
  implements Runnable
{
  public NearbyMomentManager$5(atvq paramatvq, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = atvq.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ((atvx)localIterator.next()).a(this.a);
      atvq.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
 * JD-Core Version:    0.7.0.1
 */