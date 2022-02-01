package com.tencent.mobileqq.kandian.biz.tab;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadinjoyTabFrame$18
  implements Runnable
{
  ReadinjoyTabFrame$18(ReadinjoyTabFrame paramReadinjoyTabFrame, VideoInfo paramVideoInfo, ReadInJoySkinManager paramReadInJoySkinManager) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo == null) {
          break label233;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinManager.a() != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinManager.a()))) {
          break label238;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinManager.a();
        localJSONObject.put("skin_id", localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo == null) {
          break label244;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g;
        localJSONObject.put("rwokey", localObject);
        localJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.getInstance().getEntryFeedsType());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.this$0.a(), "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 0, "5", "", "", localJSONObject.toString(), false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportForVideoEntranceRedDotButtonClicked has finished,  r5: ");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("Q.readinjoy.4tab", 2, ((StringBuilder)localObject).toString());
        }
        if (ReadinjoyTabFrame.a(this.this$0) != null)
        {
          VideoFeedsFirstVideoRecommendationManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label233:
      int i = 1;
      continue;
      label238:
      String str = "0";
      continue;
      label244:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.18
 * JD-Core Version:    0.7.0.1
 */