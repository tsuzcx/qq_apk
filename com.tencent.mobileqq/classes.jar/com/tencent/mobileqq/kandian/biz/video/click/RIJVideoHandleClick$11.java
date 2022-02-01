package com.tencent.mobileqq.kandian.biz.video.click;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$11
  implements ClickHandler
{
  RIJVideoHandleClick$11(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo1;
    String str;
    AbsBaseArticleInfo localAbsBaseArticleInfo2;
    if (paramView.getId() == 2131369963)
    {
      localAbsBaseArticleInfo1 = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).a;
      str = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).b.innerUniqueID;
      localAbsBaseArticleInfo2 = localAbsBaseArticleInfo1;
    }
    else
    {
      localAbsBaseArticleInfo1 = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).b;
      str = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).a.innerUniqueID;
      localAbsBaseArticleInfo2 = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).a;
      localAbsBaseArticleInfo1.isTwoItem = true;
    }
    boolean bool;
    if (paramView.getId() == 2131369963) {
      bool = true;
    } else {
      bool = false;
    }
    RIJVideoReportManager.a(bool, localAbsBaseArticleInfo1, localAbsBaseArticleInfo2, str, null, RIJVideoHandleClick.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.11
 * JD-Core Version:    0.7.0.1
 */