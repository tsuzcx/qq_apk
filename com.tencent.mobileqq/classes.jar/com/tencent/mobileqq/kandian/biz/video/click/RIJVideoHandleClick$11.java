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
    if (paramView.getId() == 2131437113)
    {
      localAbsBaseArticleInfo1 = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).D;
      str = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).E.innerUniqueID;
      localAbsBaseArticleInfo2 = localAbsBaseArticleInfo1;
    }
    else
    {
      localAbsBaseArticleInfo1 = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).E;
      str = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).D.innerUniqueID;
      localAbsBaseArticleInfo2 = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).D;
      localAbsBaseArticleInfo1.isTwoItem = true;
    }
    boolean bool;
    if (paramView.getId() == 2131437113) {
      bool = true;
    } else {
      bool = false;
    }
    RIJVideoReportManager.a(bool, localAbsBaseArticleInfo1, localAbsBaseArticleInfo2, str, null, RIJVideoHandleClick.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.11
 * JD-Core Version:    0.7.0.1
 */