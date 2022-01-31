package com.tencent.mobileqq.nearby.profilecard.moment;

import aszm;
import aszt;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$5
  implements Runnable
{
  public NearbyMomentManager$5(aszm paramaszm, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = aszm.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ((aszt)localIterator.next()).a(this.a);
      aszm.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
 * JD-Core Version:    0.7.0.1
 */