package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils.Companion;
import com.tencent.mobileqq.statistics.ReportController;

class ProfileContentSignComponent$2
  implements Runnable
{
  ProfileContentSignComponent$2(ProfileContentSignComponent paramProfileContentSignComponent) {}
  
  public void run()
  {
    int i;
    if ((ProfileContentSignComponent.access$1300(this.this$0) != null) && (!ProfileContentSignComponent.access$1400(this.this$0).isFinishing()))
    {
      i = SigTopicManager.a().a(ProfileContentSignComponent.access$1500(this.this$0), ProfileContentSignComponent.access$1600(this.this$0), ProfileContentSignComponent.access$1700(this.this$0), ProfileContentSignComponent.access$1800(this.this$0), ProfileContentSignComponent.access$1900(this.this$0), ProfileContentSignComponent.access$2000(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    UiUtils.Companion.showProfileSignGuideAsDropDown(ProfileContentSignComponent.access$1500(this.this$0), -i, 0);
    SigTopicManager.a().a(ProfileContentSignComponent.access$2100(this.this$0));
    ReportController.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.2
 * JD-Core Version:    0.7.0.1
 */