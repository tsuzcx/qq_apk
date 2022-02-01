package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils.Companion;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import java.util.List;

class ProfileContentSignComponent$3
  implements Runnable
{
  ProfileContentSignComponent$3(ProfileContentSignComponent paramProfileContentSignComponent, TextView paramTextView, RichStatus paramRichStatus) {}
  
  public void run()
  {
    int i;
    if ((ProfileContentSignComponent.access$2200(this.this$0) != null) && (!ProfileContentSignComponent.access$2300(this.this$0).isFinishing()))
    {
      i = SigTopicManager.a().a(this.val$info, (String)((Pair)this.val$richStatus.topics.get(0)).second, this.val$richStatus.actionText, ProfileContentSignComponent.access$1800(this.this$0), ProfileContentSignComponent.access$1900(this.this$0), ProfileContentSignComponent.access$2000(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    UiUtils.Companion.showProfileSignGuideAsDropDown(this.val$info, -i, 0);
    SigTopicManager.a().a(ProfileContentSignComponent.access$2400(this.this$0));
    ReportController.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.3
 * JD-Core Version:    0.7.0.1
 */