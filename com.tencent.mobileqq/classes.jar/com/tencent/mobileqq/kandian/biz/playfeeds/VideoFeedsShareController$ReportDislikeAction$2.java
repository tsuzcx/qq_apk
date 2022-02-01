package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

class VideoFeedsShareController$ReportDislikeAction$2
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoFeedsShareController$ReportDislikeAction$2(VideoFeedsShareController.ReportDislikeAction paramReportDislikeAction, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = RIJQQAppInterfaceUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), BaseArticleInfoKt.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a).a, paramArrayList, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a).g));
    }
    QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a), -1, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a).getString(2131699885), 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a).getResources().getDimensionPixelSize(2131299168));
    VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a).dismiss();
    VideoFeedsShareController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ReportDislikeAction.a, false);
    paramView = new VideoR5.Builder(VideoReporter.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).j(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g).a(paramArrayList);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, paramView.a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportDislikeAction.2
 * JD-Core Version:    0.7.0.1
 */