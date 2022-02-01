package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class ProfileMetalWallUtils
{
  public static ProfileMedalWallEntryInfo getProfileMetalWallEntryInfo(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo != null)
      {
        localObject1 = new ProfileMedalWallEntryInfo();
        ((ProfileMedalWallEntryInfo)localObject1).showMetalWall = showMedalWall(paramQQAppInterface, paramProfileCardInfo);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label84;
        }
        i = 1;
      }
    }
    while ((i != 0) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramProfileCardInfo.iNewCount > 0)
      {
        ((ProfileMedalWallEntryInfo)localObject1).hasRedPoint = true;
        ((ProfileMedalWallEntryInfo)localObject1).redPointCount = paramProfileCardInfo.iNewCount;
        return localObject1;
        label84:
        i = 0;
      }
      else
      {
        paramQQAppInterface = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        if (!paramQQAppInterface.a(paramQQAppInterface.a(10016), false)) {
          break label140;
        }
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if ((paramProfileCardInfo.iUpgradeCount > 0) || (i != 0))
      {
        ((ProfileMedalWallEntryInfo)localObject1).hasRedPoint = true;
        ((ProfileMedalWallEntryInfo)localObject1).redPointCount = 0;
      }
      return localObject1;
    }
  }
  
  private static boolean showMedalWall(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQQAppInterface == null) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo.b) && (localTroopManager.n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    if (SharedPreUtils.X(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) {
      return false;
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) {
      return false;
    }
    return !Utils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMetalWallUtils
 * JD-Core Version:    0.7.0.1
 */