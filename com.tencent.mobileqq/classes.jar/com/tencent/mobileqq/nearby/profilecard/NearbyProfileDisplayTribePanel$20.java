package com.tencent.mobileqq.nearby.profilecard;

import atqw;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayTribePanel$20
  implements Runnable
{
  public NearbyProfileDisplayTribePanel$20(atqw paramatqw) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localaukp != null)
    {
      localaukp.a(atqw.a(this.this$0));
      localaukp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20
 * JD-Core Version:    0.7.0.1
 */