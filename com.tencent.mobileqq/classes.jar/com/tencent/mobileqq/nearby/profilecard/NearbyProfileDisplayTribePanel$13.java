package com.tencent.mobileqq.nearby.profilecard;

import ajxl;
import atqw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class NearbyProfileDisplayTribePanel$13
  implements Runnable
{
  public NearbyProfileDisplayTribePanel$13(atqw paramatqw) {}
  
  public void run()
  {
    Object localObject = (ajxl)this.this$0.a.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ajxl)localObject).b(this.this$0.a.getCurrentAccountUin()))
    {
      this.this$0.a.runOnUiThread(new NearbyProfileDisplayTribePanel.13.1(this, (Card)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13
 * JD-Core Version:    0.7.0.1
 */