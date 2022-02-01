package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class OnAdLiveExpandCardClickListener
  implements ViewBase.OnClickListener
{
  private IReadInJoyModel a;
  private Context b;
  private int c;
  private int d;
  
  public OnAdLiveExpandCardClickListener(IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramIReadInJoyModel;
    this.b = paramContext;
    this.d = paramInt1;
    this.c = paramInt2;
  }
  
  private void a()
  {
    if (this.a.u().h() != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.a.k());
        this.a.u().a(0, localArrayList, new ArrayList(), null, false, true);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("close click error");
        localStringBuilder.append(localException.getMessage());
        LogUtil.QLog.e("OnAdLiveExpandCardClickListener", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b()
  {
    try
    {
      ((AdvertisementInfo)this.a.k()).isSmallCard = true;
      this.a.u().notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideBigView error ");
      localStringBuilder.append(localException.getMessage());
      LogUtil.QLog.e("OnAdLiveExpandCardClickListener", 2, localStringBuilder.toString());
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    IReadInJoyModel localIReadInJoyModel = this.a;
    if ((localIReadInJoyModel != null) && (localIReadInJoyModel.k() != null) && (this.a.k().mSmallMiniGameInfo != null) && (this.a.u() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.a.k())))
    {
      if (this.b == null) {
        return;
      }
      if (this.d != 1121) {
        return;
      }
      LogUtil.QLog.d("OnAdLiveExpandCardClickListener", 2, "close click");
      if (paramViewBase.getViewId().equals("id_ad_tag_small_view"))
      {
        LogUtil.QLog.d("OnAdLiveExpandCardClickListener", 2, "close click remove");
        a();
        ((AdvertisementInfo)this.a.k()).clickPos = 39;
      }
      else
      {
        LogUtil.QLog.d("OnAdLiveExpandCardClickListener", 2, "close click change");
        b();
        ((AdvertisementInfo)this.a.k()).clickPos = 40;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(ReportAction.CLOSE, Integer.valueOf(0), (AdvertisementInfo)this.a.k(), 3, 1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnAdLiveExpandCardClickListener
 * JD-Core Version:    0.7.0.1
 */