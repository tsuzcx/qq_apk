package com.tencent.mobileqq.selectmember;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class SelectMemberActivity$14
  extends TroopManagerBizObserver
{
  SelectMemberActivity$14(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void onGetInviteNoAuthLimitNum(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((paramBoolean) && (str.equals(this.a.mGroupCode)))
    {
      this.a.mInviteNoAuthLimitNum = paramLong2;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troop");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" get inviteNoAuthLimitNum = ");
        ((StringBuilder)localObject).append(paramLong2);
        QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.a.mTroopMemberNum >= this.a.mInviteNoAuthLimitNum) && (this.a.mInviteNoAuthLimitNum > 0L))
      {
        this.a.mTooManyMembersTipsBar.setVisibility(0);
        localObject = this.a.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getMemberType(this.a.app, this.a.app.getCurrentAccountUin(), str));
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "dc00899", "invite_friend", "", "friend_list", "exp_needagree", 0, 0, str, localStringBuilder.toString(), "", "");
      }
    }
  }
  
  protected void onGetInvitedUinList(boolean paramBoolean, Long paramLong, List<Long> paramList)
  {
    paramLong = String.valueOf(paramLong);
    if ((paramBoolean) && (paramLong.equals(this.a.mGroupCode)))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        this.a.mInvitedUinList.add(String.valueOf(localLong));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troop");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" get invitedUinList = ");
        ((StringBuilder)localObject).append(paramList.toString());
        QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.14
 * JD-Core Version:    0.7.0.1
 */