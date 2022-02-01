package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ChannelCoverView$2
  implements Runnable
{
  ChannelCoverView$2(ChannelCoverInfo paramChannelCoverInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    String str1;
    try
    {
      Object localObject1 = new JSONObject();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo != null) {
        ((JSONObject)localObject1).put("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId);
      }
      ((JSONObject)localObject1).put("network_type", VideoReporter.a());
      ((JSONObject)localObject1).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject1).put("os", "1");
      ((JSONObject)localObject1).put("imei", ReadInJoyUtils.b());
      ((JSONObject)localObject1).put("imsi", ReadInJoyUtils.c());
      ((JSONObject)localObject1).put("kandian_mode_new", VideoReporter.a());
      ((JSONObject)localObject1).put("kandian_mode", RIJAppSetting.a());
      ((JSONObject)localObject1).put("entrance", VideoR5.Builder.a(this.jdField_a_of_type_Int));
      localObject1 = ((JSONObject)localObject1).toString();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ERROR Exception=");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("ChannelCoverView", 2, ((StringBuilder)localObject2).toString());
      }
      str1 = "";
    }
    Object localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = this.jdField_a_of_type_JavaLangString;
    ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, "", str2, str2, 0, 0, this.b, this.c, this.d, str1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.2
 * JD-Core Version:    0.7.0.1
 */