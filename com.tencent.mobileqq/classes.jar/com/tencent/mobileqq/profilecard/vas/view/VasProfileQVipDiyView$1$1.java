package com.tencent.mobileqq.profilecard.vas.view;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class VasProfileQVipDiyView$1$1
  implements Runnable
{
  VasProfileQVipDiyView$1$1(VasProfileQVipDiyView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    AvatarPendantManager localAvatarPendantManager;
    if ((this.val$info != null) && (this.val$info.isPendantValid()))
    {
      this.this$1.val$mAvatarPendant.setVisibility(0);
      VasProfileQVipDiyView.access$102(this.this$1.this$0, this.val$info.pendantId);
      localAvatarPendantManager = (AvatarPendantManager)VasProfileQVipDiyView.access$200(this.this$1.this$0).getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (AvatarPendantUtil.a(VasProfileQVipDiyView.access$300(this.this$1.this$0))) {
        localAvatarPendantManager.a(VasProfileQVipDiyView.access$400(this.this$1.this$0)).a(this.this$1.val$mAvatarPendant, 2, PendantInfo.c, this.this$1.val$cardInfo.a.a, this.val$info.pendantDiyId);
      }
    }
    for (;;)
    {
      VasProfileQVipDiyView.access$700(this.this$1.this$0, this.val$info);
      return;
      localAvatarPendantManager.a(VasProfileQVipDiyView.access$500(this.this$1.this$0)).a(this.this$1.val$mAvatarPendant, 1, PendantInfo.c, this.this$1.val$cardInfo.a.a, this.val$info.pendantDiyId);
      continue;
      this.this$1.val$mAvatarPendant.setVisibility(8);
      VasProfileQVipDiyView.access$602(this.this$1.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1.1
 * JD-Core Version:    0.7.0.1
 */