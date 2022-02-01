package com.tencent.mobileqq.kandian.biz.video.click;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem;
import com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;

class RIJVideoHandleClick$12
  implements ClickHandler
{
  RIJVideoHandleClick$12(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if (paramView.getId() == 2131367807)
    {
      localAbsBaseArticleInfo = ((WeishiGridTwoItemViewHolder)paramView.getTag()).a;
      localObject = ((WeishiGridTwoItemViewHolder)paramView.getTag()).b.innerUniqueID;
    }
    else
    {
      localAbsBaseArticleInfo = ((WeishiGridTwoItemViewHolder)paramView.getTag()).b;
      localObject = ((WeishiGridTwoItemViewHolder)paramView.getTag()).a.innerUniqueID;
    }
    VideoPlayParam localVideoPlayParam = RIJConfigVideoItem.a(localAbsBaseArticleInfo);
    localVideoPlayParam.n = ((String)localObject);
    localVideoPlayParam.l = VideoReporter.b();
    if ((RIJVideoHandleClick.a(this.a).a().a() != null) && (!TextUtils.isEmpty(RIJVideoHandleClick.a(this.a).a().a().b()))) {
      localVideoPlayParam.m = RIJVideoHandleClick.a(this.a).a().a().b();
    }
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    localVideoPlayParam.h = localObject[0];
    localVideoPlayParam.i = localObject[1];
    localVideoPlayParam.j = paramView.getWidth();
    localVideoPlayParam.k = paramView.getHeight();
    if (localAbsBaseArticleInfo.isVideoItemForCommonUrlJump())
    {
      RIJJumpUtils.a(RIJVideoHandleClick.a(this.a).a().a(), localAbsBaseArticleInfo.mVideoAdsJumpUrl);
      RIJVideoReportManager.a(localVideoPlayParam, localAbsBaseArticleInfo, RIJVideoHandleClick.a(this.a));
      return;
    }
    if (localAbsBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (WeishiGuideUtils.a(RIJVideoHandleClick.a(this.a).a().a()))
      {
        VideoFeedsWeiShiUtils.a(RIJVideoHandleClick.a(this.a).a().a(), "video_type_videopublic");
      }
      else
      {
        QQToast.a(RIJVideoHandleClick.a(this.a).a().a(), -1, 2131717893, 0).b(RIJVideoHandleClick.a(this.a).a().a().getResources().getDimensionPixelSize(2131299168));
        VideoFeedsWeiShiUtils.b(RIJVideoHandleClick.a(this.a).a().a(), "video_type_videopublic");
      }
      RIJVideoReportManager.a(localVideoPlayParam, localAbsBaseArticleInfo, RIJVideoHandleClick.a(this.a));
      return;
    }
    RIJVideoHandleClick.a(this.a).a().a().a(localVideoPlayParam, localAbsBaseArticleInfo, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.12
 * JD-Core Version:    0.7.0.1
 */