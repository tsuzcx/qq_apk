import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.List;

public class smf
  extends TroopObserver
{
  public smf(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.profilecard.FrdProfileCard", 2, "onGetExtShowTroopList");
    }
    if ((!paramBoolean) || (paramList1 == null) || (paramList1.size() == 0) || (paramInt != 0))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
        {
          paramList1 = new ShowExternalTroop();
          paramList1.strFaceUrl = null;
          this.a.a(paramList1);
        }
      }
      else {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.removeBuisEntry(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      }
      this.a.x();
      return;
    }
    paramList1 = (ShowExternalTroop)paramList1.get(0);
    this.a.a(paramList1);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d)) || (!paramBoolean) || (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Int = paramInt;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d);
          }
        }
        else if (paramObject == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: cardInfo==null");
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      if (QLog.isColorLevel())
      {
        QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        l = paramObject.memberUin;
        if (l != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          }
        }
        else if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.card == null || cardInfo.allinone == null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendProfileCardActivity", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Boolean = true;
          if ((paramObject.result == 260) && (paramObject.memberRole == 0))
          {
            QQToast.a(this.a, 1, "该群成员已不在本群", 0).a();
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
            if (!TroopInfo.isQidianPrivateTroop(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.b = false;
              this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
              return;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Boolean = false;
            this.a.c.setVisibility(8);
            return;
          }
          this.a.c(null);
          if (paramObject.titleId == 0)
          {
            Object localObject = (TroopManager)this.a.app.getManager(51);
            if (localObject != null)
            {
              localObject = ((TroopManager)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
              if (localObject != null)
              {
                paramObject.titleId = ((TroopMemberInfo)localObject).level;
                if (QLog.isColorLevel()) {
                  QLog.d("FriendProfileCardActivity", 2, "onGetTroopMemberCard: server realLevel==0, useLocal=" + paramObject.titleId);
                }
              }
            }
          }
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smf
 * JD-Core Version:    0.7.0.1
 */