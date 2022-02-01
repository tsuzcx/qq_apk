package com.tencent.mobileqq.profilecard.base.view;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
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
    Object localObject = this.val$info;
    if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
    {
      ProfileBaseView.access$000(this.this$1.this$0).setVisibility(0);
      this.this$1.this$0.mPendantId = this.val$info.pendantId;
      localObject = (AvatarPendantManager)this.this$1.this$0.mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (AvatarPendantUtil.a(this.this$1.this$0.mPendantId)) {
        ((AvatarPendantManager)localObject).a(this.this$1.this$0.mPendantId).a(ProfileBaseView.access$000(this.this$1.this$0), 2, PendantInfo.d, this.this$1.val$cardInfo.allInOne.uin, this.val$info.pendantDiyId);
      } else {
        ((AvatarPendantManager)localObject).a(this.this$1.this$0.mPendantId).a(ProfileBaseView.access$000(this.this$1.this$0), 1, PendantInfo.d, this.this$1.val$cardInfo.allInOne.uin, this.val$info.pendantDiyId);
      }
      if (this.this$1.val$isInit) {
        ReportController.b(this.this$1.this$0.mApp, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
      }
    }
    else
    {
      ProfileBaseView.access$000(this.this$1.this$0).setVisibility(4);
      this.this$1.this$0.mPendantId = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1.1
 * JD-Core Version:    0.7.0.1
 */