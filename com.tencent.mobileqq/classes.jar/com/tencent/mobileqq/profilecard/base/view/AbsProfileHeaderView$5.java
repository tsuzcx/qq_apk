package com.tencent.mobileqq.profilecard.base.view;

import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils.Companion;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

class AbsProfileHeaderView$5
  implements Runnable
{
  AbsProfileHeaderView$5(AbsProfileHeaderView paramAbsProfileHeaderView, RichStatus paramRichStatus, TextView paramTextView, int paramInt) {}
  
  public void run()
  {
    String str;
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()))
    {
      if ((this.val$status.plainText == null) || (this.val$status.plainText.size() <= 0)) {
        break label172;
      }
      str = (String)this.val$status.plainText.get(0);
      this.val$status.sortTopicPos();
      if ((this.val$status.topicsPos == null) || (this.val$status.topicsPos.size() <= 0)) {
        break label177;
      }
    }
    label172:
    label177:
    for (int i = ((Integer)((Pair)this.val$status.topicsPos.get(0)).second).intValue();; i = 0)
    {
      i = SigTopicManager.a().a(this.val$signView, (String)((Pair)this.val$status.topics.get(0)).second, this.val$status.actionText, this.val$drawableSize, str, i);
      if (i != -2147483648) {
        break label182;
      }
      return;
      str = null;
      break;
    }
    label182:
    UiUtils.Companion.showProfileSignGuideAsDropDown(this.val$signView, -i, 0);
    SigTopicManager.a().a(this.this$0.mApp);
    ReportController.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.5
 * JD-Core Version:    0.7.0.1
 */