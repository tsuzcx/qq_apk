package com.tencent.mobileqq.kandian.biz.biu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyDeliverBiuActivity$5
  implements View.OnClickListener
{
  ReadInJoyDeliverBiuActivity$5(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.e(this.a)) && ((!ReadInJoyDeliverBiuActivity.f(this.a)) || (ReadInJoyDeliverBiuActivity.m(this.a) != -1)))
    {
      paramView = this.a;
      paramView.b(ReadInJoyDeliverBiuActivity.n(paramView));
      return;
    }
    this.a.finish();
    paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyDeliverBiuActivity.n(this.a));
    localStringBuilder.append("");
    paramView.publicAccountReportClickEvent(null, "", "0X8008661", "0X8008661", 0, 0, localStringBuilder.toString(), "", "", ReadInJoyBaseDeliverActivity.a(), false);
    ReadInJoyDeliverBiuActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.5
 * JD-Core Version:    0.7.0.1
 */