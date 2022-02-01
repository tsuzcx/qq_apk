package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.statistics.ReportTask;

class BaseMomentItemBuilder$1
  implements View.OnClickListener
{
  BaseMomentItemBuilder$1(BaseMomentItemBuilder paramBaseMomentItemBuilder, Context paramContext, MomentFeedInfo paramMomentFeedInfo, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    String str1 = this.b.m;
    String str2 = this.b.n;
    Object localObject = this.b.p;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = this.b.o;
    } else {
      paramView = (View)localObject;
    }
    localIntent.putExtra("url", String.format("https://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str2, str1, paramView, localObject }));
    this.a.startActivity(localIntent);
    localObject = new ReportTask(this.d.c).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(this.c.a.i));
    if (this.d.b) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ((ReportTask)localObject).a(new String[] { paramView, "", "", this.c.a.f }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */