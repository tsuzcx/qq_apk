package com.tencent.mobileqq.nearby.profilecard;

import atpi;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayPanel$25
  implements Runnable
{
  public NearbyProfileDisplayPanel$25(atpi paramatpi) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localaukn != null)
    {
      localaukn.a(atpi.a(this.this$0));
      localaukn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.25
 * JD-Core Version:    0.7.0.1
 */