package com.tencent.mobileqq.profilecard.vas.view;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import mqq.os.MqqHandler;

class VasProfileQVipDiyView$1
  implements Runnable
{
  VasProfileQVipDiyView$1(VasProfileQVipDiyView paramVasProfileQVipDiyView, ProfileCardInfo paramProfileCardInfo, ImageView paramImageView, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)VasProfileQVipDiyView.access$000(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.val$cardInfo.a.a);
    VasProfileQVipDiyView.1.1 local1 = new VasProfileQVipDiyView.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.val$isInit) && (localExtensionInfo != null) && (AvatarPendantUtil.b(localExtensionInfo.pendantId)))
    {
      VasProfileQVipDiyView.access$900(this.this$0).addObserver(VasProfileQVipDiyView.access$800(this.this$0));
      AvatarPendantUtil.a(VasProfileQVipDiyView.access$1000(this.this$0), this.val$cardInfo.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1
 * JD-Core Version:    0.7.0.1
 */