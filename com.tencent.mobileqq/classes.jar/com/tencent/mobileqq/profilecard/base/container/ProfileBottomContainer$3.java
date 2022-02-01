package com.tencent.mobileqq.profilecard.base.container;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportTask;

class ProfileBottomContainer$3
  implements DialogInterface.OnClickListener
{
  ProfileBottomContainer$3(ProfileBottomContainer paramProfileBottomContainer) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ProfileBottomContainer.access$1300(this.this$0);
    if (((ProfileCardInfo)ProfileBottomContainer.access$1400(this.this$0)).isTroopMemberCard) {
      new ReportTask(this.this$0.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { ((ProfileCardInfo)ProfileBottomContainer.access$1500(this.this$0)).troopUin }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.3
 * JD-Core Version:    0.7.0.1
 */