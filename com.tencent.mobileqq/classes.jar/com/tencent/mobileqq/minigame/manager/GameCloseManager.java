package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bhdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogForMiniGame;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCloseManager
{
  private static final String MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES = GameWnsUtils.getBattleGameShowAlertViewScenes();
  private static final int MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD = ;
  private static final String PREF_KEY_MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES = "pref_key_mini_game_retain_confirm_exposure_times";
  private static final String PREF_KEY_MINI_GAME_RETAIN_CONFIRM_LAST_EXPOSE_TIMESTAMP = "pref_key_mini_game_retain_confirm_last_expose_timestamp";
  private static final int RETAIN_RECOMMEND_APP_NUM = 3;
  private static final int SCENE_JUMPING_GAME = 2113;
  private static final String TAG = "GameCloseManager";
  
  private static boolean checkInterval(Activity paramActivity)
  {
    int i = GameWnsUtils.getRetainConfirmInterval();
    long l = 0L;
    if ((paramActivity instanceof GameActivity1)) {
      l = ((GameActivity1)paramActivity).getStartTime();
    }
    l = (System.currentTimeMillis() - l) / 1000L;
    if (l > i)
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, duration=" + l + " timeInterval=" + i);
      return true;
    }
    return false;
  }
  
  private static void doShowRetainDialog(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString1, ArrayList<MiniAppInfo> paramArrayList, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    QQCustomDialogForMiniGame localQQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(paramActivity, 2131755829);
    localQQCustomDialogForMiniGame.setContentView(2131559043);
    localQQCustomDialogForMiniGame.setBodyLayoutNoMargin();
    View localView = LayoutInflater.from(paramActivity).inflate(2131559462, null, false);
    ((URLImageView)localView.findViewById(2131379030)).setBackgroundURL(GameWnsUtils.getGameRetainConfirmImageUrl());
    Object localObject = localView.findViewById(2131377211);
    if (!TextUtils.isEmpty(paramString2))
    {
      ((View)localObject).setVisibility(0);
      ((URLImageView)localView.findViewById(2131377210)).setBackgroundURL(paramString2);
    }
    for (;;)
    {
      paramString2 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(296.0F), -2);
      paramString2.gravity = 17;
      localObject = (LinearLayout)localView.findViewById(2131376357);
      int i = 0;
      while (i < 3)
      {
        GameCloseManager.MiniAppViewItem localMiniAppViewItem = new GameCloseManager.MiniAppViewItem(paramActivity);
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramArrayList.get(i);
        localMiniAppViewItem.setData(localMiniAppInfo, new GameCloseManager.1(localMiniAppInfo, localQQCustomDialogForMiniGame, paramOnClickListener, paramActivity));
        ((LinearLayout)localObject).addView(GameCloseManager.MiniAppViewItem.access$100(localMiniAppViewItem));
        i += 1;
      }
      ((View)localObject).setVisibility(8);
    }
    localQQCustomDialogForMiniGame.setCancelable(false);
    localQQCustomDialogForMiniGame.setTitle(null).setMessage(null).addView(localView, paramString2).setNegativeButton(2131694013, new GameCloseManager.3(paramMiniAppInfo, paramOnClickListener, paramActivity)).setPositiveButton(2131694014, new GameCloseManager.2(paramMiniAppInfo, paramString1, paramOnClickListener, paramActivity));
    localQQCustomDialogForMiniGame.getBtnight().setTypeface(Typeface.DEFAULT, 1);
    localQQCustomDialogForMiniGame.getBtnLeft().setTypeface(Typeface.DEFAULT, 1);
    localQQCustomDialogForMiniGame.show();
    MiniProgramLpReportDC04239.reportAsync("minigame_popup", "popup", "expo", "");
  }
  
  private static String getRetainInfoCache(String paramString1, int paramInt, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramString1 = "retain_confirm_" + paramString1 + "_" + str + "_" + String.valueOf(paramInt) + "_" + paramString2;
    return StorageUtil.getPreference().getString(paramString1, null);
  }
  
  private static int getShowTimes()
  {
    int i = 1;
    Object localObject = "pref_key_mini_game_retain_confirm_exposure_times_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int j = StorageUtil.getPreference().getInt((String)localObject, 0);
    localObject = "pref_key_mini_game_retain_confirm_last_expose_timestamp_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = StorageUtil.getPreference().getLong((String)localObject, 0L);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    if ((((Calendar)localObject).get(6) == localCalendar.get(6)) && (((Calendar)localObject).get(1) == localCalendar.get(1))) {}
    while (i == 0)
    {
      return 0;
      i = 0;
    }
    return j;
  }
  
  private static void handleClick(MiniAppInfo paramMiniAppInfo, String paramString, DialogInterface paramDialogInterface, int paramInt, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        break label72;
      }
      paramMiniAppInfo = new Intent(paramActivity, AppBrandLaunchUI.class);
      paramMiniAppInfo.putExtra("from", "SchemeJsPlugin");
      paramMiniAppInfo.putExtra("scheme", paramString);
      paramActivity.startActivity(paramMiniAppInfo);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(paramDialogInterface, paramInt);
      }
      return;
      try
      {
        label72:
        MiniAppController.launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, 2113);
      }
      catch (MiniAppException paramMiniAppInfo)
      {
        QLog.e("GameCloseManager", 1, "launch more game error", paramMiniAppInfo);
      }
    }
  }
  
  private static String parseBackgroundPic(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("backgroundPic");
  }
  
  private static MiniAppInfo parseMoreAppInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("moreAppInfo");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, moreAppStr == null");
      return null;
    }
    return (MiniAppInfo)GsonUtils.json2Obj(paramJSONObject, MiniAppInfo.class);
  }
  
  private static String parseMoreAppLink(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("jumpLink");
  }
  
  private static ArrayList<MiniAppInfo> parseRecommendList(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("appList");
    if ((paramJSONObject == null) || (paramJSONObject.length() < 3))
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, appList is empty or too small");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)GsonUtils.json2Obj(paramJSONObject.getString(i), MiniAppInfo.class);
      if (localMiniAppInfo != null) {
        localArrayList.add(localMiniAppInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean shouldShowAlertViewForBattleGame(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.whiteList != null) && (paramMiniAppConfig.launchParam != null))
    {
      QLog.d("GameCloseManager", 2, new Object[] { "shouldShowAlertViewForBattleGame ", " api " + Arrays.toString(paramMiniAppConfig.config.whiteList.toArray()) + " scenes " + MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES });
      Iterator localIterator = paramMiniAppConfig.config.whiteList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ("showRetainAlterViewType1".equals(localObject)) {
            return true;
          }
          if ((!((String)localObject).startsWith("showRetainAlterViewType")) || (TextUtils.isEmpty(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES))) {
            continue;
          }
          try
          {
            localObject = new JSONObject(MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES).optJSONArray(((String)localObject).replace("showRetainAlterViewType", ""));
            if (localObject != null)
            {
              int j = ((JSONArray)localObject).length();
              int i = 0;
              while (i < j)
              {
                int k = ((JSONArray)localObject).optInt(i, 0);
                int m = paramMiniAppConfig.launchParam.scene;
                if (k == m) {
                  return true;
                }
                i += 1;
              }
            }
          }
          catch (Exception localException)
          {
            QLog.e("GameCloseManager", 1, "shouldShowAlertViewForBattleGame ", localException);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean showAlertViewForBattleGame(GameActivity paramGameActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramGameActivity == null) || (paramMiniAppConfig == null)) {}
    while (!shouldShowAlertViewForBattleGame(paramMiniAppConfig)) {
      return false;
    }
    paramGameActivity = bhdj.a(paramGameActivity, 230).setTitle(paramGameActivity.getString(2131719342)).setMessage(paramGameActivity.getString(2131693969)).setNegativeButton(paramGameActivity.getString(2131690697), new GameCloseManager.5()).setPositiveButton(paramGameActivity.getString(2131693968), new GameCloseManager.4(paramOnClickListener));
    paramGameActivity.setCancelable(false);
    paramGameActivity.show();
    return true;
  }
  
  public static boolean showRetainGuideDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return false;
    }
    String str = paramMiniAppConfig.config.appId;
    if (paramMiniAppConfig.launchParam == null) {
      if (paramMiniAppConfig.config.via != null) {
        break label66;
      }
    }
    label66:
    for (paramMiniAppConfig = "";; paramMiniAppConfig = paramMiniAppConfig.config.via)
    {
      return showRetainGuideDialog(paramActivity, str, i, paramMiniAppConfig, paramOnClickListener);
      i = paramMiniAppConfig.launchParam.scene;
      break;
    }
  }
  
  public static boolean showRetainGuideDialog(Activity paramActivity, String paramString1, int paramInt, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    int i = paramActivity.getRequestedOrientation();
    boolean bool;
    if (Build.VERSION.SDK_INT >= 18) {
      if ((i == 0) || (i == 8) || (i == 6) || (i == 11)) {
        bool = true;
      }
    }
    int j;
    for (;;)
    {
      j = getShowTimes();
      if (j < MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD) {
        break;
      }
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, show too many times");
      return false;
      bool = false;
      continue;
      if ((i == 0) || (i == 8) || (i == 6)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramString2 = getRetainInfoCache(paramString1, paramInt, paramString2);
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, no result cache");
      return false;
    }
    paramString1 = null;
    try
    {
      Object localObject = new JSONObject(paramString2);
      if (checkInterval(paramActivity)) {
        return false;
      }
      paramString2 = parseMoreAppInfo((JSONObject)localObject);
      if (paramString2 == null) {
        return false;
      }
      ArrayList localArrayList = parseRecommendList((JSONObject)localObject);
      if ((localArrayList != null) && (localArrayList.size() >= 3))
      {
        if (!bool) {
          paramString1 = parseBackgroundPic((JSONObject)localObject);
        }
        localObject = parseMoreAppLink((JSONObject)localObject);
        QLog.i("GameCloseManager", 1, "orientation:" + i + " isLandscape:" + bool + " searchLeadImgUrl:" + paramString1 + " moreAppLink:" + (String)localObject);
        doShowRetainDialog(paramActivity, paramString2, (String)localObject, localArrayList, paramString1, paramOnClickListener);
        updateShowTimes(j);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("GameCloseManager", 1, "showRetainGuideDialog: not show, parse json error", paramActivity);
      return false;
    }
    return false;
  }
  
  private static void updateShowTimes(int paramInt)
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = "pref_key_mini_game_retain_confirm_exposure_times_" + str1;
    SharedPreferences.Editor localEditor = StorageUtil.getPreference().edit();
    localEditor.putInt(str2, paramInt + 1);
    localEditor.putLong("pref_key_mini_game_retain_confirm_last_expose_timestamp_" + str1, System.currentTimeMillis());
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager
 * JD-Core Version:    0.7.0.1
 */