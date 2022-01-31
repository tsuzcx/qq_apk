package com.tencent.mobileqq.nearby.profilecard;

import atqu;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayTribePanel$20
  implements Runnable
{
  public NearbyProfileDisplayTribePanel$20(atqu paramatqu) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localaukn != null)
    {
      localaukn.a(atqu.a(this.this$0));
      localaukn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20
 * JD-Core Version:    0.7.0.1
 */