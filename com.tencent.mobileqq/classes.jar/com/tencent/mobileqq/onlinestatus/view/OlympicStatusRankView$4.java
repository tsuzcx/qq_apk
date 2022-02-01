package com.tencent.mobileqq.onlinestatus.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class OlympicStatusRankView$4
  implements View.OnClickListener
{
  OlympicStatusRankView$4(OlympicStatusRankView paramOlympicStatusRankView) {}
  
  public void onClick(View paramView)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    OlympicShareHelper.a(OlympicStatusRankView.b(this.a), OlympicStatusRankView.c(this.a), localAppInterface, null);
    ReportHelperKt.a("0X800BD91");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OlympicStatusRankView.4
 * JD-Core Version:    0.7.0.1
 */