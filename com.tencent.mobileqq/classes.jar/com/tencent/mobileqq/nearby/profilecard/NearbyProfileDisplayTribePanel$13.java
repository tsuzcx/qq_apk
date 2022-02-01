package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

class NearbyProfileDisplayTribePanel$13
  implements Runnable
{
  NearbyProfileDisplayTribePanel$13(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.this$0.e.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FriendsManager)localObject).f(this.this$0.e.getCurrentAccountUin());
    }
    this.this$0.e.runOnUiThread(new NearbyProfileDisplayTribePanel.13.1(this, (Card)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13
 * JD-Core Version:    0.7.0.1
 */