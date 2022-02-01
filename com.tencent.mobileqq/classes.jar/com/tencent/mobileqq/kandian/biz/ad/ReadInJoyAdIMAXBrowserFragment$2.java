package com.tencent.mobileqq.kandian.biz.ad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

class ReadInJoyAdIMAXBrowserFragment$2
  implements View.OnClickListener
{
  ReadInJoyAdIMAXBrowserFragment$2(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackEvent();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getQBaseActivity()).a(20).b(27).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdIMAXBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */