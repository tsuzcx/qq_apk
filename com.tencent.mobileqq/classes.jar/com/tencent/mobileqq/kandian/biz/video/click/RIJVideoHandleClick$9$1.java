package com.tencent.mobileqq.kandian.biz.video.click;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$9$1
  implements Runnable
{
  RIJVideoHandleClick$9$1(RIJVideoHandleClick.9 param9, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new VideoR5.Builder(null, null, this.a.mVideoVid, this.a.innerUniqueID).a((int)this.a.mChannelID).O((int)RIJVideoHandleClick.b(this.b.a).a().x()).S(0).b().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.9.1
 * JD-Core Version:    0.7.0.1
 */