package com.tencent.mobileqq.nearby.profilecard.moment;

import ayrf;
import ayrm;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$5
  implements Runnable
{
  public NearbyMomentManager$5(ayrf paramayrf, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = ayrf.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ((ayrm)localIterator.next()).a(this.a);
      ayrf.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5
 * JD-Core Version:    0.7.0.1
 */