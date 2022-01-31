package com.tencent.mobileqq.nearby.profilecard.moment;

import avms;
import avmz;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$5
  implements Runnable
{
  public NearbyMomentManager$5(avms paramavms, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = avms.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ((avmz)localIterator.next()).a(this.a);
      avms.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
 * JD-Core Version:    0.7.0.1
 */