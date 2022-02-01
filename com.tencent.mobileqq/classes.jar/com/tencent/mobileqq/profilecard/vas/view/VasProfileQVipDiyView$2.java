package com.tencent.mobileqq.profilecard.vas.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
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
    VasProfileQVipDiyView localVasProfileQVipDiyView;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131374931: 
      localVasProfileQVipDiyView = this.this$0;
      VasProfileQVipDiyView.access$1200(localVasProfileQVipDiyView, VasProfileQVipDiyView.access$1100(localVasProfileQVipDiyView));
      QVipUtils.a(VasProfileQVipDiyView.access$1300(this.this$0).card, VasProfileQVipDiyView.access$1400(this.this$0), VasProfileQVipDiyView.access$1500(this.this$0));
      ReportController.b(VasProfileQVipDiyView.access$1600(this.this$0), "dc00898", "", "", "qvip", "0X8009E7B", 0, 0, "", "", "", "");
      break;
    case 2131374930: 
      localVasProfileQVipDiyView = this.this$0;
      VasProfileQVipDiyView.access$1200(localVasProfileQVipDiyView, VasProfileQVipDiyView.access$1100(localVasProfileQVipDiyView));
      ProfileCardUtil.a(VasProfileQVipDiyView.access$1700(this.this$0));
      ReportController.b(VasProfileQVipDiyView.access$1800(this.this$0), "dc00898", "", "", "qvip", "0X8009E7C", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.2
 * JD-Core Version:    0.7.0.1
 */