package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

class MsgBoxListActivity$8
  implements Runnable
{
  MsgBoxListActivity$8(MsgBoxListActivity paramMsgBoxListActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, NearbyCardManager paramNearbyCardManager) {}
  
  public void run()
  {
    String str1;
    int i;
    String str2;
    label42:
    ReportTask localReportTask;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving)
    {
      str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.startLiveWordingType);
      i = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager.b();
      if (!this.this$0.d) {
        break label157;
      }
      str2 = "1";
      localReportTask = new ReportTask(this.this$0.app).a("dc00899").b("grp_lbs").c("msg_box");
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
        break label163;
      }
    }
    label157:
    label163:
    for (String str3 = "clk_livepush";; str3 = "clk_relivepush")
    {
      localReportTask.d(str3).e(String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin).longValue() - AppConstants.NOW_LIVE_TIP_UIN_BASE)).a(new String[] { str1, String.valueOf(i), str2 }).a();
      return;
      str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.endLiveWordingType);
      break;
      str2 = "0";
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.8
 * JD-Core Version:    0.7.0.1
 */