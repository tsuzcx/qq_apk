package com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;

public class ProfileAccountInfoUtils
{
  public static short getAgeWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41610, paramProfileCardInfo))) {
      return (short)paramProfileCardInfo.card.age;
    }
    return 0;
  }
  
  public static long getBirthdayWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41607, paramProfileCardInfo))) {
      return paramProfileCardInfo.card.lBirthday;
    }
    return 0L;
  }
  
  public static String getCompanyWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(40272, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strCompany);
    }
    return null;
  }
  
  public static String getConstellationWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41609, paramProfileCardInfo))) {
      return ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getConstellation(paramProfileCardInfo.card.constellation);
    }
    return null;
  }
  
  public static String getEmailWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41622, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strEmail);
    }
    return null;
  }
  
  public static short getGenderWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41611, paramProfileCardInfo))) {
      return paramProfileCardInfo.card.shGender;
    }
    return -1;
  }
  
  public static String getHometownCityWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41613, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strHometownCity);
    }
    return null;
  }
  
  public static String getHometownProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41613, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strHometownProvince);
    }
    return null;
  }
  
  public static String getHometownWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41613, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strHometownDesc);
    }
    return null;
  }
  
  public static String getLocationCityWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41614, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strCity);
    }
    return null;
  }
  
  public static String getLocationCountryWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41614, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strCountry);
    }
    return null;
  }
  
  public static String getLocationProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41614, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strProvince);
    }
    return null;
  }
  
  public static String getProfessionTagWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41618, paramProfileCardInfo))) {
      return ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getJobTag(paramProfileCardInfo.card.iProfession);
    }
    return null;
  }
  
  public static String getProfessionWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41618, paramProfileCardInfo))) {
      return ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getJob(paramProfileCardInfo.card.iProfession);
    }
    return null;
  }
  
  public static String getSchoolWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (isFieldVisible(41619, paramProfileCardInfo))) {
      return getStringTrim(paramProfileCardInfo.card.strSchool);
    }
    return null;
  }
  
  public static String getStringTrim(String paramString)
  {
    if (paramString != null) {
      return paramString.trim();
    }
    return null;
  }
  
  public static boolean isFieldVisible(int paramInt, ProfileCardInfo paramProfileCardInfo)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    boolean bool = true;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(paramInt, paramProfileCardInfo.card, null) != 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils
 * JD-Core Version:    0.7.0.1
 */