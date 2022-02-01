package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileSettingUtils$Companion;", "", "()V", "findProfileDisplaySettingItem", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "fieldId", "", "settingItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProfileDisplaySettingItem", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "configHelper", "Lcom/tencent/mobileqq/widget/ProfileConfigHelper;", "card", "Lcom/tencent/mobileqq/data/Card;", "type", "item", "", "cache", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/widget/ProfileConfigHelper;Lcom/tencent/mobileqq/data/Card;I[Ljava/lang/Object;Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "getProfileDisplaySettingItems", "", "outItems", "getProfileDisplaySettingStateFromCard", "fieldID", "hasDisplayItemStateChanged", "", "isNeedReqGetDisplaySettingItemStateFromServer", "isSpecDefaultClosedFieldId", "setProfileDisplaySettingStateToCard", "toState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileSettingUtils$Companion
{
  public final int a(int paramInt, @NotNull Card paramCard, @Nullable QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    switch (paramInt)
    {
    default: 
      paramCard = paramCard.profileDisplaySettingStates.get(paramInt, Integer.valueOf(-1));
      Intrinsics.checkExpressionValueIsNotNull(paramCard, "card.profileDisplaySetti…gConstants.INVALID_STATE)");
      paramInt = ((Number)paramCard).intValue();
    }
    do
    {
      do
      {
        return paramInt;
        paramInt = i;
      } while (paramCard.medalSwitchDisable);
      return 0;
      return paramCard.switchLifeAchievement;
      return paramCard.switchMusicBox;
      return paramCard.switchStickyNote;
      return paramCard.switchQQCircle;
      return paramCard.switchWeiShi;
      paramInt = i;
    } while (!paramCard.isShowCard);
    return 0;
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
  public final ProfileDisplaySettingItem a(@NotNull QQAppInterface paramQQAppInterface, @Nullable ProfileConfigHelper paramProfileConfigHelper, @NotNull Card paramCard, int paramInt, @NotNull Object[] paramArrayOfObject, @Nullable ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "item");
    if ((paramArrayOfObject.length <= 1) || (paramProfileConfigHelper == null)) {
      return null;
    }
    Object localObject = paramArrayOfObject[0];
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int j = ((Integer)localObject).intValue();
    paramArrayOfObject = paramArrayOfObject[1];
    if (paramArrayOfObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int k = ((Integer)paramArrayOfObject).intValue();
    paramArrayOfObject = (Integer)ProfileSettingConstants.a.a().get(j, Integer.valueOf(-1));
    if (paramArrayOfObject == null) {}
    while (paramArrayOfObject.intValue() != -1)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfObject, "config");
      if (paramProfileConfigHelper.a(paramArrayOfObject.intValue())) {
        break;
      }
      return null;
    }
    if ((j == 42356) && (!QZoneApiProxy.isRightAndroidVersionForStickyNote())) {
      return null;
    }
    if ((j == 42361) && (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
      return null;
    }
    if (j == 42172)
    {
      paramProfileConfigHelper = paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramProfileConfigHelper == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendManager");
      }
      paramProfileConfigHelper = (ExtendFriendManager)paramProfileConfigHelper;
      if ((paramCard.extendFriendEntryAddFriend != 1) || (!paramProfileConfigHelper.d())) {
        return null;
      }
    }
    if ((j == 42075) && (SharedPreUtils.X((Context)paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1)) {
      return null;
    }
    if ((j == 42488) && (!FansTroopUtils.a())) {
      return null;
    }
    if ((j == 42505) && (StudyModeManager.a())) {
      return null;
    }
    if (paramProfileDisplaySettingItem != null) {}
    for (int i = 1; i == 1; i = 0)
    {
      paramProfileDisplaySettingItem.c(((Companion)this).a(j, paramCard, paramQQAppInterface));
      return paramProfileDisplaySettingItem;
    }
    if (i == 0) {
      return new ProfileDisplaySettingItem(paramInt, j, ((Companion)this).a(j, paramCard, paramQQAppInterface), k);
    }
    throw new NoWhenBranchMatchedException();
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull Card paramCard, @NotNull QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramCard.profileDisplaySettingStates.put(paramInt1, Integer.valueOf(paramInt2));
    switch (paramInt1)
    {
    default: 
      return;
    case 42075: 
      bool2 = Util.a(paramQQAppInterface);
      if (paramInt2 == 1) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramCard.uin, 4).edit();
        localEditor.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        localEditor.commit();
        bool1 = Util.a(paramQQAppInterface);
        if (bool2 == bool1) {
          break;
        }
        Util.a(paramQQAppInterface, bool1);
        return;
        bool1 = false;
      }
    case 42367: 
      paramCard.switchLifeAchievement = ((short)paramInt2);
      return;
    case 42340: 
      paramCard.switchMusicBox = ((short)paramInt2);
      return;
    case 42356: 
      paramCard.switchStickyNote = ((short)paramInt2);
      return;
    case 42361: 
      paramCard.switchQQCircle = ((short)paramInt2);
      return;
    case 42377: 
      paramCard.switchWeiShi = ((short)paramInt2);
      return;
    }
    if (paramInt2 == 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramCard.isShowCard = bool1;
      return;
    }
  }
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Card paramCard, @Nullable ProfileConfigHelper paramProfileConfigHelper, @NotNull ArrayList<ProfileDisplaySettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "outItems");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ProfileDisplaySettingItem(5, 2131695068));
    Integer[][] arrayOfInteger = ProfileSettingConstants.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    Object localObject;
    ProfileDisplaySettingItem localProfileDisplaySettingItem;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localProfileDisplaySettingItem = ((Companion)this).a(localObject[0].intValue(), paramArrayList);
      localObject = ((Companion)this).a(paramQQAppInterface, paramProfileConfigHelper, paramCard, 1, (Object[])localObject, localProfileDisplaySettingItem);
      if (localObject != null) {
        switch (((ProfileDisplaySettingItem)localObject).b())
        {
        default: 
          ((ProfileDisplaySettingItem)localObject).d(2);
        }
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        ((ProfileDisplaySettingItem)localObject).d(1);
        continue;
        ((ProfileDisplaySettingItem)localObject).d(3);
      }
    }
    localArrayList.add(new ProfileDisplaySettingItem(5, 2131695070));
    arrayOfInteger = ProfileSettingConstants.a.b();
    j = arrayOfInteger.length;
    i = 0;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localProfileDisplaySettingItem = ((Companion)this).a(localObject[0].intValue(), paramArrayList);
      localProfileDisplaySettingItem = ((Companion)this).a(paramQQAppInterface, paramProfileConfigHelper, paramCard, 2, (Object[])localObject, localProfileDisplaySettingItem);
      if (localProfileDisplaySettingItem != null) {
        switch (localProfileDisplaySettingItem.b())
        {
        default: 
          localProfileDisplaySettingItem.d(2);
          label314:
          switch (localObject[0].intValue())
          {
          }
          break;
        }
      }
      for (;;)
      {
        localArrayList.add(localProfileDisplaySettingItem);
        i += 1;
        break;
        localProfileDisplaySettingItem.d(1);
        break label314;
        localProfileDisplaySettingItem.d(3);
        break label314;
        localArrayList.add(new ProfileDisplaySettingItem(4));
        localProfileDisplaySettingItem.a(3);
        localProfileDisplaySettingItem.b(2131710653);
        localProfileDisplaySettingItem.d(0);
      }
    }
    paramArrayList.clear();
    paramArrayList.addAll((Collection)localArrayList);
    localArrayList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = ProfileSettingConstants.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInteger[i].intValue() == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion
 * JD-Core Version:    0.7.0.1
 */