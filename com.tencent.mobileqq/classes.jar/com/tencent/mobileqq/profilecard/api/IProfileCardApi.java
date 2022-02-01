package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IProfileCardApi
  extends QRouteApi
{
  public abstract void checkToCleanSettingMeRedPointGuide(AppInterface paramAppInterface);
  
  public abstract short getAgeWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract long getBirthdayWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getCompanyWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getConstellationWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getEmailWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract short getGenderWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getHometownCityWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getHometownProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getHometownWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getLocationCityWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getLocationCountryWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getLocationProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getProfessionTagWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getProfessionWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  @Deprecated
  public abstract Class<?> getProfileCardActivityClass();
  
  @Deprecated
  public abstract Intent getProfileCardIntent(Context paramContext, AllInOne paramAllInOne);
  
  @Deprecated
  public abstract Intent getProfileCardIntentOnly(Context paramContext, AllInOne paramAllInOne);
  
  public abstract String getSchoolWithPrivacy(ProfileCardInfo paramProfileCardInfo);
  
  public abstract String getStringTrim(String paramString);
  
  public abstract void inviteAskAnonymously(Activity paramActivity, boolean paramBoolean);
  
  public abstract boolean isFieldVisible(int paramInt, ProfileCardInfo paramProfileCardInfo);
  
  @Deprecated
  public abstract boolean isProfileCardActivity(Context paramContext);
  
  public abstract void openProfileCard(Context paramContext, AllInOne paramAllInOne);
  
  public abstract void openProfileCard(Context paramContext, AllInOne paramAllInOne, boolean paramBoolean);
  
  public abstract void openProfileCardForResult(Activity paramActivity, AllInOne paramAllInOne, int paramInt);
  
  public abstract void photoWallDelQzonePhotoWall(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong);
  
  public abstract void photoWallJump(Activity paramActivity, String paramString, boolean paramBoolean);
  
  public abstract void shareInviteToQZone(Activity paramActivity);
  
  public abstract boolean showProfileRedPointGuide(AppInterface paramAppInterface);
  
  public abstract boolean showSettingMeRedPointGuide(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileCardApi
 * JD-Core Version:    0.7.0.1
 */