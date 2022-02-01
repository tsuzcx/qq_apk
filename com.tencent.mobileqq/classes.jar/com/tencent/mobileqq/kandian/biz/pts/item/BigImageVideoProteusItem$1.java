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
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class BigImageVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  BigImageVideoProteusItem$1(BigImageVideoProteusItem paramBigImageVideoProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a;
    if ((paramViewBase != null) && (paramViewBase.columnEntrances != null))
    {
      if (this.a.columnEntrances.isEmpty()) {
        return;
      }
      paramViewBase = new StringBuilder();
      paramViewBase.append("");
      paramViewBase.append(this.a.columnEntrances);
      QLog.i("BigImageVideoProteusItem", 1, paramViewBase.toString());
      paramViewBase = (VideoColumnInfo)this.a.columnEntrances.get(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramViewBase);
      QLog.i("BigImageVideoProteusItem", 1, localStringBuilder.toString());
      if ((paramViewBase.n != null) && (paramViewBase.n.a != 3)) {
        VideoFeedsHelper.a(this.b.t().getContext(), paramViewBase.n);
      }
      paramViewBase = this.a;
      ProteusSupportUtil.a(paramViewBase, paramViewBase.mProteusTemplateBean, this.c);
      RIJDtReportHelper.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BigImageVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */