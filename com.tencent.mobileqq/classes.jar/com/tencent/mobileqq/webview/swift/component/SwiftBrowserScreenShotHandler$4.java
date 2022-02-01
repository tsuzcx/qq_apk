package com.tencent.mobileqq.webview.swift.component;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper;
import com.tencent.common.app.BaseApplicationImpl;
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
    Object localObject1 = "";
    Object localObject2 = Uri.parse(SwiftBrowserScreenShotHandler.a(this.a).c());
    try
    {
      localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.a.f(this.a.jdField_a_of_type_JavaLangString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject2, "", "");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1D", "", "", (String)localObject2, "", "");
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.b = true;
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695245, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.4
 * JD-Core Version:    0.7.0.1
 */