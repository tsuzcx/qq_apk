package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IProfileCardBusinessApi
  extends QRouteApi
{
  public abstract String addNationCodeIfNeeded(AppRuntime paramAppRuntime, String paramString);
  
  public abstract IProfileConfig createProfileConfig(AppInterface paramAppInterface, IProfileConfigListener paramIProfileConfigListener);
  
  public abstract AbsProfileComponent createVasProfileComponent(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo);
  
  public abstract void dealTextViewForCopyAction(TextView paramTextView, String paramString1, String paramString2);
  
  public abstract Intent getBabyQProfileCardIntent(Context paramContext, AllInOne paramAllInOne);
  
  public abstract String getConstellation(int paramInt);
  
  public abstract String getJob(int paramInt);
  
  public abstract String getJobTag(int paramInt);
  
  public abstract Intent getKPLProfileCardIntent(Context paramContext);
  
  public abstract Class<?> getQQBrowserActivityClass();
  
  public abstract void initContactCardInfoList(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public abstract boolean isBindedIgnoreUpload(AppRuntime paramAppRuntime);
  
  public abstract boolean isDefaultProfile(ProfileCardInfo paramProfileCardInfo);
  
  public abstract boolean isEuropeAndAmerica();
  
  public abstract void jumpProfileOpenDetails(ProfileCardInfo paramProfileCardInfo, AppInterface paramAppInterface, Activity paramActivity);
  
  public abstract SpannableString makeSchoolAuthenticationIcon(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AppInterface paramAppInterface);
  
  public abstract String makeSexAgeArea(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public abstract byte needReqMedalWall(Context paramContext, AppRuntime paramAppRuntime);
  
  public abstract boolean needReqOCRCard(AppRuntime paramAppRuntime);
  
  public abstract void onProfileRedTouchClick(AppRuntime paramAppRuntime);
  
  public abstract boolean openRobotProfileCard(Context paramContext, AllInOne paramAllInOne);
  
  public abstract void setFriendComment(AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
 * JD-Core Version:    0.7.0.1
 */