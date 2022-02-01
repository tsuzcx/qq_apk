package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class ProfileNameUtils
{
  private static final int[] HANDLE_UPDATE_PROFILE_NAME_TYPE = { 0, 60, 1, 20, 21, 58, 22, 46, 47, 30, 31, 32, 33, 34, 36, 29, 53, 40, 41, 42, 86, 50, 51, 52, 4, 77, 82, 81, 83, 84, 101, 103, 102, 107, 110, 25, 28, 108, 26, 27, 72, 71 };
  private static final String TAG = "ProfileNameUtils";
  
  public static String getCurCardName(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = paramProfileCardInfo.nameArray[4];
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramProfileCardInfo.nameArray[0];
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramProfileCardInfo.allInOne.uin;
    }
    return localObject2;
  }
  
  public static void initNameArray(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject4 = paramProfileCardInfo.allInOne.nickname;
    Object localObject9 = paramProfileCardInfo.allInOne.remark;
    Object localObject8 = paramProfileCardInfo.allInOne.troopNickName;
    String str2 = paramProfileCardInfo.allInOne.recommendName;
    String str1 = paramProfileCardInfo.allInOne.contactName;
    String str4 = paramProfileCardInfo.allInOne.alias;
    String str3 = paramProfileCardInfo.allInOne.circleName;
    Object localObject2 = localObject4;
    Object localObject6 = localObject9;
    Object localObject7 = localObject8;
    Object localObject5;
    try
    {
      localObject5 = (IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "");
      localObject2 = localObject4;
      localObject6 = localObject9;
      localObject7 = localObject8;
      Object localObject3;
      Object localObject10;
      if (ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne))
      {
        ??? = localObject4;
        localObject3 = localObject9;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject10 = ((IFriendDataService)localObject5).getFriend(paramProfileCardInfo.allInOne.uin, true, true);
          ??? = localObject4;
          localObject3 = localObject9;
          if (localObject10 != null)
          {
            localObject5 = localObject4;
            localObject2 = localObject4;
            localObject6 = localObject9;
            localObject7 = localObject8;
            if (!TextUtils.isEmpty(((Friends)localObject10).name))
            {
              localObject2 = localObject4;
              localObject6 = localObject9;
              localObject7 = localObject8;
              localObject5 = ((Friends)localObject10).name;
            }
            ??? = localObject5;
            localObject3 = localObject9;
            localObject2 = localObject5;
            localObject6 = localObject9;
            localObject7 = localObject8;
            if (!TextUtils.isEmpty(((Friends)localObject10).remark))
            {
              localObject2 = localObject5;
              localObject6 = localObject9;
              localObject7 = localObject8;
              localObject3 = ((Friends)localObject10).remark;
              ??? = localObject5;
            }
          }
        }
      }
      else
      {
        localObject2 = localObject4;
        localObject6 = localObject9;
        localObject7 = localObject8;
        if (paramProfileCardInfo.allInOne.pa == 0)
        {
          ??? = localObject4;
          localObject3 = localObject9;
          if (localObject5 != null)
          {
            localObject2 = localObject4;
            localObject6 = localObject9;
            localObject7 = localObject8;
            localObject5 = ((IFriendDataService)localObject5).getFriend(paramProfileCardInfo.allInOne.uin, true, true);
            ??? = localObject4;
            localObject3 = localObject9;
            if (localObject5 != null)
            {
              localObject2 = localObject4;
              localObject6 = localObject9;
              localObject7 = localObject8;
              if (!TextUtils.isEmpty(((Friends)localObject5).name))
              {
                localObject2 = localObject4;
                localObject6 = localObject9;
                localObject7 = localObject8;
                ??? = ((Friends)localObject5).name;
                localObject3 = localObject9;
              }
              else
              {
                localObject2 = localObject4;
                localObject6 = localObject9;
                localObject7 = localObject8;
                ??? = paramProfileCardInfo.allInOne.uin;
                localObject3 = localObject9;
              }
            }
          }
        }
        else
        {
          ??? = localObject4;
          localObject3 = localObject9;
          localObject2 = localObject4;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            ??? = localObject4;
            localObject3 = localObject9;
            localObject2 = localObject4;
            localObject6 = localObject9;
            localObject7 = localObject8;
            if (ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne))
            {
              localObject2 = localObject4;
              localObject6 = localObject9;
              localObject7 = localObject8;
              ??? = ((IFriendDataService)localObject5).getFriend(paramProfileCardInfo.allInOne.uin, true, true);
              localObject5 = localObject4;
              if (??? != null)
              {
                localObject2 = localObject4;
                localObject6 = localObject9;
                localObject7 = localObject8;
                localObject5 = ((Friends)???).getFriendNick();
              }
              ??? = localObject5;
              localObject3 = localObject9;
              localObject2 = localObject5;
              localObject6 = localObject9;
              localObject7 = localObject8;
              if (Utils.a(localObject5, paramProfileCardInfo.allInOne.uin))
              {
                ??? = null;
                localObject3 = localObject9;
              }
            }
          }
        }
      }
      localObject4 = localObject8;
      localObject2 = ???;
      localObject6 = localObject3;
      localObject7 = localObject8;
      if (!TextUtils.isEmpty(paramProfileCardInfo.troopUin))
      {
        localObject2 = ???;
        localObject6 = localObject3;
        localObject7 = localObject8;
        paramAppInterface = (ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "");
        localObject4 = localObject8;
        if (paramAppInterface != null)
        {
          localObject2 = ???;
          localObject6 = localObject3;
          localObject7 = localObject8;
          localObject4 = paramAppInterface.getTroopMemberColorNick(paramProfileCardInfo.troopUin, paramProfileCardInfo.allInOne.uin);
        }
      }
      localObject2 = ???;
      localObject6 = localObject3;
      localObject7 = localObject4;
      paramAppInterface = (AppInterface)???;
      localObject5 = localObject3;
      localObject8 = localObject4;
      localObject9 = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject2 = ???;
        localObject6 = localObject3;
        localObject7 = localObject4;
        localObject10 = ProfileUtils.getCardContactInfo(paramProfileCardInfo.allInOne);
        paramAppInterface = (AppInterface)???;
        localObject5 = localObject3;
        localObject8 = localObject4;
        localObject9 = str1;
        if (localObject10 != null)
        {
          localObject2 = ???;
          localObject6 = localObject3;
          localObject7 = localObject4;
          localObject9 = ((ProfileContactInfo)localObject10).phoneName;
          paramAppInterface = (AppInterface)???;
          localObject5 = localObject3;
          localObject8 = localObject4;
        }
      }
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("ProfileNameUtils", 1, "initNameList fail.", paramAppInterface);
      localObject9 = str1;
      localObject8 = localObject7;
      localObject5 = localObject6;
      paramAppInterface = localObject2;
    }
    synchronized (paramProfileCardInfo.nameArray)
    {
      setCardInfoNameArray(paramProfileCardInfo, paramAppInterface, (String)localObject5, (String)localObject8, str2, (String)localObject9, str4, str3);
      if (QLog.isColorLevel())
      {
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append("initNameList(), strNick = ");
        paramProfileCardInfo.append(Utils.i(paramAppInterface));
        paramProfileCardInfo.append(", strRemark = ");
        paramProfileCardInfo.append(Utils.i((String)localObject5));
        paramProfileCardInfo.append(", strContactName = ");
        paramProfileCardInfo.append(Utils.i((String)localObject9));
        paramProfileCardInfo.append(", strRecommendName = ");
        paramProfileCardInfo.append(Utils.i(str2));
        paramProfileCardInfo.append(", strTroopNickName = ");
        paramProfileCardInfo.append(Utils.i((String)localObject8));
        paramProfileCardInfo.append(", strCircleName = ");
        paramProfileCardInfo.append(Utils.i(str3));
        paramProfileCardInfo.append(", strAutoRemark = ");
        paramProfileCardInfo.append(Utils.i(str2));
        QLog.d("ProfileNameUtils", 2, paramProfileCardInfo.toString());
      }
      return;
    }
  }
  
  private static boolean isNeedHandleUpdateProfileNameDefault(int paramInt)
  {
    int[] arrayOfInt = HANDLE_UPDATE_PROFILE_NAME_TYPE;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static void setCardInfoNameArray(ProfileCardInfo paramProfileCardInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[0])) {
      paramProfileCardInfo.nameArray[0] = paramString1;
    }
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[4])) {
      paramProfileCardInfo.nameArray[4] = paramString2;
    }
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[3])) {
      paramProfileCardInfo.nameArray[3] = paramString5;
    }
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[5])) {
      paramProfileCardInfo.nameArray[5] = paramString4;
    }
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[1])) {
      paramProfileCardInfo.nameArray[1] = paramString3;
    }
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[6])) {
      paramProfileCardInfo.nameArray[6] = paramString6;
    }
    if (TextUtils.isEmpty(paramProfileCardInfo.nameArray[2])) {
      paramProfileCardInfo.nameArray[2] = paramString7;
    }
  }
  
  private static void setProfileTypeParamValue1(ProfileCardInfo paramProfileCardInfo, ProfileNameUtils.ProfileTypeParam paramProfileTypeParam)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 60) {
          return;
        }
        paramProfileTypeParam.idType = 2;
        paramProfileTypeParam.fromType = 2;
        return;
      }
      if (paramProfileCardInfo.isTroopMemberCard)
      {
        paramProfileTypeParam.idType = 2;
        paramProfileTypeParam.fromType = 3;
        return;
      }
      paramProfileTypeParam.idType = 2;
      paramProfileTypeParam.fromType = 2;
      return;
    }
    if (paramProfileCardInfo.isTroopMemberCard)
    {
      paramProfileTypeParam.idType = 2;
      paramProfileTypeParam.fromType = 3;
      return;
    }
    paramProfileTypeParam.idType = 2;
    paramProfileTypeParam.fromType = 1;
  }
  
  private static void setProfileTypeParamValue2(ProfileCardInfo paramProfileCardInfo, ProfileNameUtils.ProfileTypeParam paramProfileTypeParam)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if (i != 30)
    {
      if (i != 58)
      {
        if ((i != 46) && (i != 47)) {}
        switch (i)
        {
        default: 
          return;
        case 20: 
          paramProfileTypeParam.idType = 2;
          paramProfileTypeParam.fromType = 3;
          return;
          paramProfileTypeParam.idType = 1;
          paramProfileTypeParam.fromType = 4;
          return;
        }
      }
      paramProfileTypeParam.idType = 1;
      paramProfileTypeParam.fromType = 3;
      return;
    }
    paramProfileTypeParam.idType = 2;
    paramProfileTypeParam.fromType = 6;
  }
  
  private static void setProfileTypeParamValue3(ProfileCardInfo paramProfileCardInfo, ProfileNameUtils.ProfileTypeParam paramProfileTypeParam)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if ((i != 29) && (i != 36)) {
      if (i != 53) {
        if (i == 86) {}
      }
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        return;
      case 40: 
        paramProfileTypeParam.idType = 2;
        paramProfileTypeParam.fromType = 7;
        return;
      }
      paramProfileTypeParam.idType = 1;
      paramProfileTypeParam.fromType = 7;
      return;
      paramProfileTypeParam.idType = 1;
      paramProfileTypeParam.fromType = 6;
      if ((paramProfileCardInfo.contactCard != null) && (!TextUtils.isEmpty(paramProfileCardInfo.contactCard.uin)))
      {
        paramProfileTypeParam.idType = 3;
        return;
      }
      break;
    case 31: 
    case 32: 
    case 33: 
    case 34: 
      paramProfileTypeParam.idType = 1;
      paramProfileTypeParam.fromType = 6;
    }
  }
  
  private static void setProfileTypeParamValue4(ProfileCardInfo paramProfileCardInfo, ProfileNameUtils.ProfileTypeParam paramProfileTypeParam)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if ((i != 4) && (i != 77) && (i != 107) && (i != 110))
    {
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            return;
          }
          break;
        }
      case 52: 
        paramProfileTypeParam.idType = 1;
        paramProfileTypeParam.fromType = 9;
        return;
      }
      paramProfileTypeParam.idType = 1;
      paramProfileTypeParam.fromType = 8;
      return;
    }
    paramProfileTypeParam.idType = 1;
    paramProfileTypeParam.fromType = 11;
  }
  
  private static void setProfileTypeParamValue5(ProfileCardInfo paramProfileCardInfo, ProfileNameUtils.ProfileTypeParam paramProfileTypeParam)
  {
    int i = paramProfileCardInfo.allInOne.pa;
    if ((i != 71) && (i != 72))
    {
      if (i != 108) {
        switch (i)
        {
        default: 
          return;
        }
      }
      paramProfileTypeParam.idType = 1;
      return;
    }
    paramProfileTypeParam.idType = 1;
    paramProfileTypeParam.fromType = 5;
  }
  
  public static void updateNameArray(ProfileCardInfo paramProfileCardInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileNameUtils", 2, String.format("updateNameArray profileCardInfo=%s type=%s value=%s", new Object[] { paramProfileCardInfo, Integer.valueOf(paramInt), paramString }));
    }
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.nameArray != null) && (paramInt >= 0) && (paramInt < paramProfileCardInfo.nameArray.length)) {
      paramProfileCardInfo.nameArray[paramInt] = paramString;
    }
  }
  
  public static void updateProfileName(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.profileName == null) {
      paramProfileCardInfo.profileName = new MQQProfileName();
    }
    ProfileNameUtils.ProfileTypeParam localProfileTypeParam = new ProfileNameUtils.ProfileTypeParam(null);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProfileName begin ProfileTypeParam: ");
      localStringBuilder.append(localProfileTypeParam);
      QLog.d("ProfileNameUtils", 2, localStringBuilder.toString());
    }
    setProfileTypeParamValue1(paramProfileCardInfo, localProfileTypeParam);
    setProfileTypeParamValue2(paramProfileCardInfo, localProfileTypeParam);
    setProfileTypeParamValue3(paramProfileCardInfo, localProfileTypeParam);
    setProfileTypeParamValue4(paramProfileCardInfo, localProfileTypeParam);
    setProfileTypeParamValue5(paramProfileCardInfo, localProfileTypeParam);
    if (!isNeedHandleUpdateProfileNameDefault(paramProfileCardInfo.allInOne.pa))
    {
      localProfileTypeParam.idType = 1;
      localProfileTypeParam.fromType = 0;
    }
    MQQProfileNameTranslator.a(localProfileTypeParam.fromType, localProfileTypeParam.idType, paramProfileCardInfo.nameArray, paramProfileCardInfo.profileName);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProfileName end ProfileTypeParam: ");
      localStringBuilder.append(localProfileTypeParam);
      QLog.d("ProfileNameUtils", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileNameUtils", 2, String.format("updateProfileName profileName: %s", new Object[] { paramProfileCardInfo.profileName.toString() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.utils.ProfileNameUtils
 * JD-Core Version:    0.7.0.1
 */