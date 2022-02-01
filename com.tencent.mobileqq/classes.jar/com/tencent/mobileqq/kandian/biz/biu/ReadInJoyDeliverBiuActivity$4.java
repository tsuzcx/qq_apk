package com.tencent.mobileqq.kandian.biz.biu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyDeliverBiuActivity$4
  implements View.OnClickListener
{
  ReadInJoyDeliverBiuActivity$4(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.c(this.a)) && ((!ReadInJoyDeliverBiuActivity.d(this.a)) || (ReadInJoyDeliverBiuActivity.k(this.a) != -1)))
    {
      paramView = this.a;
      paramView.b(ReadInJoyDeliverBiuActivity.l(paramView));
      return;
    }
    paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyDeliverBiuActivity.l(this.a));
    localStringBuilder.append("");
    paramView.publicAccountReportClickEvent(null, "", "0X8008661", "0X8008661", 0, 0, localStringBuilder.toString(), "", "", ReadInJoyBaseDeliverActivity.a(), false);
    this.a.finish();
    ReadInJoyDeliverBiuActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.4
 * JD-Core Version:    0.7.0.1
 */