package com.tencent.mobileqq.security;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ModifyPwdTopBarHelper$1
  implements View.OnClickListener
{
  ModifyPwdTopBarHelper$1(ModifyPwdTopBarHelper paramModifyPwdTopBarHelper, Context paramContext, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, this.c.b(this.b.getCurrentUin(), "bar_url", ""), 4010, null);
    this.c.b(this.b.getCurrentUin(), System.currentTimeMillis());
    ReportController.b(this.b, "dc00898", "", "", "0X800B187", "0X800B187", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.security.ModifyPwdTopBarHelper.1
 * JD-Core Version:    0.7.0.1
 */