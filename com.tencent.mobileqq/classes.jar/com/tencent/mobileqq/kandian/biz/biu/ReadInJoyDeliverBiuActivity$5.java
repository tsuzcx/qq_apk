package com.tencent.mobileqq.kandian.biz.biu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity;

class ReadInJoyDeliverBiuActivity$5
  implements View.OnClickListener
{
  ReadInJoyDeliverBiuActivity$5(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.v(this.a)) && ((!ReadInJoyDeliverBiuActivity.w(this.a)) || (ReadInJoyDeliverBiuActivity.x(this.a) != -1)))
    {
      paramView = this.a;
      paramView.b(ReadInJoyDeliverBiuActivity.y(paramView));
      return;
    }
    this.a.finish();
    paramView = new StringBuilder();
    paramView.append(ReadInJoyDeliverBiuActivity.y(this.a));
    paramView.append("");
    PublicAccountReportUtils.a(null, "", "0X8008661", "0X8008661", 0, 0, paramView.toString(), "", "", ReadInJoyBaseDeliverActivity.h(), false);
    ReadInJoyDeliverBiuActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.5
 * JD-Core Version:    0.7.0.1
 */