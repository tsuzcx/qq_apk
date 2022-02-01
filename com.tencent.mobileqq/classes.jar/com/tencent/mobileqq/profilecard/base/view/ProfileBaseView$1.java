package com.tencent.mobileqq.profilecard.base.view;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import mqq.os.MqqHandler;

class ProfileBaseView$1
  implements Runnable
{
  ProfileBaseView$1(ProfileBaseView paramProfileBaseView, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.this$0.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.val$cardInfo.allInOne.uin);
    ProfileBaseView.1.1 local1 = new ProfileBaseView.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.val$isInit) && (localExtensionInfo != null) && (AvatarPendantUtil.b(localExtensionInfo.pendantId)))
    {
      this.this$0.mApp.addObserver(this.this$0.mDiyPendantObserver);
      AvatarPendantUtil.a(this.this$0.mApp, this.val$cardInfo.allInOne.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1
 * JD-Core Version:    0.7.0.1
 */