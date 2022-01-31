package com.tencent.mobileqq.nearby.profilecard;

import atpk;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayPanel$25
  implements Runnable
{
  public NearbyProfileDisplayPanel$25(atpk paramatpk) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localaukp != null)
    {
      localaukp.a(atpk.a(this.this$0));
      localaukp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.25
 * JD-Core Version:    0.7.0.1
 */