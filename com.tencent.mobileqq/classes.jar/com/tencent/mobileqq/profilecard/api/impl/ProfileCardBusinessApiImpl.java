package com.tencent.mobileqq.profilecard.api.impl;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.KPLProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.profilecard.api.IVasProfileComponentFactory;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ProfileCardBusinessApiImpl
  implements IProfileCardBusinessApi
{
  public String addNationCodeIfNeeded(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.startsWith("+"))
      {
        localObject = paramString;
        if (paramString.length() == 11)
        {
          localObject = paramString;
          if (!paramString.startsWith("0"))
          {
            paramAppRuntime = ((IPhoneContactService)paramAppRuntime.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
            if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramAppRuntime.nationCode)))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramAppRuntime.nationCode);
              ((StringBuilder)localObject).append(paramString.trim());
              return ((StringBuilder)localObject).toString();
            }
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("+86");
            paramAppRuntime.append(paramString.trim());
            localObject = paramAppRuntime.toString();
          }
        }
      }
    }
    return localObject;
  }
  
  public IProfileConfig createProfileConfig(AppInterface paramAppInterface, IProfileConfigListener paramIProfileConfigListener)
  {
    return new ProfileConfig(paramAppInterface, paramIProfileConfigListener);
  }
  
  public AbsProfileComponent createVasProfileComponent(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    return ((IVasProfileComponentFactory)QRoute.api(IVasProfileComponentFactory.class)).create(paramInt, paramIComponentCenter, paramProfileCardInfo);
  }
  
  public void dealTextViewForCopyAction(TextView paramTextView, String paramString1, String paramString2)
  {
    ProfileCardUtil.a(paramTextView, paramString1, paramString2);
  }
  
  public Intent getBabyQProfileCardIntent(Context paramContext, AllInOne paramAllInOne)
  {
    if ((Utils.c(paramAllInOne.uin)) && (!TextUtils.isEmpty(Utils.d)))
    {
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", Utils.d);
      return paramContext;
    }
    return null;
  }
  
  public String getConstellation(int paramInt)
  {
    return NearbyProfileUtil.e(paramInt);
  }
  
  public String getJob(int paramInt)
  {
    return NearbyProfileUtil.h(paramInt);
  }
  
  public String getJobTag(int paramInt)
  {
    return NearbyProfileUtil.f(paramInt);
  }
  
  public Intent getKPLProfileCardIntent(Context paramContext)
  {
    return KPLProfileCardActivity.a(paramContext);
  }
  
  public Class<?> getQQBrowserActivityClass()
  {
    return QQBrowserActivity.class;
  }
  
  public void initContactCardInfoList(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if ((ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne)) || (paramProfileCardInfo.allInOne.pa == 33) || (paramProfileCardInfo.allInOne.pa == 32) || (paramProfileCardInfo.allInOne.pa == 31) || (paramProfileCardInfo.allInOne.pa == 34) || (paramProfileCardInfo.allInOne.pa == 51) || (paramProfileCardInfo.allInOne.pa == 50) || (paramProfileCardInfo.allInOne.pa == 36) || (paramProfileCardInfo.allInOne.pa == 29) || (paramProfileCardInfo.allInOne.pa == 53))
    {
      if (paramProfileCardInfo.allInOne.contactArray == null) {
        paramProfileCardInfo.allInOne.contactArray = new ArrayList();
      }
      if (paramProfileCardInfo.allInOne.contactArray.size() == 0)
      {
        IPhoneContactService localIPhoneContactService = (IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (localIPhoneContactService == null) {
          return;
        }
        Object localObject2;
        Object localObject1;
        if (ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne))
        {
          localObject2 = localIPhoneContactService.queryPhoneContactByUin(paramProfileCardInfo.allInOne.uin);
          localObject1 = localObject2;
          if (!paramBoolean)
          {
            paramAppInterface = (FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            localObject1 = localObject2;
            if (!paramAppInterface.isGetOnlineListRecently())
            {
              localObject1 = localObject2;
              if (!paramAppInterface.shouldGetOnlineInfo())
              {
                paramAppInterface.getOnlineInfo(paramProfileCardInfo.allInOne.uin, false);
                localObject1 = localObject2;
              }
            }
          }
        }
        else
        {
          localObject2 = localIPhoneContactService.queryContactByCodeNumber(paramProfileCardInfo.allInOne.uin);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = localIPhoneContactService.queryPhoneContactByMobile(paramProfileCardInfo.allInOne.uin);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
              {
                paramProfileCardInfo.allInOne.uin = ((PhoneContact)localObject2).mobileCode;
                localObject1 = localObject2;
              }
            }
          }
          localObject2 = localObject1;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            paramAppInterface = (FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            localObject1 = localObject2;
            if (!paramAppInterface.shouldGetOnlineInfo())
            {
              paramAppInterface.getOnlineInfo(paramProfileCardInfo.allInOne.uin, true);
              localObject1 = localObject2;
            }
          }
        }
        if (paramProfileCardInfo.allInOne.pa == 53)
        {
          paramProfileCardInfo.allInOne.contactArray.add(new ProfileContactInfo(paramProfileCardInfo.allInOne.contactName, paramProfileCardInfo.allInOne.uin, ""));
          return;
        }
        if (localObject1 != null)
        {
          paramProfileCardInfo.allInOne.contactArray.add(new ProfileContactInfo(localObject1.name, localObject1.mobileCode, localObject1.nationCode));
          return;
        }
        if ((paramProfileCardInfo.allInOne.pa == 33) || (paramProfileCardInfo.allInOne.pa == 32) || (paramProfileCardInfo.allInOne.pa == 31) || (paramProfileCardInfo.allInOne.pa == 34) || (paramProfileCardInfo.allInOne.pa == 51) || (paramProfileCardInfo.allInOne.pa == 50) || (paramProfileCardInfo.allInOne.pa == 36) || (paramProfileCardInfo.allInOne.pa == 29)) {
          paramProfileCardInfo.allInOne.contactArray.add(new ProfileContactInfo("", paramProfileCardInfo.allInOne.uin, ""));
        }
      }
    }
  }
  
  public boolean isBindedIgnoreUpload(AppRuntime paramAppRuntime)
  {
    return ((IPhoneContactService)paramAppRuntime.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload();
  }
  
  public boolean isDefaultProfile(ProfileCardInfo paramProfileCardInfo)
  {
    return ProfileCardUtils.isDefaultProfile(paramProfileCardInfo);
  }
  
  public boolean isEuropeAndAmerica()
  {
    return ProfileCardUtil.c();
  }
  
  public void jumpProfileOpenDetails(ProfileCardInfo paramProfileCardInfo, AppInterface paramAppInterface, Activity paramActivity)
  {
    ProfileCardUtil.a(paramProfileCardInfo, (QQAppInterface)paramAppInterface, paramActivity);
  }
  
  public SpannableString makeSchoolAuthenticationIcon(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AppInterface paramAppInterface)
  {
    return ProfileCardUtil.a(paramString, paramBoolean, paramInt1, paramInt2, paramInt3, paramContext, (QQAppInterface)paramAppInterface);
  }
  
  public String makeSexAgeArea(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    return ProfileCardUtil.a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public byte needReqMedalWall(Context paramContext, AppRuntime paramAppRuntime)
  {
    return (byte)SharedPreUtils.am(paramContext, paramAppRuntime.getCurrentAccountUin());
  }
  
  public boolean needReqOCRCard(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (BusinessCardManager)paramAppRuntime.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
    if (paramAppRuntime != null) {
      return paramAppRuntime.b(1);
    }
    return false;
  }
  
  public void onProfileRedTouchClick(AppRuntime paramAppRuntime)
  {
    ((LocalRedTouchManager)paramAppRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(true);
  }
  
  public boolean openRobotProfileCard(Context paramContext, AllInOne paramAllInOne)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (RobotUtils.a((QQAppInterface)localAppRuntime, paramAllInOne.uin)))
    {
      RobotUtils.a(paramContext, null, paramAllInOne.uin);
      return true;
    }
    return false;
  }
  
  public void setFriendComment(AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramAppInterface = (FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppInterface != null) {
      paramAppInterface.setFriendComment(paramString1, paramString2, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileCardBusinessApiImpl
 * JD-Core Version:    0.7.0.1
 */