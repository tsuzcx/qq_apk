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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private int b;
  
  public OnAdLiveExpandCardClickListener(IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().b() != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a(0, localArrayList, new ArrayList(), null, false, true);
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
      ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()).isSmallCard = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().notifyDataSetChanged();
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
    IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    if ((localIReadInJoyModel != null) && (localIReadInJoyModel.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a())))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      if (this.b != 1121) {
        return;
      }
      LogUtil.QLog.d("OnAdLiveExpandCardClickListener", 2, "close click");
      if (paramViewBase.getViewId().equals("id_ad_tag_small_view"))
      {
        LogUtil.QLog.d("OnAdLiveExpandCardClickListener", 2, "close click remove");
        a();
        ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()).clickPos = 39;
      }
      else
      {
        LogUtil.QLog.d("OnAdLiveExpandCardClickListener", 2, "close click change");
        b();
        ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()).clickPos = 40;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(ReportAction.CLOSE, Integer.valueOf(0), (AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), 3, 1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnAdLiveExpandCardClickListener
 * JD-Core Version:    0.7.0.1
 */