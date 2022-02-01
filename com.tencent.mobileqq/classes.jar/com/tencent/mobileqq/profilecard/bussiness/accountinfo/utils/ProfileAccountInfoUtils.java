package com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class ProfileAccountInfoUtils
{
  public static short getAgeWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    short s2 = 0;
    short s1 = s2;
    if (paramProfileCardInfo != null)
    {
      s1 = s2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        s1 = s2;
        if (isFieldVisible(41610, paramProfileCardInfo)) {
          s1 = (short)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.age;
        }
      }
    }
    return s1;
  }
  
  public static long getBirthdayWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramProfileCardInfo != null)
    {
      l1 = l2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        l1 = l2;
        if (isFieldVisible(41607, paramProfileCardInfo)) {
          l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lBirthday;
        }
      }
    }
    return l1;
  }
  
  public static String getCompanyWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(40272, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCompany);
        }
      }
    }
    return localObject1;
  }
  
  public static String getConstellationWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41609, paramProfileCardInfo)) {
          localObject1 = NearbyProfileUtil.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.constellation);
        }
      }
    }
    return localObject1;
  }
  
  public static String getEmailWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41622, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strEmail);
        }
      }
    }
    return localObject1;
  }
  
  public static short getGenderWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    short s2 = -1;
    short s1 = s2;
    if (paramProfileCardInfo != null)
    {
      s1 = s2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        s1 = s2;
        if (isFieldVisible(41611, paramProfileCardInfo)) {
          s1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender;
        }
      }
    }
    return s1;
  }
  
  public static String getHometownCityWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41613, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strHometownCity);
        }
      }
    }
    return localObject1;
  }
  
  public static String getHometownProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41613, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strHometownProvince);
        }
      }
    }
    return localObject1;
  }
  
  public static String getHometownWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41613, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strHometownDesc);
        }
      }
    }
    return localObject1;
  }
  
  public static String getLocationCityWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41614, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);
        }
      }
    }
    return localObject1;
  }
  
  public static String getLocationCountryWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41614, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry);
        }
      }
    }
    return localObject1;
  }
  
  public static String getLocationProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41614, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince);
        }
      }
    }
    return localObject1;
  }
  
  public static String getProfessionTagWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41618, paramProfileCardInfo)) {
          localObject1 = NearbyProfileUtil.d(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iProfession);
        }
      }
    }
    return localObject1;
  }
  
  public static String getProfessionWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41618, paramProfileCardInfo)) {
          localObject1 = NearbyProfileUtil.e(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iProfession);
        }
      }
    }
    return localObject1;
  }
  
  public static String getSchoolWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = localObject2;
        if (isFieldVisible(41619, paramProfileCardInfo)) {
          localObject1 = getStringTrim(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strSchool);
        }
      }
    }
    return localObject1;
  }
  
  public static String getStringTrim(String paramString)
  {
    String str = null;
    if (paramString != null) {
      str = paramString.trim();
    }
    return str;
  }
  
  public static boolean isFieldVisible(int paramInt, ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (int i = 1; (i == 0) || (ProfileSettingUtils.a.a(paramInt, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, null) != 2); i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils
 * JD-Core Version:    0.7.0.1
 */