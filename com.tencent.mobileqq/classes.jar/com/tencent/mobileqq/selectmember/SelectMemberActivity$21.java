package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberActivity$21
  implements Runnable
{
  SelectMemberActivity$21(SelectMemberActivity paramSelectMemberActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    String str;
    if (this.a) {
      str = "multiMode_exp";
    } else {
      str = "singleMode_exp";
    }
    ReportController.b(this.this$0.app, "dc00899", "Grp_addFrd", "", "frd_select", str, 0, 0, this.b, "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.21
 * JD-Core Version:    0.7.0.1
 */