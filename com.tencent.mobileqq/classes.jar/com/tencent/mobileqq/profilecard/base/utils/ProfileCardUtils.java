package com.tencent.mobileqq.profilecard.base.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMedalWallEntryInfo;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMetalWallUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ProfileCardUtils
{
  private static final String TAG = "ProfileCardUtils";
  
  public static String getProfileDetailUrl(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQQAppInterface == null) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    return getProfileDetailUrl(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface.getAppid(), "android-8.5.5", paramProfileCardInfo.jdField_a_of_type_JavaLangString, ProfileMetalWallUtils.getProfileMetalWallEntryInfo(paramQQAppInterface, paramProfileCardInfo));
  }
  
  public static String getProfileDetailUrl(String paramString1, int paramInt, String paramString2, String paramString3, ProfileMedalWallEntryInfo paramProfileMedalWallEntryInfo)
  {
    paramString1 = String.format("https://ti.qq.com/qcard/profile?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2 = paramString1 + "&troopUin=" + paramString3;
    }
    paramString1 = paramString2;
    if (ProfileCardUtil.a()) {
      paramString1 = paramString2 + "&intl=1";
    }
    paramString2 = paramString1;
    if (paramProfileMedalWallEntryInfo != null)
    {
      paramString2 = paramString1;
      if (paramProfileMedalWallEntryInfo.showMetalWall) {
        paramString2 = paramString1 + "&mwentry=1";
      }
      paramString1 = paramString2;
      if (paramProfileMedalWallEntryInfo.hasRedPoint) {
        paramString1 = paramString2 + "&mwredpoint=1";
      }
      paramString2 = paramString1;
      if (paramProfileMedalWallEntryInfo.redPointCount > 1) {
        paramString2 = paramString1 + "&mwredpointnum=" + paramProfileMedalWallEntryInfo.redPointCount;
      }
    }
    return paramString2;
  }
  
  public static boolean isDefaultProfile(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null)
    {
      bool1 = bool2;
      if (paramProfileCardInfo.jdField_a_of_type_Long == ProfileCardTemplate.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isFriend(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.b(paramString);
      }
    }
    return false;
  }
  
  public static void notifyUser(int paramInt1, int paramInt2)
  {
    notifyUser(paramInt1, BaseApplication.getContext().getString(paramInt2));
  }
  
  public static void notifyUser(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).a();
  }
  
  public static void openProfileEdit(QQAppInterface paramQQAppInterface, Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramProfileCardInfo == null)) {
      return;
    }
    BusinessCard localBusinessCard = BusinessCardUtils.a(paramQQAppInterface, paramProfileCardInfo);
    paramQQAppInterface = ProfileCardUtil.a(new Intent(paramActivity, FriendProfileMoreInfoActivity.class), paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    paramQQAppInterface.putExtra("profile_entry_type", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
    paramQQAppInterface.putExtra("troopUin", paramProfileCardInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("memberUin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("isTroopMemberCard", paramProfileCardInfo.jdField_b_of_type_Boolean);
    paramQQAppInterface.putExtra("extendFriendEntryAddFriend", paramProfileCardInfo.jdField_b_of_type_Int);
    paramActivity.startActivityForResult(paramQQAppInterface, 1022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils
 * JD-Core Version:    0.7.0.1
 */