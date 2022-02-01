package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil.Companion;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qidian.api.IQidianApi;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class ProfileCardApiImpl
  implements IProfileCardApi
{
  private static final String TAG = "ProfileCardApiImpl";
  
  public void checkToCleanSettingMeRedPointGuide(AppInterface paramAppInterface)
  {
    AnonymousRedPointUtils.checkToCleanSettingMeRedPointGuide(paramAppInterface);
  }
  
  public short getAgeWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getAgeWithPrivacy(paramProfileCardInfo);
  }
  
  public long getBirthdayWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getBirthdayWithPrivacy(paramProfileCardInfo);
  }
  
  public String getCompanyWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getCompanyWithPrivacy(paramProfileCardInfo);
  }
  
  public String getConstellationWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getConstellationWithPrivacy(paramProfileCardInfo);
  }
  
  public String getEmailWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getEmailWithPrivacy(paramProfileCardInfo);
  }
  
  public short getGenderWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getGenderWithPrivacy(paramProfileCardInfo);
  }
  
  public String getHometownCityWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getHometownCityWithPrivacy(paramProfileCardInfo);
  }
  
  public String getHometownProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getHometownProvinceWithPrivacy(paramProfileCardInfo);
  }
  
  public String getHometownWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getHometownWithPrivacy(paramProfileCardInfo);
  }
  
  public String getLocationCityWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getLocationCityWithPrivacy(paramProfileCardInfo);
  }
  
  public String getLocationCountryWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getLocationCountryWithPrivacy(paramProfileCardInfo);
  }
  
  public String getLocationProvinceWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(paramProfileCardInfo);
  }
  
  public String getProfessionTagWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getProfessionTagWithPrivacy(paramProfileCardInfo);
  }
  
  public String getProfessionWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getProfessionWithPrivacy(paramProfileCardInfo);
  }
  
  public Class<?> getProfileCardActivityClass()
  {
    return FriendProfileCardActivity.class;
  }
  
  public Intent getProfileCardIntent(Context paramContext, AllInOne paramAllInOne)
  {
    Object localObject2;
    if ((paramContext != null) && (paramAllInOne != null))
    {
      localObject2 = ((IQidianApi)QRoute.api(IQidianApi.class)).getProfileCardIntent(paramContext, paramAllInOne);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).getBabyQProfileCardIntent(paramContext, paramAllInOne);
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramContext = new Intent(paramContext, getProfileCardActivityClass());
        paramContext.putExtra("AllInOne", paramAllInOne);
        localObject1 = paramAllInOne.extras.getSerializable("param_wzry_data");
        if (localObject1 != null) {
          paramContext.putExtra("param_wzry_data", (Serializable)localObject1);
        }
        paramAllInOne = paramAllInOne.extras.getBundle("flc_extra_param");
        if (paramAllInOne != null) {
          paramContext.putExtra("flc_extra_param", paramAllInOne);
        }
        return paramContext;
      }
    }
    else
    {
      localObject2 = null;
    }
    return localObject2;
  }
  
  public Intent getProfileCardIntentOnly(Context paramContext, AllInOne paramAllInOne)
  {
    paramContext = new Intent(paramContext, getProfileCardActivityClass());
    if (paramAllInOne != null) {
      paramContext.putExtra("AllInOne", paramAllInOne);
    }
    return paramContext;
  }
  
  public String getSchoolWithPrivacy(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.getSchoolWithPrivacy(paramProfileCardInfo);
  }
  
  public String getStringTrim(String paramString)
  {
    return ProfileAccountInfoUtils.getStringTrim(paramString);
  }
  
  public void inviteAskAnonymously(Activity paramActivity, boolean paramBoolean)
  {
    AskAnonymouslyUtil.Companion.inviteAskAnonymously(paramActivity, paramBoolean);
  }
  
  public boolean isFieldVisible(int paramInt, ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileAccountInfoUtils.isFieldVisible(paramInt, paramProfileCardInfo);
  }
  
  public boolean isProfileCardActivity(Context paramContext)
  {
    return paramContext instanceof FriendProfileCardActivity;
  }
  
  public void openProfileCard(Context paramContext, AllInOne paramAllInOne)
  {
    openProfileCard(paramContext, paramAllInOne, true);
  }
  
  public void openProfileCard(Context paramContext, AllInOne paramAllInOne, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramAllInOne != null)) {
      try
      {
        if (((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).openRobotProfileCard(paramContext, paramAllInOne)) {
          return;
        }
        paramAllInOne = getProfileCardIntent(paramContext, paramAllInOne);
        if (paramBoolean) {
          paramAllInOne.addFlags(536870912);
        }
        if (!(paramContext instanceof Activity)) {
          paramAllInOne.addFlags(268435456);
        }
        paramContext.startActivity(paramAllInOne);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("ProfileCardApiImpl", 1, "openProfileCard fail.", paramContext);
      }
    }
  }
  
  public void openProfileCardForResult(Activity paramActivity, AllInOne paramAllInOne, int paramInt)
  {
    if ((paramActivity != null) && (paramAllInOne != null)) {
      try
      {
        paramAllInOne = getProfileCardIntent(paramActivity, paramAllInOne);
        paramAllInOne.addFlags(536870912);
        paramActivity.startActivityForResult(paramAllInOne, paramInt);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("ProfileCardApiImpl", 1, "openProfileCardForResult fail.", paramActivity);
      }
    }
  }
  
  public void photoWallDelQzonePhotoWall(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong)
  {
    paramAppInterface = (PhotoWallHandler)paramAppInterface.getBusinessHandler(PhotoWallHandler.class.getName());
    if (paramAppInterface != null) {
      paramAppInterface.delQzonePhotoWall(paramString1, paramString2, paramLong);
    }
  }
  
  public void photoWallJump(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    PhotoWallView.jumpToPhotoWall(paramActivity, paramString, paramBoolean);
  }
  
  public void shareInviteToQZone(Activity paramActivity)
  {
    AskAnonymouslyUtil.Companion.shareInviteToQZone(paramActivity);
  }
  
  public boolean showProfileRedPointGuide(AppInterface paramAppInterface)
  {
    return AnonymousRedPointUtils.showProfileRedPointGuide(paramAppInterface);
  }
  
  public boolean showSettingMeRedPointGuide(AppInterface paramAppInterface)
  {
    return AnonymousRedPointUtils.showSettingMeRedPointGuide(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileCardApiImpl
 * JD-Core Version:    0.7.0.1
 */