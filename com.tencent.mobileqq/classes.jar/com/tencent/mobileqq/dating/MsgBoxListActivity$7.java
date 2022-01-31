package com.tencent.mobileqq.dating;

import ajed;
import ascz;
import awrb;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;

class MsgBoxListActivity$7
  implements Runnable
{
  MsgBoxListActivity$7(MsgBoxListActivity paramMsgBoxListActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, ascz paramascz) {}
  
  public void run()
  {
    String str1;
    int i;
    String str2;
    label42:
    awrb localawrb;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving)
    {
      str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.startLiveWordingType);
      i = this.jdField_a_of_type_Ascz.b();
      if (!this.this$0.d) {
        break label157;
      }
      str2 = "1";
      localawrb = new awrb(this.this$0.app).a("dc00899").b("grp_lbs").c("msg_box");
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
        break label163;
      }
    }
    label157:
    label163:
    for (String str3 = "clk_livepush";; str3 = "clk_relivepush")
    {
      localawrb.d(str3).e(String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin).longValue() - ajed.l)).a(new String[] { str1, String.valueOf(i), str2 }).a();
      return;
      str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.endLiveWordingType);
      break;
      str2 = "0";
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.7
 * JD-Core Version:    0.7.0.1
 */