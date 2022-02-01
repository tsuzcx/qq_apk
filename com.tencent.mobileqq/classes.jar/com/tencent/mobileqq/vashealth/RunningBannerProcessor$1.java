package com.tencent.mobileqq.vashealth;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class RunningBannerProcessor$1
  implements View.OnClickListener
{
  RunningBannerProcessor$1(RunningBannerProcessor paramRunningBannerProcessor, String paramString, Long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqVashealthRunningBannerProcessor))
    {
      RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqVashealthRunningBannerProcessor, false);
      new Handler().postDelayed(new RunningBannerProcessor.1.1(this), 1000L);
      Object localObject1 = RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqVashealthRunningBannerProcessor).getAppRuntime().getCurrentAccountUin();
      Object localObject2 = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append("uin=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&plat=1");
      ((StringBuilder)localObject2).append("&app=1");
      ((StringBuilder)localObject2).append("&version=8.7.0.5295");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&device=");
      ((StringBuilder)localObject3).append(URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&system=");
      ((StringBuilder)localObject3).append(Build.VERSION.RELEASE);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&systemInt=");
      ((StringBuilder)localObject3).append(Integer.toString(Build.VERSION.SDK_INT));
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("portraitOnly", true);
      ((Intent)localObject3).putExtra("url", (String)localObject2);
      ((Intent)localObject3).putExtra("uin", (String)localObject1);
      ((Intent)localObject3).putExtra("hide_operation_bar", true);
      ((Intent)localObject3).putExtra("hide_more_button", true);
      VasWebviewUtil.a(RunningBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqVashealthRunningBannerProcessor), (String)localObject2, 32768L, (Intent)localObject3, false, -1);
      if (this.jdField_a_of_type_JavaLangLong.longValue() == 3L)
      {
        RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqVashealthRunningBannerProcessor).sendEmptyMessage(3000);
        localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, this.jdField_a_of_type_Int);
        LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
      }
      ReportController.a(RunningBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqVashealthRunningBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 9, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.RunningBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */