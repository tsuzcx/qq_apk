package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bglp;
import bgpa;
import bgpo;
import bgtn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
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
    if ((paramActivity instanceof GameActivity)) {
      l = ((GameActivity)paramActivity).getStartTime();
    }
    for (;;)
    {
      l = (System.currentTimeMillis() - l) / 1000L;
      if (l <= i) {
        break;
      }
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, duration=" + l + " timeInterval=" + i);
      return true;
      if ((paramActivity instanceof GameActivity1)) {
        l = ((GameActivity1)paramActivity).getStartTime();
      }
    }
    return false;
  }
  
  private static void doShowRetainDialog(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ArrayList<MiniAppInfo> paramArrayList, DialogInterface.OnClickListener paramOnClickListener)
  {
    bgpo localbgpo = new bgpo(paramActivity, 2131755823);
    localbgpo.setContentView(2131559009);
    localbgpo.setBodyLayoutNoMargin();
    View localView = LayoutInflater.from(paramActivity).inflate(2131559425, null, false);
    ((URLImageView)localView.findViewById(2131378807)).setBackgroundURL(GameWnsUtils.getGameRetainConfirmImageUrl());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bgtn.b(296.0F), bgtn.b(166.0F));
    localLayoutParams.gravity = 17;
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131376203);
    int i = 0;
    while (i < 3)
    {
      GameCloseManager.MiniAppViewItem localMiniAppViewItem = new GameCloseManager.MiniAppViewItem(paramActivity);
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramArrayList.get(i);
      localMiniAppViewItem.setData(localMiniAppInfo, new GameCloseManager.1(localMiniAppInfo, localbgpo, paramOnClickListener, paramActivity));
      localLinearLayout.addView(GameCloseManager.MiniAppViewItem.access$100(localMiniAppViewItem));
      i += 1;
    }
    localbgpo.setCancelable(false);
    localbgpo.setTitle(null).setMessage(null).addView(localView, localLayoutParams).setNegativeButton(2131693708, new GameCloseManager.3(paramMiniAppInfo, paramOnClickListener, paramActivity)).setPositiveButton(2131693709, new GameCloseManager.2(paramMiniAppInfo, paramOnClickListener, paramActivity));
    localbgpo.getBtnight().setTypeface(Typeface.DEFAULT, 1);
    localbgpo.getBtnLeft().setTypeface(Typeface.DEFAULT, 1);
    localbgpo.show();
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
  
  private static void handleClick(MiniAppInfo paramMiniAppInfo, DialogInterface paramDialogInterface, int paramInt, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      MiniAppController.launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, 2113);
      paramDialogInterface.dismiss();
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(paramDialogInterface, paramInt);
      }
      return;
    }
    catch (MiniAppException paramMiniAppInfo)
    {
      for (;;)
      {
        QLog.e("GameCloseManager", 1, "launch more game error", paramMiniAppInfo);
      }
    }
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
    paramGameActivity = bglp.a(paramGameActivity, 230).setTitle(paramGameActivity.getString(2131718563)).setMessage(paramGameActivity.getString(2131693676)).setNegativeButton(paramGameActivity.getString(2131690582), new GameCloseManager.5()).setPositiveButton(paramGameActivity.getString(2131693675), new GameCloseManager.4(paramOnClickListener));
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
        break label65;
      }
    }
    label65:
    for (paramMiniAppConfig = "";; paramMiniAppConfig = paramMiniAppConfig.config.via)
    {
      return showRetainGuideDialog(paramActivity, str, i, paramMiniAppConfig, paramOnClickListener);
      i = paramMiniAppConfig.launchParam.scene;
      break;
    }
  }
  
  public static boolean showRetainGuideDialog(Activity paramActivity, String paramString1, int paramInt, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return false;
      int i = getShowTimes();
      if (i >= MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD)
      {
        QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, show too many times");
        return false;
      }
      paramString1 = getRetainInfoCache(paramString1, paramInt, paramString2);
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, no result cache");
        return false;
      }
      try
      {
        paramString2 = new JSONObject(paramString1);
        if (!checkInterval(paramActivity))
        {
          paramString1 = parseMoreAppInfo(paramString2);
          if (paramString1 != null)
          {
            paramString2 = parseRecommendList(paramString2);
            if (paramString2 != null)
            {
              paramInt = paramString2.size();
              if (paramInt >= 3)
              {
                doShowRetainDialog(paramActivity, paramString1, paramString2, paramOnClickListener);
                updateShowTimes(i);
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("GameCloseManager", 1, "showRetainGuideDialog: not show, parse json error", paramActivity);
      }
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