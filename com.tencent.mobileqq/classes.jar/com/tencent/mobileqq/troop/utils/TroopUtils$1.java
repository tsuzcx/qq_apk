package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import bflq;
import bftc;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

final class TroopUtils$1
  implements bflq
{
  TroopUtils$1(TroopInfoData paramTroopInfoData) {}
  
  public void onShareResp(int paramInt, boolean paramBoolean)
  {
    String str1;
    if (this.val$mTroopInfoData.isMember)
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
    String str3 = this.val$mTroopInfoData.troopUin;
    String str4 = bftc.a(this.val$mTroopInfoData);
    if (paramBoolean) {}
    for (String str2 = "0";; str2 = "1")
    {
      bftc.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, str4, str2 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.1
 * JD-Core Version:    0.7.0.1
 */