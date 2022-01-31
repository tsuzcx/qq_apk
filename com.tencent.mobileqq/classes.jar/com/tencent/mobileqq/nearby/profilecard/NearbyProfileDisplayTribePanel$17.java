package com.tencent.mobileqq.nearby.profilecard;

import atqu;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayTribePanel$17
  implements Runnable
{
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
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.17
 * JD-Core Version:    0.7.0.1
 */