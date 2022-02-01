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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.CommExtInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogForMiniGame;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import common.config.service.QzoneConfig;
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
  private static final int RETAIN_MAX_FRIEND_NUM = 3;
  private static final int RETAIN_RECOMMEND_APP_NUM = 3;
  private static final int SCENE_JUMPING_GAME = 2113;
  private static final String TAG = "GameCloseManager";
  private static ArrayList<GameCloseManager.MiniAppViewItem> miniAppViewItemArrayList = new ArrayList();
  
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
  
  @RequiresApi(api=16)
  private static void doShowRetainDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, MiniAppInfo paramMiniAppInfo, String paramString1, ArrayList<MiniAppInfo> paramArrayList, String paramString2, DialogInterface.OnClickListener paramOnClickListener, GameCloseManager.ChangeAllOnClickListener paramChangeAllOnClickListener)
  {
    Object localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainChangeAll", "https://sola.gtimg.cn/aoi/sola/20201023212055_vhmnkmRvWb.png");
    Object localObject2 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainBackgroundUrl", "https://sola.gtimg.cn/aoi/sola/20201026161621_WQxgnG17wP.png");
    String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainLeftBtnBackgroundUrl", "https://sola.gtimg.cn/aoi/sola/20201026161621_qKiWYA1Hc2.png");
    String str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "qqMiniappRetainRightBtnBackgroundUrl", "https://sola.gtimg.cn/aoi/sola/20201026161621_z77QU6MeWL.png");
    paramString2 = new QQCustomDialogForMiniGame(paramActivity, 2131755813);
    paramString2.setContentView(2131559084);
    paramString2.setBodyLayoutNoMargin();
    paramString2.setBackground(2130841451);
    View localView = LayoutInflater.from(paramActivity).inflate(2131559528, null, false);
    Object localObject3 = (LinearLayout)localView.findViewById(2131371749);
    ((ImageView)localView.findViewById(2131371748)).setImageDrawable(MiniAppUtils.getDrawable((String)localObject1, null));
    GameCloseManager.ChangeAllOnClickListener.access$002(paramChangeAllOnClickListener, paramActivity);
    paramChangeAllOnClickListener.dialog = paramString2;
    paramChangeAllOnClickListener.closeListener = paramOnClickListener;
    ((LinearLayout)localObject3).setOnClickListener(paramChangeAllOnClickListener);
    localView.setBackground(MiniAppUtils.getDrawable((String)localObject2, null));
    paramChangeAllOnClickListener = new LinearLayout.LayoutParams(ViewUtils.b(296.0F), ViewUtils.b(255.0F));
    paramChangeAllOnClickListener.gravity = 17;
    localObject1 = (LinearLayout)localView.findViewById(2131376752);
    miniAppViewItemArrayList.clear();
    int i = 0;
    while (i < 3)
    {
      localObject2 = new GameCloseManager.MiniAppViewItem(paramActivity);
      localObject3 = (MiniAppInfo)paramArrayList.get(i);
      ((GameCloseManager.MiniAppViewItem)localObject2).setData((MiniAppInfo)localObject3, new GameCloseManager.1((MiniAppInfo)localObject3, paramString2, paramOnClickListener, paramActivity, paramMiniAppConfig));
      miniAppViewItemArrayList.add(localObject2);
      ((LinearLayout)localObject1).addView(GameCloseManager.MiniAppViewItem.access$200((GameCloseManager.MiniAppViewItem)localObject2));
      if (i != 2) {
        ((LinearLayout)localObject1).addView(GameCloseManager.MiniAppPatitionLineViewItem.access$300(new GameCloseManager.MiniAppPatitionLineViewItem(paramActivity)));
      }
      localObject2 = new MiniAppConfig((MiniAppInfo)localObject3);
      localObject3 = new LaunchParam();
      ((LaunchParam)localObject3).scene = 2113;
      ((MiniAppConfig)localObject2).launchParam = ((LaunchParam)localObject3);
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject2, "page_view", "expo", "", "");
      i += 1;
    }
    paramString2.setCancelable(true);
    paramString2.setTitle(null).setMessage(null).addView(localView, paramChangeAllOnClickListener).setNegativeButton(2131694215, new GameCloseManager.3(paramMiniAppInfo, paramOnClickListener, paramActivity, paramMiniAppConfig)).setPositiveButton(2131694216, new GameCloseManager.2(paramMiniAppInfo, paramString1, paramOnClickListener, paramActivity, paramMiniAppConfig));
    paramString2.getBtnight().setTypeface(Typeface.DEFAULT, 1);
    paramString2.getBtnight().setTextColor(-1);
    paramString2.getBtnight().setBackground(MiniAppUtils.getDrawable(str2, null));
    paramString2.getBtnLeft().setTypeface(Typeface.DEFAULT, 1);
    paramString2.getBtnLeft().setTextColor(-1);
    paramString2.getBtnLeft().setBackground(MiniAppUtils.getDrawable(str1, null));
    paramActivity = (LinearLayout.LayoutParams)paramString2.getBtnight().getLayoutParams();
    paramActivity.height = ViewUtils.b(52.0F);
    paramString2.getBtnight().setLayoutParams(paramActivity);
    paramActivity = (LinearLayout.LayoutParams)paramString2.getBtnLeft().getLayoutParams();
    paramActivity.height = ViewUtils.b(52.0F);
    paramString2.getBtnLeft().setLayoutParams(paramActivity);
    paramString2.show();
    MiniProgramLpReportDC04239.reportAsync(paramMiniAppConfig, "minigame_popup", "popup", "expo", "");
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
  
  private static CommExtInfo parseCommExtInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ext");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return null;
    }
    return (CommExtInfo)GsonUtils.json2Obj(paramJSONObject, CommExtInfo.class);
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
  
  private static int parsePopupType(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("popupType");
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
    paramGameActivity = DialogUtil.a(paramGameActivity, 230).setTitle(paramGameActivity.getString(2131719900)).setMessage(paramGameActivity.getString(2131694171)).setNegativeButton(paramGameActivity.getString(2131690800), new GameCloseManager.5()).setPositiveButton(paramGameActivity.getString(2131694170), new GameCloseManager.4(paramOnClickListener));
    paramGameActivity.setCancelable(false);
    paramGameActivity.show();
    return true;
  }
  
  public static boolean showRetainGuideDialog(Activity paramActivity, MiniAppConfig paramMiniAppConfig, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return false;
    }
    String str2 = paramMiniAppConfig.config.appId;
    int i;
    if (paramMiniAppConfig.launchParam == null)
    {
      i = 0;
      if (paramMiniAppConfig.config.via != null) {
        break label80;
      }
    }
    int j;
    label80:
    for (Object localObject1 = "";; localObject1 = paramMiniAppConfig.config.via)
    {
      j = paramMiniAppConfig.config.verType;
      if ((paramActivity != null) && (!TextUtils.isEmpty(str2))) {
        break label92;
      }
      return false;
      i = paramMiniAppConfig.launchParam.scene;
      break;
    }
    label92:
    int k = paramActivity.getRequestedOrientation();
    if ((k == 0) || (k == 8) || (k == 6) || (k == 11)) {}
    for (boolean bool = true; i == 2113; bool = false)
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, scene == 2113");
      return false;
    }
    int m = getShowTimes();
    if (m >= MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD)
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, show too many times");
      return false;
    }
    String str1 = getRetainInfoCache(str2, i, (String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, no result cache");
      return false;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(str1);
        MiniAppInfo localMiniAppInfo = parseMoreAppInfo((JSONObject)localObject2);
        if (localMiniAppInfo == null) {
          return false;
        }
        int n = parsePopupType((JSONObject)localObject2);
        if (n == 2)
        {
          QLog.i("GameCloseManager", 1, "showRetainGuideDialog: not show, popupType=INTERFACE.NotPopup");
          return false;
        }
        if ((n == 0) && (checkInterval(paramActivity))) {
          return false;
        }
        ArrayList localArrayList = parseRecommendList((JSONObject)localObject2);
        if ((localArrayList == null) || (localArrayList.size() < 3)) {
          break;
        }
        if (!bool)
        {
          str1 = parseBackgroundPic((JSONObject)localObject2);
          String str3 = parseMoreAppLink((JSONObject)localObject2);
          localObject2 = parseCommExtInfo((JSONObject)localObject2);
          QLog.i("GameCloseManager", 1, "orientation:" + k + " isLandscape:" + bool + " searchLeadImgUrl:" + str1 + " moreAppLink:" + str3);
          if (Build.VERSION.SDK_INT >= 16)
          {
            localObject1 = new GameCloseManager.ChangeAllOnClickListener(paramActivity, str2, j, i + "", (String)localObject1, paramMiniAppConfig);
            ((GameCloseManager.ChangeAllOnClickListener)localObject1).ext = ((CommExtInfo)localObject2);
            doShowRetainDialog(paramActivity, paramMiniAppConfig, localMiniAppInfo, str3, localArrayList, str1, paramOnClickListener, (GameCloseManager.ChangeAllOnClickListener)localObject1);
          }
          updateShowTimes(m);
          return true;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("GameCloseManager", 1, "showRetainGuideDialog: not show, parse json error", paramActivity);
        return false;
      }
      str1 = null;
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