package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopSettingActivity$23$1
  implements Runnable
{
  TroopSettingActivity$23$1(TroopSettingActivity.23 param23, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.b.this$0.N != null)
    {
      Iterator localIterator = this.b.this$0.N.iterator();
      while (localIterator.hasNext())
      {
        oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
        ArrayList localArrayList = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localmemberlist.uint64_member_uin.get());
        localStringBuilder.append("");
        if (!localArrayList.contains(localStringBuilder.toString()))
        {
          localArrayList = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localmemberlist.uint64_member_uin.get());
          localStringBuilder.append("");
          localArrayList.add(localStringBuilder.toString());
        }
      }
    }
    TroopSettingActivity.a(this.b.this$0, this.b.this$0.i.troopUin, this.b.this$0.i.isOwnerOrAdim(), this.a);
    this.b.this$0.a("Grp", "Clk_invite_new", "0");
    ReportController.b(TroopSettingActivity.a(this.b.this$0), "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.23.1
 * JD-Core Version:    0.7.0.1
 */