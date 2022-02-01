package com.tencent.mobileqq.profilecard.bussiness.troop;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ProfileTroopMemInfoComponent$1
  extends TroopObserver
{
  ProfileTroopMemInfoComponent$1(ProfileTroopMemInfoComponent paramProfileTroopMemInfoComponent) {}
  
  public void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (ProfileTroopMemInfoComponent.access$000(this.this$0).isFinishing())
      {
        QLog.d("ProfileTroopMemInfoComponent", 1, "onGetTroopMemberCard return because is finished!");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        localObject = (TroopManager)ProfileTroopMemInfoComponent.access$100(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$200(this.this$0)).jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$300(this.this$0)).jdField_a_of_type_JavaLangString);
        }
      }
    }
    catch (Exception paramObject)
    {
      Object localObject;
      long l;
      if (QLog.isColorLevel())
      {
        QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo==null");
          }
        }
        else if ((ProfileTroopMemInfoComponent.access$400(this.this$0) == null) || (((ProfileCardInfo)ProfileTroopMemInfoComponent.access$500(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$600(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$700(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$800(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard = paramObject;
            ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$900(this.this$0)).c = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              QQToast.a(ProfileTroopMemInfoComponent.access$1000(this.this$0), 1, HardCodeUtil.a(2131704929), 0).a();
              ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1100(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard = paramObject;
              if (!((TroopManager)localObject).n(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1200(this.this$0)).jdField_a_of_type_JavaLangString))
              {
                ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1300(this.this$0)).b = false;
                ProfileTroopMemInfoComponent.access$1400(this.this$0);
                return;
              }
              ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1500(this.this$0)).c = false;
              return;
            }
            if ((paramObject.titleId == 0) && (localObject != null))
            {
              localObject = ((TroopManager)localObject).b(((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1600(this.this$0)).jdField_a_of_type_JavaLangString, ((ProfileCardInfo)ProfileTroopMemInfoComponent.access$1700(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              if (localObject != null)
              {
                paramObject.titleId = ((TroopMemberInfo)localObject).level;
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: server realLevel==0, useLocal=" + paramObject.titleId);
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: updateCardInfo");
            }
            ProfileTroopMemInfoComponent.access$1400(this.this$0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.1
 * JD-Core Version:    0.7.0.1
 */