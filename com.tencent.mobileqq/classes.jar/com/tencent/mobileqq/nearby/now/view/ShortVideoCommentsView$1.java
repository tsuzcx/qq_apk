package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;

class ShortVideoCommentsView$1
  implements View.OnClickListener
{
  ShortVideoCommentsView$1(ShortVideoCommentsView paramShortVideoCommentsView, LocationInfo paramLocationInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = new Intent(this.b.getContext(), QQBrowserActivity.class);
    String str1 = this.a.lng;
    String str2 = this.a.lat;
    Object localObject1 = this.a.name;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = this.a.getCity();
    } else {
      paramView = (View)localObject1;
    }
    paramView = String.format("https://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str2, str1, paramView, localObject1 });
    ((Intent)localObject2).putExtra("url", paramView);
    this.b.getContext().startActivity((Intent)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("when click location label ; the url is :");
      ((StringBuilder)localObject1).append(paramView);
      QLog.i("ShortVideoComments", 2, ((StringBuilder)localObject1).toString());
    }
    localObject2 = new ReportTask(this.b.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(ShortVideoCommentsView.access$000(this.b).i));
    if (TextUtils.equals(String.valueOf(ShortVideoCommentsView.access$000(this.b).i), this.b.app.getCurrentAccountUin())) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    if (ShortVideoCommentsView.access$000(this.b) != null) {
      localObject1 = ShortVideoCommentsView.access$000(this.b).c;
    } else {
      localObject1 = "0";
    }
    ((ReportTask)localObject2).a(new String[] { paramView, "", "", localObject1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.1
 * JD-Core Version:    0.7.0.1
 */