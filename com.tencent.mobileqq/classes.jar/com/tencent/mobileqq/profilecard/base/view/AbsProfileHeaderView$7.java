package com.tencent.mobileqq.profilecard.base.view;

import android.os.Message;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.util.MqqWeakReferenceHandler;

class AbsProfileHeaderView$7
  implements Runnable
{
  AbsProfileHeaderView$7(AbsProfileHeaderView paramAbsProfileHeaderView, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.this$0.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.val$cardInfo.allInOne.uin);
    Message localMessage = this.this$0.mUIHandler.obtainMessage(1003, localExtensionInfo);
    this.this$0.mUIHandler.sendMessage(localMessage);
    if ((this.val$isInit) && (localExtensionInfo != null) && (AvatarPendantUtil.b(localExtensionInfo.pendantId))) {
      AvatarPendantUtil.a(this.this$0.mApp, this.val$cardInfo.allInOne.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.7
 * JD-Core Version:    0.7.0.1
 */