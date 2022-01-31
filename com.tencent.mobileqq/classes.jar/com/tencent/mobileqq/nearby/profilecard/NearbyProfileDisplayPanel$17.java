package com.tencent.mobileqq.nearby.profilecard;

import avkt;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayPanel$17
  implements Runnable
{
  public void run()
  {
    awgf localawgf = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localawgf != null)
    {
      localawgf.a(avkt.a(this.this$0));
      localawgf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.17
 * JD-Core Version:    0.7.0.1
 */