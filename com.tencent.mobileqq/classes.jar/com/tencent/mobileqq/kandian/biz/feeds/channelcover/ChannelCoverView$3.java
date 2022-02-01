package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
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
      String str;
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        if (this.a != null) {
          ((JSONObject)localObject1).put("channel_id", this.a.mChannelCoverId);
        }
        ((JSONObject)localObject1).put("current_channel_id", 0);
        if (!NetworkState.isWifiConn()) {
          break label514;
        }
        i = 2;
        ((JSONObject)localObject1).put("network_type", i);
        i = this.b;
        int j = ChannelCoverView.a;
        if (i == j) {
          ((JSONObject)localObject1).put("channel_type", "2");
        } else if (this.b == ChannelCoverView.b) {
          ((JSONObject)localObject1).put("channel_type", "1");
        }
        localObject2 = this.a;
        if ((localObject2 != null) && (this.a.mColumnType == 0)) {
          ((JSONObject)localObject1).put("content_type", 1);
        } else {
          ((JSONObject)localObject1).put("content_type", 2);
        }
        if (this.c != -1) {
          ((JSONObject)localObject1).put("reddot_status", this.c);
        }
        if (this.d != -1) {
          ((JSONObject)localObject1).put("location", this.d + 1);
        }
        if (this.a != null) {
          ((JSONObject)localObject1).put("is_change", ChannelListDynamicOrderConfigHandler.b(ReadInJoyUtils.b(), this.a.mChannelCoverId));
        }
        ((JSONObject)localObject1).put("style", 0);
        if ((this.a != null) && (this.a.mChannelCoverId == 41695))
        {
          localObject2 = ReadInJoyLogicEngine.a().j();
          if (localObject2 != null)
          {
            localObject2 = ((SelectPositionModule)localObject2).b();
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
        if (this.a != null)
        {
          i = ChannelCoverInfoModule.g();
          j = this.a.mChannelCoverId;
          if ((i == j) && (ChannelCoverInfoModule.g() != 0)) {
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
        str = "";
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportRecommendEvent actionName =");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append("; reportString = ");
        ((StringBuilder)localObject2).append(str);
        QLog.d("ChannelCoverView", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.e;
      PublicAccountReportUtils.a(null, "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", str, false);
      return;
      label514:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.3
 * JD-Core Version:    0.7.0.1
 */