package com.tencent.mobileqq.kandian.biz.ad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import java.util.HashMap;

class ReadInJoyAdIMAXBrowserFragment$3
  implements View.OnClickListener
{
  ReadInJoyAdIMAXBrowserFragment$3(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (SwiftBrowserShareMenuHandler)this.a.mComponentsProvider.a(4);
    if ((paramView != null) && (paramView.a != null) && (paramView.a.isShowing())) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.c(this.a);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getQBaseActivity()).a(21).b(27).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdIMAXBrowserFragment.3
 * JD-Core Version:    0.7.0.1
 */