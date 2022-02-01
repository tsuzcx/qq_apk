package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopSettingActivity$51$1
  implements Runnable
{
  TroopSettingActivity$51$1(TroopSettingActivity.51 param51) {}
  
  public void run()
  {
    Object localObject1 = this.a.a.getExtras().getStringArrayList("deleted_members");
    int i;
    if (localObject1 != null)
    {
      Object localObject2;
      if (this.a.this$0.c != null)
      {
        localObject2 = this.a.this$0.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.this$0.a.wMemberNum);
        localStringBuilder.append(HardCodeUtil.a(2131701935));
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
      i = ((ArrayList)localObject1).size() - 1;
      while (i >= 0)
      {
        if (this.a.this$0.e != null)
        {
          int j = this.a.this$0.e.size() - 1;
          while (j >= 0)
          {
            localObject2 = (oidb_0x899.memberlist)this.a.this$0.e.get(j);
            if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has()) && (String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get()).equals(((ArrayList)localObject1).get(i))))
            {
              this.a.this$0.e.remove(j);
              break;
            }
            j -= 1;
          }
        }
        i -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultForTroopManage,memberListForCard.size = ");
      if (this.a.this$0.e != null) {
        i = this.a.this$0.e.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject1).toString());
    }
    this.a.this$0.a(this.a.this$0.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.51.1
 * JD-Core Version:    0.7.0.1
 */