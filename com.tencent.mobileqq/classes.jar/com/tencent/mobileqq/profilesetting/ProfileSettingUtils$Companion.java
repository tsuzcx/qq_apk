package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileSettingUtils$Companion;", "", "()V", "findProfileDisplaySettingItem", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "fieldId", "", "settingItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProfileDisplaySettingItem", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "configHelper", "Lcom/tencent/mobileqq/profilecard/base/config/ProfileConfig;", "card", "Lcom/tencent/mobileqq/data/Card;", "type", "item", "", "cache", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/profilecard/base/config/ProfileConfig;Lcom/tencent/mobileqq/data/Card;I[Ljava/lang/Object;Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "getProfileDisplaySettingItems", "", "outItems", "getProfileDisplaySettingStateFromCard", "fieldID", "hasDisplayItemStateChanged", "", "isNeedReqGetDisplaySettingItemStateFromServer", "isSpecDefaultClosedFieldId", "setProfileDisplaySettingStateToCard", "toState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileSettingUtils$Companion
{
  public final int a(int paramInt, @NotNull Card paramCard, @Nullable QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    int i = 1;
    switch (paramInt)
    {
    default: 
      paramCard = paramCard.profileDisplaySettingStates.get(paramInt, Integer.valueOf(-1));
      Intrinsics.checkExpressionValueIsNotNull(paramCard, "card.profileDisplaySetti…ttingConst.INVALID_STATE)");
      return ((Number)paramCard).intValue();
    case 42377: 
      return paramCard.switchWeiShi;
    case 42367: 
      return paramCard.switchLifeAchievement;
    case 42361: 
      return paramCard.switchQQCircle;
    case 42356: 
      return paramCard.switchStickyNote;
    case 42340: 
      return paramCard.switchMusicBox;
    case 42172: 
      paramInt = i;
      if (!paramCard.isShowCard) {
        break;
      }
    case 42075: 
      if ((goto 150) && (paramCard.medalSwitchDisable)) {
        return 1;
      }
      paramInt = 0;
    }
    return paramInt;
  }
  
  @Nullable
  public final ProfileDisplaySettingItem a(int paramInt, @NotNull ArrayList<ProfileDisplaySettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ProfileDisplaySettingItem localProfileDisplaySettingItem = (ProfileDisplaySettingItem)paramArrayList.next();
      if (localProfileDisplaySettingItem.b() == paramInt) {
        return localProfileDisplaySettingItem;
      }
    }
    return null;
  }
  
  @Nullable
  public final ProfileDisplaySettingItem a(@NotNull QQAppInterface paramQQAppInterface, @Nullable ProfileConfig paramProfileConfig, @NotNull Card paramCard, int paramInt, @NotNull Object[] paramArrayOfObject, @Nullable ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "item");
    if (paramArrayOfObject.length > 1)
    {
      if (paramProfileConfig == null) {
        return null;
      }
      int i = 0;
      Object localObject = paramArrayOfObject[0];
      if (localObject != null)
      {
        int j = ((Integer)localObject).intValue();
        paramArrayOfObject = paramArrayOfObject[1];
        if (paramArrayOfObject != null)
        {
          int k = ((Integer)paramArrayOfObject).intValue();
          paramArrayOfObject = (Integer)ProfileSettingConstants.a.a().get(j, Integer.valueOf(-1));
          if ((paramArrayOfObject == null) || (paramArrayOfObject.intValue() != -1))
          {
            Intrinsics.checkExpressionValueIsNotNull(paramArrayOfObject, "config");
            if (!paramProfileConfig.isSwitchEnable(paramArrayOfObject.intValue())) {
              return null;
            }
          }
          if ((j == 42356) && (!QZoneApiProxy.isRightAndroidVersionForStickyNote())) {
            return null;
          }
          if ((j == 42361) && (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
            return null;
          }
          if ((j == 42172) && ((paramCard.extendFriendEntryAddFriend != 1) || (!((IExpandManagerProxy)QRoute.api(IExpandManagerProxy.class)).isResourceReady((AppRuntime)paramQQAppInterface)))) {
            return null;
          }
          if ((j == 42075) && (SharedPreUtils.U((Context)paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1)) {
            return null;
          }
          if ((j == 42488) && (!FansTroopUtils.a())) {
            return null;
          }
          if ((j == 42505) && (StudyModeManager.a())) {
            return null;
          }
          if (paramProfileDisplaySettingItem != null) {
            i = 1;
          }
          if (i == 1)
          {
            paramProfileDisplaySettingItem.c(((Companion)this).a(j, paramCard, paramQQAppInterface));
            return paramProfileDisplaySettingItem;
          }
          if (i == 0) {
            return new ProfileDisplaySettingItem(paramInt, j, ((Companion)this).a(j, paramCard, paramQQAppInterface), k);
          }
          throw new NoWhenBranchMatchedException();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull Card paramCard, @NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramCard.profileDisplaySettingStates.put(paramInt1, Integer.valueOf(paramInt2));
    boolean bool1 = false;
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      return;
    case 42377: 
      paramCard.switchWeiShi = ((short)paramInt2);
      return;
    case 42367: 
      paramCard.switchLifeAchievement = ((short)paramInt2);
      return;
    case 42361: 
      paramCard.switchQQCircle = ((short)paramInt2);
      return;
    case 42356: 
      paramCard.switchStickyNote = ((short)paramInt2);
      return;
    case 42340: 
      paramCard.switchMusicBox = ((short)paramInt2);
      return;
    case 42172: 
      bool1 = bool2;
      if (paramInt2 == 0) {
        bool1 = true;
      }
      paramCard.isShowCard = bool1;
      return;
    }
    bool2 = ((IUtil)QRoute.api(IUtil.class)).checkMedalRedPointConfig(paramQQAppInterface);
    if (paramInt2 == 1) {
      bool1 = true;
    }
    paramCard.medalSwitchDisable = bool1;
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("medal_wall_");
    localStringBuilder.append(paramCard.uin);
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
    ((SharedPreferences.Editor)localObject).commit();
    bool1 = ((IUtil)QRoute.api(IUtil.class)).checkMedalRedPointConfig(paramQQAppInterface);
    if (bool2 != bool1) {
      ((IUtil)QRoute.api(IUtil.class)).onMedalConfigChanged(paramQQAppInterface, bool1);
    }
  }
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Card paramCard, @Nullable ProfileConfig paramProfileConfig, @NotNull ArrayList<ProfileDisplaySettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "outItems");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ProfileDisplaySettingItem(5, 2131695058));
    Integer[][] arrayOfInteger = ProfileSettingConstants.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    Object localObject1;
    Object localObject2;
    int k;
    while (i < j)
    {
      localObject1 = arrayOfInteger[i];
      localObject2 = (Companion)this;
      localObject1 = ((Companion)localObject2).a(paramQQAppInterface, paramProfileConfig, paramCard, 1, (Object[])localObject1, ((Companion)localObject2).a(localObject1[0].intValue(), paramArrayList));
      if (localObject1 != null)
      {
        k = ((ProfileDisplaySettingItem)localObject1).b();
        if (k != 41611)
        {
          if (k != 41623) {
            ((ProfileDisplaySettingItem)localObject1).d(2);
          } else {
            ((ProfileDisplaySettingItem)localObject1).d(3);
          }
        }
        else {
          ((ProfileDisplaySettingItem)localObject1).d(1);
        }
        localArrayList.add(localObject1);
      }
      i += 1;
    }
    localArrayList.add(new ProfileDisplaySettingItem(5, 2131695060));
    arrayOfInteger = ProfileSettingConstants.a.b();
    j = arrayOfInteger.length;
    i = 0;
    while (i < j)
    {
      localObject1 = arrayOfInteger[i];
      localObject2 = (Companion)this;
      localObject2 = ((Companion)localObject2).a(paramQQAppInterface, paramProfileConfig, paramCard, 2, (Object[])localObject1, ((Companion)localObject2).a(localObject1[0].intValue(), paramArrayList));
      if (localObject2 != null)
      {
        k = ((ProfileDisplaySettingItem)localObject2).b();
        if (k != 42128) {
          if (k != 42377) {
            ((ProfileDisplaySettingItem)localObject2).d(2);
          }
        }
        for (;;)
        {
          break;
          ((ProfileDisplaySettingItem)localObject2).d(3);
          continue;
          ((ProfileDisplaySettingItem)localObject2).d(1);
        }
        if (localObject1[0].intValue() == 42172)
        {
          localArrayList.add(new ProfileDisplaySettingItem(4));
          ((ProfileDisplaySettingItem)localObject2).a(3);
          ((ProfileDisplaySettingItem)localObject2).b(2131710630);
          ((ProfileDisplaySettingItem)localObject2).d(0);
        }
        localArrayList.add(localObject2);
      }
      i += 1;
    }
    paramArrayList.clear();
    paramArrayList.addAll((Collection)localArrayList);
    localArrayList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    Integer[] arrayOfInteger = ProfileSettingConstants.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInteger[i].intValue() == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final boolean a(@NotNull ArrayList<ProfileDisplaySettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    return true;
  }
  
  public final boolean b(@NotNull ArrayList<ProfileDisplaySettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((ProfileDisplaySettingItem)paramArrayList.next()).a()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion
 * JD-Core Version:    0.7.0.1
 */