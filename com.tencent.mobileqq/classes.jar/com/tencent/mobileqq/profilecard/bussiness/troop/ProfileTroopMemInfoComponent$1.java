package com.tencent.mobileqq.profilecard.bussiness.troop;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemInfoComponent$1
  extends TroopObserver
{
  ProfileTroopMemInfoComponent$1(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent) {}
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (ProfileTroopMemInfoComponent.access$000(this.this$0).isFinishing())
      {
        QLog.d("ProfileTroopMemInfoComponent", 1, "onGetTroopMemberCard return because is finished!");
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetTroopMemberCard: isSuccess ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        localObject = (TroopManager)ProfileTroopMemInfoComponent.access$100(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
        paramObject = (Object[])paramObject;
        long l1 = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        long l2 = Long.parseLong(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$200(this.this$0)).troopUin);
        if (l1 != l2)
        {
          if (!QLog.isColorLevel()) {
            break label740;
          }
          paramObject = new StringBuilder();
          paramObject.append("onGetTroopMemberCard: troopUin != mTroopUin, ");
          paramObject.append(l1);
          paramObject.append("!=");
          paramObject.append(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$300(this.this$0)).troopUin);
          QLog.i("ProfileTroopMemInfoComponent", 2, paramObject.toString());
          return;
        }
        if (paramObject == null)
        {
          if (!QLog.isColorLevel()) {
            break label741;
          }
          QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo==null");
          return;
        }
        if ((ProfileTroopMemInfoComponent.access$400(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$500(this.this$0)).allInOne != null))
        {
          l1 = paramObject.memberUin;
          if (l1 != Long.parseLong(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$600(this.this$0)).allInOne.uin))
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            paramObject = new StringBuilder();
            paramObject.append("onGetTroopMemberCard: memberUin != mMemberUin, ");
            paramObject.append(l1);
            paramObject.append("!=");
            paramObject.append(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$700(this.this$0)).allInOne.uin);
            QLog.i("ProfileTroopMemInfoComponent", 2, paramObject.toString());
            return;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateParams: uint32_result:");
            localStringBuilder.append(paramObject.result);
            localStringBuilder.append(" memberRole:");
            localStringBuilder.append(paramObject.memberRole);
            QLog.i("ProfileTroopMemInfoComponent", 2, localStringBuilder.toString());
          }
          ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$800(this.this$0)).troopMemberCard = paramObject;
          ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$900(this.this$0)).troopShowMoreBtn = true;
          if ((paramObject.result == 260) && (paramObject.memberRole == 0))
          {
            QQToast.makeText(ProfileTroopMemInfoComponent.access$1000(this.this$0), 1, HardCodeUtil.a(2131902896), 0).show();
            ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1100(this.this$0)).troopMemberCard = paramObject;
            if (!((TroopManager)localObject).Z(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1200(this.this$0)).troopUin))
            {
              ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1300(this.this$0)).isTroopMemberCard = false;
              ProfileTroopMemInfoComponent.access$1400(this.this$0);
              return;
            }
            ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1500(this.this$0)).troopShowMoreBtn = false;
            return;
          }
          if ((paramObject.titleId == 0) && (localObject != null))
          {
            localObject = ((TroopManager)localObject).g(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1600(this.this$0)).troopUin, ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1700(this.this$0)).allInOne.uin);
            if (localObject != null)
            {
              paramObject.titleId = ((TroopMemberInfo)localObject).level;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("onGetTroopMemberCard: server realLevel==0, useLocal=");
                ((StringBuilder)localObject).append(paramObject.titleId);
                QLog.d("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: updateCardInfo");
          }
          ProfileTroopMemInfoComponent.access$1400(this.this$0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
        }
        return;
      }
    }
    catch (Exception paramObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetTroopMemberCard:");
        ((StringBuilder)localObject).append(paramObject.toString());
        QLog.i("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject).toString());
      }
    }
    return;
    label740:
    return;
    label741:
    return;
  }
  
  protected void onTroopRankTitleUpdate(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((ProfileTroopMemInfoComponent.access$1800(this.this$0) != null) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1900(this.this$0)).isTroopMemberCard) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2000(this.this$0)).troopMemberCard != null) && (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2100(this.this$0)).allInOne != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if ((paramString1.equals(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2200(this.this$0)).troopUin)) && (paramString2.equals(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2300(this.this$0)).allInOne.uin)))
      {
        ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$2400(this.this$0)).troopMemberCard.titleId = paramInt;
        ProfileTroopMemInfoComponent.access$2500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.1
 * JD-Core Version:    0.7.0.1
 */