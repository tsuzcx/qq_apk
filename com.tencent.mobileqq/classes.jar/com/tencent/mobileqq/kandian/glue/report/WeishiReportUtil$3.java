package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;

final class WeishiReportUtil$3
  implements Runnable
{
  WeishiReportUtil$3(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, RecentBaseData paramRecentBaseData, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq, "extLong", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.extLong));
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.parse();
    }
    String str = new VideoR5.Builder(null, null, null, null).a("folder_status", WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("algorithm_id", WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("reddot_style", WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.z(ReadInJoyUtils.a()))).a("EnterType", WeishiReportUtil.c(this.jdField_a_of_type_Int)).a().a();
    WeishiReportUtil.a(WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "0X8009290", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.3
 * JD-Core Version:    0.7.0.1
 */