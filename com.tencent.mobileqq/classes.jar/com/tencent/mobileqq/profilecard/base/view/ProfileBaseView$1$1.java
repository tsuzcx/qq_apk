package com.tencent.mobileqq.profilecard.base.view;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class ProfileBaseView$1$1
  implements Runnable
{
  ProfileBaseView$1$1(ProfileBaseView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    if ((this.val$info != null) && (this.val$info.isPendantValid()))
    {
      ProfileBaseView.access$000(this.this$1.this$0).setVisibility(0);
      this.this$1.this$0.mPendantId = this.val$info.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.this$1.this$0.mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (AvatarPendantUtil.a(this.this$1.this$0.mPendantId)) {
        localAvatarPendantManager.a(this.this$1.this$0.mPendantId).a(ProfileBaseView.access$000(this.this$1.this$0), 2, PendantInfo.c, this.this$1.val$cardInfo.a.a, this.val$info.pendantDiyId);
      }
      for (;;)
      {
        if (this.this$1.val$isInit) {
          ReportController.b(this.this$1.this$0.mApp, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        }
        return;
        localAvatarPendantManager.a(this.this$1.this$0.mPendantId).a(ProfileBaseView.access$000(this.this$1.this$0), 1, PendantInfo.c, this.this$1.val$cardInfo.a.a, this.val$info.pendantDiyId);
      }
    }
    ProfileBaseView.access$000(this.this$1.this$0).setVisibility(4);
    this.this$1.this$0.mPendantId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1.1
 * JD-Core Version:    0.7.0.1
 */