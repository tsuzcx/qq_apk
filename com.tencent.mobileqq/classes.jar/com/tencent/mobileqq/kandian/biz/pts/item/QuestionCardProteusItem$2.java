package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class QuestionCardProteusItem$2
  implements View.OnClickListener
{
  QuestionCardProteusItem$2(QuestionCardProteusItem paramQuestionCardProteusItem, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.a, this.b, 2, false, 6, false);
    paramView = this.b;
    RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem.2
 * JD-Core Version:    0.7.0.1
 */