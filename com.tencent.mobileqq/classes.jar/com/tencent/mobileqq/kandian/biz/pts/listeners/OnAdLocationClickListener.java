package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LocalInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

public class OnAdLocationClickListener
  implements ViewBase.OnClickListener
{
  private final AbsBaseArticleInfo a;
  private final Context b;
  
  public OnAdLocationClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a;
    if ((paramViewBase instanceof AdvertisementInfo))
    {
      paramViewBase = (AdvertisementInfo)paramViewBase;
      if (paramViewBase.mLocalInfo != null)
      {
        Object localObject = paramViewBase.mLocalInfo.b;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = RIJJumpUtils.c(this.b, (String)localObject);
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.b).a(1).b(22).b((Integer)localObject).a(paramViewBase).c(33));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnAdLocationClickListener
 * JD-Core Version:    0.7.0.1
 */