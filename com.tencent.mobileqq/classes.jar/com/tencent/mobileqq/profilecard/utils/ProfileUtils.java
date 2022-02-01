package com.tencent.mobileqq.profilecard.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileComponentApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ProfileUtils
{
  static final long CLICK_INTERVAL_MS = 500L;
  private static final String TAG = "ProfileUtils";
  
  public static AbsProfileComponent create(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo, IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    return ((IProfileComponentApi)QRoute.api(IProfileComponentApi.class)).create(paramInt, paramIComponentCenter, paramProfileCardInfo, paramIProfileActivityDelegate);
  }
  
  public static String formatPraiseNum(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt < 10000)) {
      return String.valueOf(paramInt);
    }
    StringBuilder localStringBuilder;
    float f;
    if ((paramInt >= 10000) && (paramInt < 100000000))
    {
      if (paramInt % 10000 < 500)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 10000);
        localStringBuilder.append("万");
        return localStringBuilder.toString();
      }
      f = paramInt * 1.0F / 10000.0F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Math.round(f * 10.0F) * 1.0F / 10.0F);
      localStringBuilder.append("万");
      return localStringBuilder.toString();
    }
    if (paramInt >= 100000000)
    {
      if (paramInt % 100000000 < 5000000)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 100000000);
        localStringBuilder.append("亿");
        return localStringBuilder.toString();
      }
      f = paramInt * 1.0F / 1.0E+008F;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Math.round(f * 10.0F) * 1.0F / 10.0F);
      localStringBuilder.append("亿");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static ProfileContactInfo getCardContactInfo(AllInOne paramAllInOne)
  {
    if ((paramAllInOne != null) && (paramAllInOne.contactArray != null) && (!paramAllInOne.contactArray.isEmpty())) {
      return (ProfileContactInfo)paramAllInOne.contactArray.get(0);
    }
    return null;
  }
  
  public static long getControl(AllInOne paramAllInOne, boolean paramBoolean)
  {
    if (ProfilePAUtils.isPaTypeShowAccount(paramAllInOne)) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    long l2 = l1 | 0x4 | 0x10000;
    long l1 = l2;
    if (ProfilePAUtils.isPaTypeHasUin(paramAllInOne)) {
      l1 = l2 | 0x8;
    }
    l2 = l1 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800;
    l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (ProfilePAUtils.isPaTypeFriend(paramAllInOne)) {
        l1 = l2 | 0x2000;
      }
    }
    return l1;
  }
  
  public static Intent getIntent(Context paramContext, AllInOne paramAllInOne)
  {
    return ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntent(paramContext, paramAllInOne);
  }
  
  public static String getMobileNumberWithNationCode(AllInOne paramAllInOne)
  {
    Object localObject1 = getCardContactInfo(paramAllInOne);
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((ProfileContactInfo)localObject1).phoneNationalCode);
      ((StringBuilder)localObject2).append(((ProfileContactInfo)localObject1).phoneNumber);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramAllInOne.uin;
    }
    return localObject2;
  }
  
  public static long getTroopCode(AppInterface paramAppInterface, AllInOne paramAllInOne)
  {
    if ((paramAppInterface != null) && (paramAllInOne != null))
    {
      if (!TextUtils.isEmpty(paramAllInOne.troopCode))
      {
        paramAppInterface = paramAllInOne.troopCode;
        break label63;
      }
      if (!TextUtils.isEmpty(paramAllInOne.troopUin))
      {
        paramAppInterface = ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramAllInOne.troopUin);
        break label63;
      }
    }
    paramAppInterface = "0";
    try
    {
      label63:
      long l = Long.parseLong(paramAppInterface);
      return l;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("ProfileUtils", 1, "getTroopCode fail.", paramAppInterface);
    }
    return 0L;
  }
  
  public static boolean isFriend(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "");
      if (paramAppInterface != null) {
        return paramAppInterface.isFriend(paramString);
      }
    }
    return false;
  }
  
  public static boolean isValidClick(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static boolean isVisible(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.isShown())
      {
        Rect localRect = new Rect();
        paramView.getGlobalVisibleRect(localRect);
        bool1 = localRect.intersect(new Rect(0, 0, ViewUtils.a(), ViewUtils.b()));
      }
    }
    return bool1;
  }
  
  public static void openProfileCard(Context paramContext, AllInOne paramAllInOne)
  {
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCard(paramContext, paramAllInOne);
  }
  
  public static void openProfileCard(Context paramContext, AllInOne paramAllInOne, boolean paramBoolean)
  {
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCard(paramContext, paramAllInOne, paramBoolean);
  }
  
  public static void openProfileCardForResult(Activity paramActivity, AllInOne paramAllInOne, int paramInt)
  {
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCardForResult(paramActivity, paramAllInOne, paramInt);
  }
  
  public static void setViewClickInterval(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setClickable(false);
    paramView.postDelayed(new ProfileUtils.1(paramView), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileUtils
 * JD-Core Version:    0.7.0.1
 */