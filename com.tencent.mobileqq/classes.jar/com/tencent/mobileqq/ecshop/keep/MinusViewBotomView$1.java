package com.tencent.mobileqq.ecshop.keep;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MinusViewBotomView$1
  implements View.OnClickListener
{
  MinusViewBotomView$1(MinusViewBotomView paramMinusViewBotomView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ((IChatActivityApi)QRoute.api(IChatActivityApi.class)).getChatActivityClass();
    if (this.a.getContext().getClass() == localObject) {
      ((Activity)this.a.getContext()).finish();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis());
    ((StringBuilder)localObject).append("");
    ReportUtil.a("gouwu_fypbtn_click", "", ((StringBuilder)localObject).toString(), "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis());
    ((StringBuilder)localObject).append("");
    ReportUtil.b("gouwu_fypbtn_click", "", ((StringBuilder)localObject).toString(), "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.MinusViewBotomView.1
 * JD-Core Version:    0.7.0.1
 */