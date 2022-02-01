package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

class NearbyProfileDisplayPanel$13
  implements Runnable
{
  NearbyProfileDisplayPanel$13(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.this$0.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FriendsManager)localObject).a(this.this$0.a.getCurrentAccountUin());
    }
    this.this$0.a.runOnUiThread(new NearbyProfileDisplayPanel.13.1(this, (Card)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13
 * JD-Core Version:    0.7.0.1
 */