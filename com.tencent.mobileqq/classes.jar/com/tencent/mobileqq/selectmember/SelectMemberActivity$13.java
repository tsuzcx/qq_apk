package com.tencent.mobileqq.selectmember;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SelectMemberActivity$13
  extends TroopMngObserver
{
  SelectMemberActivity$13(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      SelectMemberActivity.access$400(this.a, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8)
    {
      Object localObject;
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "add troop member success");
        }
        this.a.mHandler.sendEmptyMessage(0);
        if (!this.a.mIsTroopAdmin)
        {
          paramInt1 = this.a.getNotAdminInviteMemberCount();
          this.a.setNotAdminInviteMemberCount(paramInt1 + 1);
          ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
        }
        localObject = this.a.getOutGroupMem();
        this.a.mIntent.putExtra("roomId", Long.parseLong(paramString));
        this.a.mIntent.putParcelableArrayListExtra("result_set", this.a.mResultList);
        this.a.mIntent.putParcelableArrayListExtra("result_set_for_out_Member ", (ArrayList)localObject);
        this.a.setResult(-1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add troop member fail, troopUin: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result: ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
      SelectMemberActivity.access$400(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.13
 * JD-Core Version:    0.7.0.1
 */