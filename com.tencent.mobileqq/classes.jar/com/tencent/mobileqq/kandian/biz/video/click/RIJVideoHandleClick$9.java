package com.tencent.mobileqq.kandian.biz.video.click;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class RIJVideoHandleClick$9
  implements ClickHandler
{
  RIJVideoHandleClick$9(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    AbsBaseArticleInfo localAbsBaseArticleInfo = RIJVideoHandleClick.b(this.a).c(localVideoFeedsViewHolder.P);
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    if (!VideoFeedsHelper.a(localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a).a().A()))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
      {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).setAdapterMonitorClickAdParams(RIJVideoHandleClick.b(this.a).a().A(), localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a).a().v(), 56);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)RIJVideoHandleClick.b(this.a).a().A(), localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a).a().v(), 56, false, null);
        return;
      }
      RIJVideoHandleClick.b(this.a).a().v().a(localVideoFeedsViewHolder.t, localAbsBaseArticleInfo, false, true);
    }
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.9.1(this, localAbsBaseArticleInfo));
    VideoHandler.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.9
 * JD-Core Version:    0.7.0.1
 */