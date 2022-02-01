package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class VideoFeedsShareController$9
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoFeedsShareController$9(VideoFeedsShareController paramVideoFeedsShareController, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = RIJQQAppInterfaceUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
    {
      if (VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
      }
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), BaseArticleInfoKt.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g));
      AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      long l2 = 0L;
      long l1 = l2;
      if (paramObject != null)
      {
        l1 = l2;
        if ((paramObject instanceof DislikeInfo)) {
          l1 = ((DislikeInfo)paramObject).jdField_a_of_type_Long;
        }
      }
      Object localObject2 = "";
      Object localObject1 = localObject2;
      int i = 0;
      while (i < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(i);
        paramObject = localObject2;
        paramView = (View)localObject1;
        if (localDislikeInfo != null)
        {
          paramView = new StringBuilder();
          paramView.append((String)localObject2);
          paramView.append(localDislikeInfo.jdField_a_of_type_Long);
          localObject2 = paramView.toString();
          paramView = new StringBuilder();
          paramView.append((String)localObject1);
          paramView.append(localDislikeInfo.jdField_a_of_type_JavaLangString);
          localObject1 = paramView.toString();
          paramObject = localObject2;
          paramView = (View)localObject1;
          if (i != paramArrayList.size() - 1)
          {
            paramView = new StringBuilder();
            paramView.append((String)localObject2);
            paramView.append(",");
            paramObject = paramView.toString();
            paramView = new StringBuilder();
            paramView.append((String)localObject1);
            paramView.append(",");
            paramView = paramView.toString();
          }
        }
        i += 1;
        localObject2 = paramObject;
        localObject1 = paramView;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController)).a(3).b(10).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).a(l1).a((String)localObject2).b((String)localObject1));
    }
    QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController), -1, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).getString(2131699886), 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).getResources().getDimensionPixelSize(2131299168));
    VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).dismiss();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.9
 * JD-Core Version:    0.7.0.1
 */