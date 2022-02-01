package com.tencent.mobileqq.webview.swift.component;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwiftBrowserScreenShotHandler$4
  implements View.OnClickListener
{
  SwiftBrowserScreenShotHandler$4(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler) {}
  
  public void onClick(View paramView)
  {
    String str = "";
    Object localObject1 = Uri.parse(SwiftBrowserScreenShotHandler.a(this.a).m());
    Object localObject2;
    try
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = "";
    }
    if (localObject2 == null) {
      localObject2 = str;
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject2, "", "");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1D", "", "", (String)localObject2, "", "");
    if (this.a.m)
    {
      this.a.n = true;
      QQToast.makeText(BaseApplicationImpl.getContext(), 0, 2131892975, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
    }
    else
    {
      localObject2 = this.a;
      ((SwiftBrowserScreenShotHandler)localObject2).f(((SwiftBrowserScreenShotHandler)localObject2).i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.4
 * JD-Core Version:    0.7.0.1
 */