package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

class NearbyProfileDisplayPanel$15
  implements Runnable
{
  NearbyProfileDisplayPanel$15(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.this$0.e.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FriendsManager)localObject).f(this.this$0.e.getCurrentAccountUin());
    }
    this.this$0.e.runOnUiThread(new NearbyProfileDisplayPanel.15.1(this, (Card)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.15
 * JD-Core Version:    0.7.0.1
 */