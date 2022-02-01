package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import java.util.List;

class DoubleVideoProteusItem$3
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$3(DoubleVideoProteusItem paramDoubleVideoProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.columnEntrances != null)
    {
      if (this.a.columnEntrances.isEmpty()) {
        return;
      }
      Object localObject = (VideoColumnInfo)this.a.columnEntrances.get(0);
      if ((((VideoColumnInfo)localObject).n != null) && (((VideoColumnInfo)localObject).n.a != 3)) {
        VideoFeedsHelper.a(this.b.t().getContext(), ((VideoColumnInfo)localObject).n);
      }
      localObject = this.a;
      ProteusSupportUtil.a((AbsBaseArticleInfo)localObject, ((AbsBaseArticleInfo)localObject).mProteusTemplateBean, paramViewBase);
      RIJDtReportHelper.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem.3
 * JD-Core Version:    0.7.0.1
 */