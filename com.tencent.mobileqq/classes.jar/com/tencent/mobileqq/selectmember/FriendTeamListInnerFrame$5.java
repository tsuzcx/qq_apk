package com.tencent.mobileqq.selectmember;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FriendTeamListInnerFrame$5
  extends TroopObserver
{
  FriendTeamListInnerFrame$5(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject1 = this.a.f.getIntent().getStringExtra("group_uin");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onUpdateTroopGetMemberList, troopUin[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("], ftroopUin[");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("], troopMemberInfoList[");
    if (paramList != null) {
      paramInt1 = paramList.size();
    } else {
      paramInt1 = -1;
    }
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("]");
    QLog.w("FriendTeamListInnerFrameNew", 1, ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(paramString))) {
      return;
    }
    paramString = this.a.h.getCurrentAccountUin();
    localObject1 = new ArrayList();
    localObject2 = (ITroopRobotService)this.a.h.getRuntimeService(ITroopRobotService.class, "all");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
        if (localTroopMemberInfo != null)
        {
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onUpdateTroopGetMemberList, memberuin[");
            localStringBuilder.append(localTroopMemberInfo.memberuin);
            localStringBuilder.append("]");
            QLog.w("FriendTeamListInnerFrameNew", 1, localStringBuilder.toString());
          }
          if (!TextUtils.equals(localTroopMemberInfo.memberuin, paramString)) {
            if ((!((ITroopRobotService)localObject2).isRobotUin(localTroopMemberInfo.memberuin)) && (!CommonUtils.a(this.a.h, localTroopMemberInfo.memberuin))) {
              ((ArrayList)localObject1).add(localTroopMemberInfo);
            } else if (QLog.isDevelopLevel()) {
              QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, isRobotUin");
            }
          }
        }
      }
    }
    this.a.f.setGroupMembers((ArrayList)localObject1);
    FriendTeamListInnerFrame.b(this.a).a((ArrayList)localObject1);
    FriendTeamListInnerFrame.b(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */