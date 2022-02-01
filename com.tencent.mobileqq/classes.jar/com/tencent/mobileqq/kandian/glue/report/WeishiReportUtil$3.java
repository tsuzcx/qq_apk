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
    this.a.getMessageFacade().a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extLong", Integer.valueOf(this.b.extLong));
    if (this.b.structingMsg == null) {
      this.b.parse();
    }
    String str = new VideoR5.Builder(null, null, null, null).b("folder_status", WeishiReportUtil.e(this.b)).b("algorithm_id", WeishiReportUtil.d(this.b)).b("reddot_style", WeishiReportUtil.a(this.c)).b("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.aw(ReadInJoyUtils.b()))).b("EnterType", WeishiReportUtil.c(this.d)).b().a();
    WeishiReportUtil.a(WeishiReportUtil.b(this.b), WeishiReportUtil.c(this.b), "0X8009290", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.3
 * JD-Core Version:    0.7.0.1
 */