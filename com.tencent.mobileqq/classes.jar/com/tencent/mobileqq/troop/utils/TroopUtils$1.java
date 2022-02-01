package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility.OnShareListener;
import com.tencent.mobileqq.utils.TroopReportor;

final class TroopUtils$1
  implements TroopShareUtility.OnShareListener
{
  TroopUtils$1(TroopInfoData paramTroopInfoData) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a.isMember)
    {
      String str1;
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              str1 = "";
            }
          }
        }
      }
      for (;;)
      {
        break;
        str1 = "share_circle";
        continue;
        str1 = "share_wechat";
        continue;
        str1 = "share_qzone";
        continue;
        str1 = "share_qq";
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      String str3 = this.a.troopUin;
      String str4 = TroopReportor.a(this.a);
      String str2;
      if (paramBoolean) {
        str2 = "0";
      } else {
        str2 = "1";
      }
      TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, str4, str2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.1
 * JD-Core Version:    0.7.0.1
 */