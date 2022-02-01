package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class ProfileMetalWallUtils
{
  public static ProfileMedalWallEntryInfo getProfileMetalWallEntryInfo(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ProfileMedalWallEntryInfo localProfileMedalWallEntryInfo1;
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null))
    {
      ProfileMedalWallEntryInfo localProfileMedalWallEntryInfo2 = new ProfileMedalWallEntryInfo();
      localProfileMedalWallEntryInfo2.showMetalWall = showMedalWall(paramQQAppInterface, paramProfileCardInfo);
      int i;
      if (paramProfileCardInfo.allInOne.pa == 0) {
        i = 1;
      } else {
        i = 0;
      }
      localProfileMedalWallEntryInfo1 = localProfileMedalWallEntryInfo2;
      if (i != 0)
      {
        localProfileMedalWallEntryInfo1 = localProfileMedalWallEntryInfo2;
        if (paramProfileCardInfo.card != null)
        {
          paramProfileCardInfo = paramProfileCardInfo.card;
          if (paramProfileCardInfo.iNewCount > 0)
          {
            localProfileMedalWallEntryInfo2.hasRedPoint = true;
            localProfileMedalWallEntryInfo2.redPointCount = paramProfileCardInfo.iNewCount;
            return localProfileMedalWallEntryInfo2;
          }
          paramQQAppInterface = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
          boolean bool = paramQQAppInterface.a(paramQQAppInterface.a(10016), false);
          if (paramProfileCardInfo.iUpgradeCount <= 0)
          {
            localProfileMedalWallEntryInfo1 = localProfileMedalWallEntryInfo2;
            if (!bool) {}
          }
          else
          {
            localProfileMedalWallEntryInfo2.hasRedPoint = true;
            localProfileMedalWallEntryInfo2.redPointCount = 0;
            return localProfileMedalWallEntryInfo2;
          }
        }
      }
    }
    else
    {
      localProfileMedalWallEntryInfo1 = null;
    }
    return localProfileMedalWallEntryInfo1;
  }
  
  private static boolean showMedalWall(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.card != null))
    {
      if ((paramProfileCardInfo.allInOne.pa != 0) && (!ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne))) {
        return false;
      }
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramProfileCardInfo.isTroopMemberCard) && (localTroopManager.m(paramProfileCardInfo.troopUin))) {
        return false;
      }
      if (SharedPreUtils.U(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) {
        return false;
      }
      if (paramProfileCardInfo.card.medalSwitchDisable) {
        return false;
      }
      return !Utils.b(paramProfileCardInfo.allInOne.uin);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMetalWallUtils
 * JD-Core Version:    0.7.0.1
 */