package com.tencent.mobileqq.kandian.biz.tab;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
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
        JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        if (this.a == null) {
          break label223;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode_new", VideoReporter.c());
        if ((this.b.c() != 1) || (TextUtils.isEmpty(this.b.b()))) {
          break label228;
        }
        Object localObject = this.b.b();
        localJSONObject.put("skin_id", localObject);
        if (this.a == null) {
          break label234;
        }
        localObject = this.a.l;
        localJSONObject.put("rwokey", localObject);
        localJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.getInstance().getEntryFeedsType());
        PublicAccountReportUtils.a(this.this$0.t(), "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 0, "5", "", "", localJSONObject.toString(), false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportForVideoEntranceRedDotButtonClicked has finished,  r5: ");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("Q.readinjoy.4tab", 2, ((StringBuilder)localObject).toString());
        }
        if (ReadinjoyTabFrame.l(this.this$0) != null)
        {
          VideoFeedsFirstVideoRecommendationManager.b(this.a);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label223:
      int i = 1;
      continue;
      label228:
      String str = "0";
      continue;
      label234:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.18
 * JD-Core Version:    0.7.0.1
 */