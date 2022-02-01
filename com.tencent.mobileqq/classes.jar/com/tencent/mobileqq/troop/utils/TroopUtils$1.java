package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility.OnShareListener;
import com.tencent.mobileqq.util.TroopReportor;

final class TroopUtils$1
  implements TroopShareUtility.OnShareListener
{
  TroopUtils$1(TroopInfoData paramTroopInfoData) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    String str1;
    if (this.a.isMember)
    {
      str1 = "";
      switch (paramInt)
      {
      }
    }
    while (TextUtils.isEmpty(str1))
    {
      return;
      str1 = "share_circle";
      continue;
      str1 = "share_qq";
      continue;
      str1 = "share_qzone";
      continue;
      str1 = "share_wechat";
    }
    String str3 = this.a.troopUin;
    String str4 = TroopReportor.a(this.a);
    if (paramBoolean) {}
    for (String str2 = "0";; str2 = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, str4, str2 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.1
 * JD-Core Version:    0.7.0.1
 */