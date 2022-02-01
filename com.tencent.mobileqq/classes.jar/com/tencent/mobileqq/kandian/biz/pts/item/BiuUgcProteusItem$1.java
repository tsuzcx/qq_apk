package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class BiuUgcProteusItem$1
  implements View.OnClickListener
{
  BiuUgcProteusItem$1(BiuUgcProteusItem paramBiuUgcProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (RIJItemViewTypeUtils.c(this.a)) {
      i = 3;
    } else {
      i = 2;
    }
    paramView = this.a;
    RIJJumpUtils.a = paramView;
    RIJJumpUtils.a(this.b, paramView, i, false, 2, false);
    paramView = this.a;
    RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuUgcProteusItem.1
 * JD-Core Version:    0.7.0.1
 */