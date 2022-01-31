package com.tencent.mobileqq.nearby.profilecard;

import ajjj;
import aste;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class NearbyProfileDisplayPanel$13
  implements Runnable
{
  public NearbyProfileDisplayPanel$13(aste paramaste) {}
  
  public void run()
  {
    Object localObject = (ajjj)this.this$0.a.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ajjj)localObject).b(this.this$0.a.getCurrentAccountUin()))
    {
      this.this$0.a.runOnUiThread(new NearbyProfileDisplayPanel.13.1(this, (Card)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13
 * JD-Core Version:    0.7.0.1
 */