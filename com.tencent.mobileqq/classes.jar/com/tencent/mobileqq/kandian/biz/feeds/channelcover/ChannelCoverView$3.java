package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

final class ChannelCoverView$3
  implements Runnable
{
  ChannelCoverView$3(ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      String str1;
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo != null) {
          ((JSONObject)localObject1).put("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId);
        }
        ((JSONObject)localObject1).put("current_channel_id", 0);
        if (!NetworkState.isWifiConn()) {
          break label528;
        }
        i = 2;
        ((JSONObject)localObject1).put("network_type", i);
        i = this.jdField_a_of_type_Int;
        int j = ChannelCoverView.jdField_a_of_type_Int;
        if (i == j) {
          ((JSONObject)localObject1).put("channel_type", "2");
        } else if (this.jdField_a_of_type_Int == ChannelCoverView.b) {
          ((JSONObject)localObject1).put("channel_type", "1");
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
        if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mColumnType == 0)) {
          ((JSONObject)localObject1).put("content_type", 1);
        } else {
          ((JSONObject)localObject1).put("content_type", 2);
        }
        if (this.b != -1) {
          ((JSONObject)localObject1).put("reddot_status", this.b);
        }
        if (this.c != -1) {
          ((JSONObject)localObject1).put("location", this.c + 1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo != null) {
          ((JSONObject)localObject1).put("is_change", ChannelListDynamicOrderConfigHandler.a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId));
        }
        ((JSONObject)localObject1).put("style", 0);
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId == 41695))
        {
          localObject2 = ReadInJoyLogicEngine.a().a();
          if (localObject2 != null)
          {
            localObject2 = ((SelectPositionModule)localObject2).a();
            if (localObject2 != null)
            {
              ((JSONObject)localObject1).put("channel_city", ((PositionData)localObject2).city);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("reportRecommendEvent CHANNEL_ID_LOCAL r5Str = ");
                ((StringBuilder)localObject2).append(localObject1);
                QLog.i("ChannelCoverView", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo != null)
        {
          i = ChannelCoverInfoModule.a();
          j = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId;
          if ((i == j) && (ChannelCoverInfoModule.a() != 0)) {
            ((JSONObject)localObject1).put("channelid_to_mainfeeds", 1);
          } else {
            ((JSONObject)localObject1).put("channelid_to_mainfeeds", 0);
          }
        }
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
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportRecommendEvent actionName =");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("; reportString = ");
        ((StringBuilder)localObject2).append(str1);
        QLog.d("ChannelCoverView", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str2 = this.jdField_a_of_type_JavaLangString;
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, "", str2, str2, 0, 0, "", "", "", str1, false);
      return;
      label528:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.3
 * JD-Core Version:    0.7.0.1
 */