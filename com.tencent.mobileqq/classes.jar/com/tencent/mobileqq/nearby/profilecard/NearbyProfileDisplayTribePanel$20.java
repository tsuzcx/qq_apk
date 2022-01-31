package com.tencent.mobileqq.nearby.profilecard;

import avhw;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayTribePanel$20
  implements Runnable
{
  public NearbyProfileDisplayTribePanel$20(avhw paramavhw) {}
  
  public void run()
  {
    awbw localawbw = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localawbw != null)
    {
      localawbw.a(avhw.a(this.this$0));
      localawbw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20
 * JD-Core Version:    0.7.0.1
 */