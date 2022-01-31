package com.tencent.mobileqq.nearby.profilecard;

import asuq;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayTribePanel$17
  implements Runnable
{
  public void run()
  {
    atmp localatmp = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localatmp != null)
    {
      localatmp.a(asuq.a(this.this$0));
      localatmp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.17
 * JD-Core Version:    0.7.0.1
 */