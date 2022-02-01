package com.tencent.mobileqq.nearby.profilecard.moment;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.TextMomentFeedInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil.ReportBundleBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BaseMomentItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  BaseMomentItemBuilder$3(BaseMomentItemBuilder paramBaseMomentItemBuilder, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder, MomentFeedInfo paramMomentFeedInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    Object localObject = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_inform");
    paramView = "2";
    localObject = ((INowVideoReporter)localObject).source("2").timelong(this.d.h(this.a)).feedid(this.b.f).feed_type(String.valueOf(this.d.g(this.a)));
    if (this.d.b) {
      paramView = "1";
    }
    ((INowVideoReporter)localObject).d1(paramView).report(this.d.c);
    paramView = this.b.i;
    if ((BaseMomentItemBuilder.a(this.d, paramView)) && ((this.d.a instanceof BaseActivity)))
    {
      paramView = new ProfileCardUtil.ReportBundleBuilder();
      localObject = this.b;
      if ((localObject instanceof ChangMomentFeedInfo)) {
        paramView.b(((ChangMomentFeedInfo)localObject).d);
      } else if ((localObject instanceof LiveMomentFeedInfo)) {
        paramView.d(((LiveMomentFeedInfo)localObject).b).b(((LiveMomentFeedInfo)this.b).a);
      } else if ((localObject instanceof PicMomentFeedInfo)) {
        paramView.b(((PicMomentFeedInfo)localObject).c);
      } else if ((localObject instanceof ShortVideoMomentFeedInfo)) {
        paramView.b(((ShortVideoMomentFeedInfo)localObject).c);
      } else {
        boolean bool = localObject instanceof TextMomentFeedInfo;
      }
      paramView.a(this.b.s);
      paramView = paramView.a();
      ProfileCardUtil.a((BaseActivity)this.d.a, 0L, this.b.i, null, 20006, "", paramView);
    }
    else
    {
      QQToast.makeText(this.d.a, 2, HardCodeUtil.a(2131899262), 0).show();
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */