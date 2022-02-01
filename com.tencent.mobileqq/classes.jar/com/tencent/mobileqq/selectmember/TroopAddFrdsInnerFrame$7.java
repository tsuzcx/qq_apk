package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;

final class TroopAddFrdsInnerFrame$7
  implements Runnable
{
  TroopAddFrdsInnerFrame$7(boolean paramBoolean, AppInterface paramAppInterface, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    String str1;
    if (this.a) {
      str1 = "multiMode_add";
    } else {
      str1 = "singleMode_add";
    }
    AppInterface localAppInterface = this.b;
    String str3 = this.c.troopuin;
    if (this.a) {}
    while (!TextUtils.isEmpty(this.c.recommendRemark))
    {
      str2 = "1";
      break;
    }
    String str2 = "0";
    ReportController.b(localAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str1, 0, 0, str3, str2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.7
 * JD-Core Version:    0.7.0.1
 */