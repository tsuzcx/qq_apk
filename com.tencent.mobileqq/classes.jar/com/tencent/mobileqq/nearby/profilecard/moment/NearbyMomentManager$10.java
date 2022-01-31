package com.tencent.mobileqq.nearby.profilecard.moment;

import atvs;
import atvz;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$10
  implements Runnable
{
  public NearbyMomentManager$10(atvs paramatvs, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = atvs.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((atvz)localIterator.next()).c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.10
 * JD-Core Version:    0.7.0.1
 */