package com.tencent.mobileqq.profilecard.vas.view;

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

class VasProfileQVipV5View$1$1
  implements Runnable
{
  VasProfileQVipV5View$1$1(VasProfileQVipV5View.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    Object localObject = this.val$info;
    if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
    {
      VasProfileQVipV5View.access$100(this.this$1.this$0).setVisibility(0);
      VasProfileQVipV5View.access$202(this.this$1.this$0, this.val$info.pendantId);
      localObject = (AvatarPendantManager)VasProfileQVipV5View.access$300(this.this$1.this$0).getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (AvatarPendantUtil.a(VasProfileQVipV5View.access$400(this.this$1.this$0))) {
        ((AvatarPendantManager)localObject).a(VasProfileQVipV5View.access$500(this.this$1.this$0)).a(VasProfileQVipV5View.access$100(this.this$1.this$0), 2, PendantInfo.c, this.this$1.val$cardInfo.allInOne.uin, this.val$info.pendantDiyId);
      } else {
        ((AvatarPendantManager)localObject).a(VasProfileQVipV5View.access$600(this.this$1.this$0)).a(VasProfileQVipV5View.access$100(this.this$1.this$0), 1, PendantInfo.c, this.this$1.val$cardInfo.allInOne.uin, this.val$info.pendantDiyId);
      }
      if (this.this$1.val$isInit) {
        ReportController.b(VasProfileQVipV5View.access$700(this.this$1.this$0), "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
      }
    }
    else
    {
      VasProfileQVipV5View.access$100(this.this$1.this$0).setVisibility(8);
      VasProfileQVipV5View.access$802(this.this$1.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View.1.1
 * JD-Core Version:    0.7.0.1
 */