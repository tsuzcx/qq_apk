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
    boolean bool = WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, null).a("folder_status", WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", WeishiReportUtil.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.z(ReadInJoyUtils.a())));
    Object localObject;
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
      if (localObject != null) {
        localBuilder.a("reddot_style", WeishiReportUtil.a((RecentBaseData)localObject)).a("algorithm_id", WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
      }
    }
    String str = "0";
    if (bool)
    {
      str = WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      localObject = WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    else
    {
      localObject = "0";
    }
    WeishiReportUtil.a(str, (String)localObject, "0X8009291", localBuilder.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */