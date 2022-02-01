package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import org.json.JSONObject;

class ComponentPolymericPullAnimatorView$1
  implements View.OnClickListener
{
  ComponentPolymericPullAnimatorView$1(ComponentPolymericPullAnimatorView paramComponentPolymericPullAnimatorView, AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.c(this.c.a, this.a.mNewPolymericInfo.h);
    paramView = new StringBuilder();
    paramView.append(this.a.mFeedId);
    paramView.append("");
    String str = paramView.toString();
    if (RIJFeedsType.L(this.a)) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.mStrategyId);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800982B", "0X800982B", 0, 0, str, paramView, localStringBuilder.toString(), this.b.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericPullAnimatorView.1
 * JD-Core Version:    0.7.0.1
 */