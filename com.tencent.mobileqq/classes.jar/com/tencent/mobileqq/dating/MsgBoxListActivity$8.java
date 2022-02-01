package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

class MsgBoxListActivity$8
  implements Runnable
{
  MsgBoxListActivity$8(MsgBoxListActivity paramMsgBoxListActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.startLiveWordingType;
    } else {
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.endLiveWordingType;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyINearbyCardManager.b();
    String str1;
    if (this.this$0.isFromNearby) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    ReportTask localReportTask = new ReportTask(this.this$0.app).a("dc00899").b("grp_lbs").c("msg_box");
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
      str2 = "clk_livepush";
    } else {
      str2 = "clk_relivepush";
    }
    localReportTask.d(str2).e(String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin).longValue() - AppConstants.NOW_LIVE_TIP_UIN_BASE)).a(new String[] { String.valueOf(i), String.valueOf(j), str1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.8
 * JD-Core Version:    0.7.0.1
 */