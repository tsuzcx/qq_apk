package com.tencent.mobileqq.profilecard.vas.view;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import mqq.os.MqqHandler;

class VasProfileQVipV5View$1
  implements Runnable
{
  VasProfileQVipV5View$1(VasProfileQVipV5View paramVasProfileQVipV5View, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)VasProfileQVipV5View.access$000(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.val$cardInfo.allInOne.uin);
    VasProfileQVipV5View.1.1 local1 = new VasProfileQVipV5View.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.val$isInit) && (localExtensionInfo != null) && (AvatarPendantUtil.b(localExtensionInfo.pendantId)))
    {
      VasProfileQVipV5View.access$1000(this.this$0).addObserver(VasProfileQVipV5View.access$900(this.this$0));
      AvatarPendantUtil.a(VasProfileQVipV5View.access$1100(this.this$0), this.val$cardInfo.allInOne.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View.1
 * JD-Core Version:    0.7.0.1
 */