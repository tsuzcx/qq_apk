package com.tencent.mobileqq.nearby.profilecard;

import avmf;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayTribePanel$20
  implements Runnable
{
  public NearbyProfileDisplayTribePanel$20(avmf paramavmf) {}
  
  public void run()
  {
    awgf localawgf = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localawgf != null)
    {
      localawgf.a(avmf.a(this.this$0));
      localawgf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20
 * JD-Core Version:    0.7.0.1
 */