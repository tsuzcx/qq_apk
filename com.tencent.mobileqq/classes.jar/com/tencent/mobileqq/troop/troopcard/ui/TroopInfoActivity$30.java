package com.tencent.mobileqq.troop.troopcard.ui;

import android.os.Handler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcard.TroopInfoActivityHelper.IGetSameCityCheckTypeInfo;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopInfoActivity$30
  implements TroopInfoActivityHelper.IGetSameCityCheckTypeInfo
{
  TroopInfoActivity$30(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    this.a.stopTitleProgress();
    if ((this.a.i.dwAppPrivilegeFlag & 0x4000) != 0L) {
      TroopInfoActivity.h(this.a);
    }
  }
  
  public void a(oidb_0x79a.RspBody paramRspBody)
  {
    oidb_0x88d.GroupInfo localGroupInfo = paramRspBody.info;
    this.a.stopTitleProgress();
    this.a.f.tribeStatus = paramRspBody.uint32_tribe_status.get();
    this.a.f.modifyCount = paramRspBody.uint32_modify_countdown.get();
    int i;
    if (((4 == this.a.f.troopTypeExt) || (3 == this.a.f.troopTypeExt)) && (localGroupInfo != null) && ((4 == localGroupInfo.uint32_group_type_flag.get()) || (3 == localGroupInfo.uint32_group_type_flag.get())))
    {
      this.a.a(localGroupInfo);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((this.a.f.tribeStatus != 1) && (this.a.f.tribeStatus != 2) && (this.a.f.tribeStatus != 3))
    {
      if ((this.a.i.dwAppPrivilegeFlag & 0x4000) != 0L)
      {
        TroopInfoActivity.h(this.a);
        return;
      }
      this.a.J.sendEmptyMessage(8);
      return;
    }
    this.a.f.tribeId = paramRspBody.uint64_tribe_id.get();
    TroopInfoActivity localTroopInfoActivity = this.a;
    localTroopInfoActivity.B = localTroopInfoActivity.f.tribeId;
    this.a.f.tribeName = paramRspBody.str_tribe_name.get();
    if (i == 0) {
      this.a.a(localGroupInfo);
    }
    this.a.J.sendEmptyMessage(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.30
 * JD-Core Version:    0.7.0.1
 */