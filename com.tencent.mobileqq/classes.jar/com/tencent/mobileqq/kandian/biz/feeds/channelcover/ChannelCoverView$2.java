package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ChannelCoverView$2
  implements Runnable
{
  ChannelCoverView$2(ChannelCoverInfo paramChannelCoverInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    String str;
    try
    {
      Object localObject1 = new JSONObject();
      if (this.a != null) {
        ((JSONObject)localObject1).put("channel_id", this.a.mChannelCoverId);
      }
      ((JSONObject)localObject1).put("network_type", VideoReporter.a());
      ((JSONObject)localObject1).put("version", VideoReporter.a);
      ((JSONObject)localObject1).put("os", "1");
      ((JSONObject)localObject1).put("imei", ReadInJoyUtils.c());
      ((JSONObject)localObject1).put("imsi", ReadInJoyUtils.d());
      ((JSONObject)localObject1).put("kandian_mode_new", VideoReporter.c());
      ((JSONObject)localObject1).put("kandian_mode", RIJAppSetting.b());
      ((JSONObject)localObject1).put("entrance", VideoR5.Builder.N(this.b));
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
    Object localObject2 = this.c;
    PublicAccountReportUtils.a(null, "", (String)localObject2, (String)localObject2, 0, 0, this.d, this.e, this.f, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.2
 * JD-Core Version:    0.7.0.1
 */