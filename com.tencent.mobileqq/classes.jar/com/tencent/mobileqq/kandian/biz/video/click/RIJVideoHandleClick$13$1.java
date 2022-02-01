package com.tencent.mobileqq.kandian.biz.video.click;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.share.VideoShareListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$13$1
  extends VideoShareListener
{
  RIJVideoHandleClick$13$1(RIJVideoHandleClick.13 param13, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean3)
    {
      if (paramBoolean4) {
        RIJVideoHandleClick.b(this.b.a).a().z().v();
      } else {
        RIJVideoHandleClick.b(this.b.a).a().z().a(2);
      }
      RIJVideoHandleClick.b(this.b.a).a().z().a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    }
    if (!paramBoolean1)
    {
      RIJVideoHandleClick.b(this.b.a).a().f(false);
    }
    else if (RIJVideoHandleClick.b(this.b.a).a().f())
    {
      RIJVideoHandleClick.b(this.b.a).a().z().v();
      RIJVideoHandleClick.b(this.b.a).a().f(false);
    }
    if ((paramBoolean2) && (RIJVideoHandleClick.b(this.b.a).a().y() != null)) {
      RIJVideoHandleClick.b(this.b.a).a().y().a(2, this.a, 0L, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.13.1
 * JD-Core Version:    0.7.0.1
 */