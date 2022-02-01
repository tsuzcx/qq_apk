package com.tencent.mobileqq.kandian.biz.video.click;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class RIJVideoHandleClick$8
  implements ClickHandler
{
  RIJVideoHandleClick$8(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    AbsBaseArticleInfo localAbsBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.a());
    if ((RIJVideoHandleClick.a(this.a).a().a().a() != null) && (RIJVideoHandleClick.a(this.a).a().a().a().a() != null) && (RIJVideoHandleClick.a(this.a).a().a().a().a().a()))
    {
      RIJVideoHandleClick.a(this.a).a().a().a().a().a(5);
      return;
    }
    if (!VideoFeedsHelper.a(localAbsBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a()))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
      {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).setAdapterMonitorClickAdParams(RIJVideoHandleClick.a(this.a).a().a(), localAbsBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), 56, false);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)RIJVideoHandleClick.a(this.a).a().a(), localAbsBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), 56, false, null);
        return;
      }
      int i;
      if ((VideoFeedsHelper.d()) && (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))) {
        i = 1;
      } else {
        i = 0;
      }
      if (((!RIJVideoHandleClick.a(this.a).a().a().canAutoPlayVideo()) && (ReadInJoyHelper.a(RIJQQAppInterfaceUtil.b()) > 0)) || (i != 0))
      {
        if (localAbsBaseArticleInfo == null) {
          return;
        }
        if (i != 0)
        {
          String str = new VideoR5.Builder(null, null, localAbsBaseArticleInfo.mVideoVid, localAbsBaseArticleInfo.innerUniqueID).a((int)localAbsBaseArticleInfo.mChannelID).N((int)RIJVideoHandleClick.a(this.a).a().a()).R(1).a().a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", str, false);
        }
        RIJVideoHandleClick.a(this.a).a().a().a(localVideoFeedsViewHolder.a(), localAbsBaseArticleInfo, false, true);
      }
      else
      {
        RIJVideoHandleClick.a(this.a).a().a().a().c(paramView);
      }
    }
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.8
 * JD-Core Version:    0.7.0.1
 */