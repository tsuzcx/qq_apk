package com.tencent.mobileqq.nearby.profilecard.moment;

import android.view.View;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BaseMomentItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  BaseMomentItemBuilder$2(BaseMomentItemBuilder paramBaseMomentItemBuilder, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder, MomentFeedInfo paramMomentFeedInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_delete");
    paramView = "2";
    localINowVideoReporter = localINowVideoReporter.source("2").timelong(this.d.h(this.a)).feedid(this.b.f).feed_type(String.valueOf(this.d.g(this.a)));
    if (this.d.b) {
      paramView = "1";
    }
    localINowVideoReporter.d1(paramView).report(this.d.c);
    BaseMomentItemBuilder.a(this.d, this.a);
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */