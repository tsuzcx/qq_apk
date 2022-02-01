package com.tencent.mobileqq.troop.utils.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopSPUtilApiImpl
  implements ITroopSPUtilApi
{
  private static final String KEY_AIO_TROOP_MINI_APP_ENTRANCE = "AIO_TROOP_MINI_APP_ENTRANCE";
  private static final String KEY_TROOP_APP_HAS_NEW = "key_troop_app_has_new";
  public static final String KEY_TROOP_GAME_CARD_RED_POINT = "troop_game_card_red_point";
  public static final String KEY_TROOP_GAME_CARD_RED_POINT_HAS_SHOWED = "troop_game_card_red_point_has_showed";
  private static final String TAG = "TroopSPUtilApiImpl";
  
  public boolean getAIOTroopMiniAppEntranceRedPoint(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      BaseApplication localBaseApplication = paramAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("AIO_TROOP_MINI_APP_ENTRANCE");
      return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString, false);
    }
    return false;
  }
  
  public boolean getGroupTIMFileNewsInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), paramBoolean);
  }
  
  public Object[] getKeyTroopLuckyCharacterStatus(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("troop_lucky_character_status");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("time");
      long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("troop_lucky_character_status");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("wording");
      paramString1 = localSharedPreferences.getString(localStringBuilder.toString(), paramString3);
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("getKeyTroopLuckyCharacterStatus troopUin = ");
        paramString3.append(paramString2);
        paramString3.append(", lastFetchTime = ");
        paramString3.append(l);
        paramString3.append(",wording");
        paramString3.append(paramString1);
        QLog.d("TroopSPUtilApiImpl", 2, paramString3.toString());
      }
      return new Object[] { Long.valueOf(l), paramString1 };
    }
    return null;
  }
  
  public int getTroopAioKeyWordVersion(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_aio_keyword_version");
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getTroopAioKeyWordVersion, version=");
      paramContext.append(i);
      QLog.i("SharedPreUtils", 2, paramContext.toString());
    }
    return i;
  }
  
  public boolean getTroopHasNewApp(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      BaseApplication localBaseApplication = paramAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("key_troop_app_has_new");
      return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString, false);
    }
    return false;
  }
  
  public int groupGroupNewsInfo(String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("troop_news_notify", i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
  }
  
  public boolean hasShowTroopGameCardRedPoint(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("troop_game_card_red_point_has_showed");
    localStringBuilder.append(paramString2);
    boolean bool = localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("hasShowTroopGameCardRedPoint troopUin = ");
      paramString1.append(paramString2);
      paramString1.append(", isShow = ");
      paramString1.append(bool);
      QLog.d("TroopSPUtilApiImpl", 2, paramString1.toString());
    }
    return bool;
  }
  
  public boolean isShowTroopGameCardRedPoint(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      return false;
    }
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopGameCard(paramString2)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      return false;
    }
    localObject = ((ITroopInfoService)((AppRuntime)localObject).getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString2);
    if (localObject == null) {
      return false;
    }
    if (((TroopInfo)localObject).isHomeworkTroop()) {
      return false;
    }
    if (!((TroopInfo)localObject).isTroopGameCardEnabled()) {
      return false;
    }
    localObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    if (hasShowTroopGameCardRedPoint(paramString1, paramString2)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("troop_game_card_red_point");
    localStringBuilder.append(paramString2);
    paramBoolean = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), paramBoolean);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("isShowTroopGameCardRedPoint troopUin = ");
      paramString1.append(paramString2);
      paramString1.append(", isShow = ");
      paramString1.append(paramBoolean);
      QLog.d("TroopSPUtilApiImpl", 2, paramString1.toString());
    }
    return paramBoolean;
  }
  
  public void setAIOTroopMiniAppEntranceRedPoint(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      MobileQQ localMobileQQ = paramAppRuntime.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("AIO_TROOP_MINI_APP_ENTRANCE");
      localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString, paramBoolean).apply();
    }
  }
  
  public void setGroupGroupNewsInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("troop_news_notify", i).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void setGroupPadTemplateNewsInfoTips(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public void setGroupTIMFileNewsInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("group_file_inner_reddot_tim");
      localStringBuilder.append(paramString3);
      localEditor.putBoolean(localStringBuilder.toString(), true);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("group_file_reddot_tim");
      localStringBuilder.append(paramString3);
      localEditor.putBoolean(localStringBuilder.toString(), true);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("group_file_inner_reddot_tim");
      localStringBuilder.append(paramString3);
      localEditor.putBoolean(localStringBuilder.toString(), false);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("group_file_reddot_tim");
      localStringBuilder.append(paramString3);
      localEditor.putBoolean(localStringBuilder.toString(), false);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public void setTroopGameCardRedPoint(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopGameCardRedPoint troopUin = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", isShowRedPoint = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopSPUtilApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("troop_game_card_red_point");
    localStringBuilder.append(paramString2);
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  public void setTroopGameCardRedPointHasShowed(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopGameCardRedPointHasShowed troopUin = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", isShowRedPoint = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopSPUtilApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("troop_game_card_red_point_has_showed");
    localStringBuilder.append(paramString2);
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  public void setTroopHasNewApp(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      BaseApplication localBaseApplication = paramAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("key_troop_app_has_new");
      localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString, paramBoolean).apply();
    }
  }
  
  public void updateTroopAioKeyWordVersion(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_aio_keyword_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.TroopSPUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */