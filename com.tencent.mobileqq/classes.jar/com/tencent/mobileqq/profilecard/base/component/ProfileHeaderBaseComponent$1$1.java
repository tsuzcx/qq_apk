package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class ProfileHeaderBaseComponent$1$1
  implements Runnable
{
  ProfileHeaderBaseComponent$1$1(ProfileHeaderBaseComponent.1 param1) {}
  
  public void run()
  {
    try
    {
      ((FriendsManager)ProfileHeaderBaseComponent.access$700(this.this$1.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(((ProfileCardInfo)ProfileHeaderBaseComponent.access$800(this.this$1.this$0)).card);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.1.1
 * JD-Core Version:    0.7.0.1
 */