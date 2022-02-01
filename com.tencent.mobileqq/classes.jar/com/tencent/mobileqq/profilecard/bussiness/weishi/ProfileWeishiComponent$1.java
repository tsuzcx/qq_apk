package com.tencent.mobileqq.profilecard.bussiness.weishi;

import com.tencent.biz.videostory.widget.view.MineWSPanel.ProcessClickListener;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;

class ProfileWeishiComponent$1
  implements MineWSPanel.ProcessClickListener
{
  ProfileWeishiComponent$1(ProfileWeishiComponent paramProfileWeishiComponent) {}
  
  public void processClickEvent()
  {
    ProfileCardReport.reportWeiShiClick(ProfileWeishiComponent.access$000(this.this$0), (ProfileCardInfo)ProfileWeishiComponent.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent.1
 * JD-Core Version:    0.7.0.1
 */