package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;

final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = WeishiReportUtil.a(this.a);
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, null).b("folder_status", WeishiReportUtil.e(this.a)).b("EnterType", WeishiReportUtil.c(this.b)).b("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.aw(ReadInJoyUtils.b())));
    Object localObject;
    if (bool)
    {
      localObject = this.c;
      if (localObject != null) {
        localBuilder.b("reddot_style", WeishiReportUtil.a((RecentBaseData)localObject)).b("algorithm_id", WeishiReportUtil.d(this.a));
      }
    }
    String str = "0";
    if (bool)
    {
      str = WeishiReportUtil.b(this.a);
      localObject = WeishiReportUtil.c(this.a);
    }
    else
    {
      localObject = "0";
    }
    WeishiReportUtil.a(str, (String)localObject, "0X8009291", localBuilder.b().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */