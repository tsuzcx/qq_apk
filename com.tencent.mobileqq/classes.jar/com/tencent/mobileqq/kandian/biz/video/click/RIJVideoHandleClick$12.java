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
    if (paramView.getId() == 2131434382)
    {
      localAbsBaseArticleInfo = ((WeishiGridTwoItemViewHolder)paramView.getTag()).k;
      localObject = ((WeishiGridTwoItemViewHolder)paramView.getTag()).l.innerUniqueID;
    }
    else
    {
      localAbsBaseArticleInfo = ((WeishiGridTwoItemViewHolder)paramView.getTag()).l;
      localObject = ((WeishiGridTwoItemViewHolder)paramView.getTag()).k.innerUniqueID;
    }
    VideoPlayParam localVideoPlayParam = RIJConfigVideoItem.a(localAbsBaseArticleInfo);
    localVideoPlayParam.H = ((String)localObject);
    localVideoPlayParam.E = VideoReporter.b();
    if ((RIJVideoHandleClick.b(this.a).a().z() != null) && (!TextUtils.isEmpty(RIJVideoHandleClick.b(this.a).a().z().C()))) {
      localVideoPlayParam.F = RIJVideoHandleClick.b(this.a).a().z().C();
    }
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    localVideoPlayParam.I = localObject[0];
    localVideoPlayParam.J = localObject[1];
    localVideoPlayParam.K = paramView.getWidth();
    localVideoPlayParam.L = paramView.getHeight();
    if (localAbsBaseArticleInfo.isVideoItemForCommonUrlJump())
    {
      RIJJumpUtils.c(RIJVideoHandleClick.b(this.a).a().A(), localAbsBaseArticleInfo.mVideoAdsJumpUrl);
      RIJVideoReportManager.a(localVideoPlayParam, localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a));
      return;
    }
    if (localAbsBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (WeishiGuideUtils.a(RIJVideoHandleClick.b(this.a).a().A()))
      {
        VideoFeedsWeiShiUtils.a(RIJVideoHandleClick.b(this.a).a().A(), "video_type_videopublic");
      }
      else
      {
        QQToast.makeText(RIJVideoHandleClick.b(this.a).a().A(), -1, 2131915367, 0).show(RIJVideoHandleClick.b(this.a).a().A().getResources().getDimensionPixelSize(2131299920));
        VideoFeedsWeiShiUtils.b(RIJVideoHandleClick.b(this.a).a().A(), "video_type_videopublic");
      }
      RIJVideoReportManager.a(localVideoPlayParam, localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a));
      return;
    }
    RIJVideoHandleClick.b(this.a).a().v().a(localVideoPlayParam, localAbsBaseArticleInfo, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.12
 * JD-Core Version:    0.7.0.1
 */