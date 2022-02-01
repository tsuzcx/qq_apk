package com.tencent.mobileqq.profilecard.vas.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VasProfileQVipDiyView$2
  implements View.OnClickListener
{
  VasProfileQVipDiyView$2(VasProfileQVipDiyView paramVasProfileQVipDiyView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VasProfileQVipDiyView.access$1200(this.this$0, VasProfileQVipDiyView.access$1100(this.this$0));
      QVipUtils.a(VasProfileQVipDiyView.access$1300(this.this$0).a, VasProfileQVipDiyView.access$1400(this.this$0), VasProfileQVipDiyView.access$1500(this.this$0));
      ReportController.b(VasProfileQVipDiyView.access$1600(this.this$0), "dc00898", "", "", "qvip", "0X8009E7B", 0, 0, "", "", "", "");
      continue;
      VasProfileQVipDiyView.access$1200(this.this$0, VasProfileQVipDiyView.access$1100(this.this$0));
      ProfileCardUtil.b(VasProfileQVipDiyView.access$1700(this.this$0));
      ReportController.b(VasProfileQVipDiyView.access$1800(this.this$0), "dc00898", "", "", "qvip", "0X8009E7C", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.2
 * JD-Core Version:    0.7.0.1
 */