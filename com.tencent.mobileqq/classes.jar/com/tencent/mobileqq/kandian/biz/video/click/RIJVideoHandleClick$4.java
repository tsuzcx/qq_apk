package com.tencent.mobileqq.kandian.biz.video.click;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$4
  implements ClickHandler
{
  RIJVideoHandleClick$4(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramView.getTag();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    boolean bool;
    if (paramView.getId() == 2131437113) {
      bool = true;
    } else {
      bool = false;
    }
    RIJVideoReportManager.a(bool, localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a).a().A(), RIJVideoHandleClick.b(this.a).a().B(), RIJVideoHandleClick.b(this.a).a().x());
    VideoHandler.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.4
 * JD-Core Version:    0.7.0.1
 */